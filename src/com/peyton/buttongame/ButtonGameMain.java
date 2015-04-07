package com.peyton.buttongame;

import java.awt.Font;

public class ButtonGameMain {

	public static final Font TEXT_FONT = new Font("Serif", Font.BOLD, 16);
	public static TimeHandler timeHandle = new TimeHandler();
	
	public static void main(String[] args) {
		System.out.println("Welcome to ButtonGame v01");
		new IntroPanel();

	}

}
