package com.peyton.buttongame;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IntroPanel extends JFrame implements ActionListener {
	private final Font textFont = new Font("Serif", Font.BOLD, 16);
	private JLabel title, instructions;
	private JTextField inputField;
	private JButton enterButton;

	public IntroPanel() {
		setLayout(new GridLayout(4, 1));

		// Title
		title = new JLabel("<html><font color = 'blue'>Button Game v01</html>");
		title.setFont(textFont);
		JPanel titlePanel = new JPanel();
		titlePanel.add(title);
		add(titlePanel);

		// Directions
		instructions = new JLabel(
				"<html><font color = 'blue'>Please Enter Your Level</html>");
		instructions.setFont(textFont);
		JPanel instructionsPanel = new JPanel();
		instructionsPanel.add(instructions);
		add(instructionsPanel);

		// Input box
		inputField = new JTextField();
		inputField.setColumns(3);
		JPanel inputPanel = new JPanel();
		inputPanel.add(inputField);
		add(inputPanel);

		// Button
		enterButton = new JButton("Enter");
		enterButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(enterButton);
		add(buttonPanel);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enterButton) {
			if (isValidInteger(inputField.getText())) {
				//System.out.println("MAKING GAME WITH: " + inputField.getText());
				new GamePanel(Integer.parseInt(inputField.getText()));
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "\"" + inputField.getText() + "\"" + " Is not a valid integer", "Input Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private boolean isValidInteger(String i) {
		try {
			Integer.parseInt(i);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}
}
