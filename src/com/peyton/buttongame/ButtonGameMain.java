package com.peyton.buttongame;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ButtonGameMain {

	
	public static void throwErrorBox(String message, String title) {
		JOptionPane.showMessageDialog(new JFrame(), message, title,
				JOptionPane.ERROR_MESSAGE);
	}
	public static final Font TEXT_FONT = new Font("Serif", Font.BOLD, 16);
	public static TimeHandler timeHandle = new TimeHandler();
	
	public static void main(String[] args) {
		System.out.println("Welcome to ButtonGame v01");
		new LoginScreen();

	}

}
