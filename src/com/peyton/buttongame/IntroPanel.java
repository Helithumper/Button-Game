package com.peyton.buttongame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IntroPanel extends JFrame implements ActionListener, KeyListener {
	private JLabel title, instructions;
	private JTextField inputField;
	private JButton enterButton;
	private JPanel titlePanel, instructionsPanel, inputPanel, buttonPanel;

	public IntroPanel() {
		initializeFrame();
	}
	
	public void initializeFrame(){
		setLayout(new GridLayout(4, 1));

		// Title
		title = new JLabel("<html><font color = 'blue'>Button Game v01</html>");
		title.setFont(ButtonGameMain.TEXT_FONT);
		titlePanel = new JPanel();
		titlePanel.add(title);
		add(titlePanel);

		// Directions
		instructions = new JLabel(
				"<html><font color = 'blue'>Please Enter A Level Between 1 and 100</html>");
		instructions.setFont(ButtonGameMain.TEXT_FONT);
		instructionsPanel = new JPanel();
		instructionsPanel.add(instructions);
		add(instructionsPanel);

		// Input box
		inputField = new JTextField();
		inputField.setColumns(3);
		inputField.addActionListener(this);
		inputField.addKeyListener(this);
		inputPanel = new JPanel();
		inputPanel.add(inputField);
		add(inputPanel);

		// Button
		enterButton = new JButton("Enter");
		enterButton.addActionListener(this);
		buttonPanel = new JPanel();
		buttonPanel.add(enterButton);
		add(buttonPanel);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enterButton || e.getSource() == inputField) {
			buttonAct(inputField.getText());
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

	private void buttonAct(String text) {
		if (isValidInteger(text) && Integer.parseInt(text) <= 100
				&& Integer.parseInt(text) >= 1) {
			// System.out.println("MAKING GAME WITH: " + inputField.getText());
			setVisible(false);
			new GamePanel(Integer.parseInt(text));
		} else {
			throwErrorBox("\"" + text + "\""
					+ " Is not a valid level between 1 and 100", "Input Error");
		}
	}

	private void throwErrorBox(String message, String title) {
		JOptionPane.showMessageDialog(new JFrame(), message, title,
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		buttonAct(inputField.getText());
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
