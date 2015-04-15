package com.peyton.buttongame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginScreen extends JFrame implements ActionListener {
	JLabel title, userLabel, passLabel;
	JPanel userPanel, passPanel;
	JTextField userField;
	JPasswordField passField;
	JButton loginButton;

	public LoginScreen() {
		setLayout(new GridLayout(4, 1));

		// Title
		title = new JLabel("Please enter Login for Button Game v01");
		title.setFont(ButtonGameMain.TEXT_FONT);
		add(title);

		// Login Panel
		userPanel = new JPanel();
		add(userPanel);
		// Login Label
		userLabel = new JLabel("Username:");
		userPanel.add(userLabel);
		// Login Field
		userField = new JTextField();
		userField.setColumns(20);
		userPanel.add(userField);

		// Pass Panel
		passPanel = new JPanel();
		add(passPanel);
		// Pass Label
		passLabel = new JLabel("Password:");
		passPanel.add(passLabel);
		// Pass Field
		passField = new JPasswordField();
		passField.setColumns(20);
		passPanel.add(passField);

		// Login Button
		loginButton = new JButton("Login!");
		loginButton.addActionListener(this);
		add(loginButton);
		
		setLocationRelativeTo(null);
		pack();
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginButton){
			if((userField.getText().length()>0) && (passField.getText().length()>0)){
			//Later Checking
			new IntroPanel();}
			else{
				ButtonGameMain.throwErrorBox("Empty Login or Password Fields", "Login Error");
			}
		}
		
	}
}
