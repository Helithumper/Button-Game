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
	private final Font textFont = new Font("Serif", Font.BOLD, 16);
	private JLabel titleLabel;
	private JProgressBar progBar;
	private JButton clickButton;
	private int goal;
	private int level;

	public GamePanel(int level) {
		this.level = level;
		goal = (int) Math.pow(2, level);
		setLayout(new BorderLayout());
		setMinimumSize(new Dimension(1000, 175));

		// LevelTitle
		titleLabel = new JLabel("<html><font color = 'blue'>LEVEL " + level
				+ "</html>");
		titleLabel.setFont(textFont);
		add(titleLabel,BorderLayout.NORTH);

		// ProgressBar
		progBar = new JProgressBar();
		progBar.setMaximum(goal);
		progBar.setValue(0);
		add(progBar,BorderLayout.CENTER);

		// Button
		clickButton = new JButton("Click ME!");
		clickButton.addActionListener(this);
		add(clickButton,BorderLayout.SOUTH);

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
				progBar.setValue(progBar.getValue() + 1);
				JOptionPane.showMessageDialog(new JFrame(),
						"You Just Completed Level " + level, "WINNER",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}
}
