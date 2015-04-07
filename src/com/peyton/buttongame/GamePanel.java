package com.peyton.buttongame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class GamePanel extends JFrame implements ActionListener {
	private JLabel titleLabel;
	private JProgressBar progBar;
	private JButton clickButton;
	private int goal;
	private int level;
	private String endTimeFormatted;
	private long startTime = 0l, endTime = 0l;

	public GamePanel(int level) {
		//Init of Variables
		this.level = level;
		goal = level * 10;
		startTime = System.nanoTime();
		
		//Init format of Window
		setLayout(new BorderLayout());
		setMinimumSize(new Dimension(1000, 175));

		// LevelTitle
		titleLabel = new JLabel("<html><font color = 'blue'>LEVEL " + level
				+ "</html>");
		titleLabel.setFont(ButtonGameMain.TEXT_FONT);
		add(titleLabel, BorderLayout.NORTH);

		// ProgressBar
		progBar = new JProgressBar();
		progBar.setMaximum(goal);
		progBar.setValue(0);
		add(progBar, BorderLayout.CENTER);

		// Button
		clickButton = new JButton("Click ME!");
		clickButton.addActionListener(this);
		add(clickButton, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clickButton) {
			if (progBar.getValue() < goal - 1) {
				progBar.setValue(progBar.getValue() + 1);
			} else {
				endTime = System.nanoTime()-startTime;
				endTimeFormatted = Double.toString((double) (endTime/1000000000.0)) + " Seconds";
				progBar.setValue(progBar.getValue() + 1);
				setVisible(false);
				new EndGamePanel(level, endTimeFormatted);
			}
		}

	}
}
