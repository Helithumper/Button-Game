package com.peyton.buttongame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndGamePanel extends JFrame implements ActionListener {
	// fields

	private int level;
	private String completedTime;
	private JLabel levelLabel, timeLabel, bestLabel, beatLabel;
	private JButton retryButton, advanceButton;
	private JPanel levelPanel, timePanel, retryPanel, advancePanel, bestPanel,
			beatPanel;

	// constructor
	public EndGamePanel(int level, String completedTime) {
		this.level = level;
		this.completedTime = completedTime;

		if (!isLoser()) {
			instantiateWinnerFrame();
		} else {
			instantiateLoserFrame();

		}
	}

	// AM

	// Methods

	private void instantiateWinnerFrame() {
		ButtonGameMain.timeHandle.addBestTime(completedTime, level);

		setLayout(new GridLayout(5, 1));

		// TextLine1: Level Number + "Completed"
		levelLabel = new JLabel(
				"<html><font color = 'blue'>Level <font color = 'red'>" + level
						+ "<font color = 'blue'> Completed!<html>");
		levelLabel.setFont(ButtonGameMain.TEXT_FONT);

		levelPanel = new JPanel();
		levelPanel.add(levelLabel);
		add(levelPanel);
		// TextLine2: Time Completed
		timeLabel = new JLabel(
				"<html><font color = 'blue'>Time Completed: <font color = 'red'>"
						+ completedTime + "</html>");
		timeLabel.setFont(ButtonGameMain.TEXT_FONT);

		timePanel = new JPanel();
		timePanel.add(timeLabel);
		add(timePanel);

		// TextLine3: Best Time
		bestLabel = new JLabel(
				"<html><font color = 'blue'>Best Time: <font color = 'red'>"
						+ ButtonGameMain.timeHandle.getBestTime(level)
						+ "</html>");
		bestLabel.setFont(ButtonGameMain.TEXT_FONT);

		bestPanel = new JPanel();
		bestPanel.add(bestLabel);
		add(bestPanel);
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

	private void instantiateLoserFrame() {
		setLayout(new GridLayout(4, 1));

		// LevelLabel
		levelLabel = new JLabel("YOU LOST!");
		levelLabel.setFont(ButtonGameMain.TEXT_FONT);

		levelPanel = new JPanel();
		levelPanel.add(levelLabel);
		add(levelPanel);

		// Time Label
		timeLabel = new JLabel(
				"<html><font color = 'blue'>Time Completed: <font color = 'red'>"
						+ completedTime + "</html>");
		timeLabel.setFont(ButtonGameMain.TEXT_FONT);

		timePanel = new JPanel();
		timePanel.add(timeLabel);
		add(timePanel);

		// Time You need to beat:
		beatLabel = new JLabel(
				"<html><font color = 'blue'>Goal: <font color = 'red'>"
						+ ((double) ((.404 * level) + 9.596))
						+ " Seconds</html>");
		beatLabel.setFont(ButtonGameMain.TEXT_FONT);

		beatPanel = new JPanel();
		beatPanel.add(beatLabel);
		add(beatPanel);

		// Retry Button
		retryButton = new JButton("Retry?");
		retryButton.addActionListener(this);
		retryPanel = new JPanel();
		retryPanel.add(retryButton);
		add(retryPanel);

		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == retryButton) {
			setVisible(false);
			new GamePanel(level);
		} else if (e.getSource() == advanceButton) {
			setVisible(false);
			new GamePanel(level + 1);
		}
	}

	private boolean isLoser() {
		if (level < 100) {
			return Double.parseDouble(completedTime.split(" ")[0]) > (.404 * level) + 9.596;
		} else {
			return Double.parseDouble(completedTime.split(" ")[0]) > (level * 10) / 20;
		}

	}


	// toString
}
