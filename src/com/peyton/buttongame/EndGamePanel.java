package com.peyton.buttongame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndGamePanel extends JFrame implements ActionListener {
	// fields

	private int level;
	private String completedTime;
	private JLabel levelLabel, timeLabel;
	private JButton retryButton, advanceButton;
	private JPanel levelPanel, timePanel, retryPanel, advancePanel;

	// constructor
	public EndGamePanel(int level, String completedTime) {
		this.level = level;
		this.completedTime = completedTime;

		setLayout(new GridLayout(4, 1));

		// TextLine1: Level Number + "Completed"
		levelLabel = new JLabel("Level " + level + " Completed!");
		levelLabel.setFont(ButtonGameMain.TEXT_FONT);

		levelPanel = new JPanel();
		levelPanel.add(levelLabel);
		add(levelPanel);

		// TextLine2: Time Completed
		timeLabel = new JLabel("Time Completed: " + completedTime);
		timeLabel.setFont(ButtonGameMain.TEXT_FONT);

		timePanel = new JPanel();
		timePanel.add(timeLabel);
		add(timePanel);

		// Button1: Retry
		retryButton = new JButton("Retry?");
		retryButton.addActionListener(this);
		
		retryPanel = new JPanel();
		retryPanel.add(retryButton);
		add(retryPanel);

		// Button2: Advance to Next Level
		advanceButton = new JButton("Advance to Next Level?");
		advanceButton.addActionListener(this);

		advancePanel = new JPanel();
		advancePanel.add(advanceButton);
		add(advancePanel);

		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}

	// AM
	

	// Methods
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==retryButton){
			setVisible(false);
			new GamePanel(level);
		}
		else if(e.getSource()==advanceButton){
			setVisible(false);
			new GamePanel(level+1);
		}
	}
	
	// toString
}
