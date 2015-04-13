package com.peyton.buttongame;

import java.util.ArrayList;

public class TimeHandler {
	// fields
	private double[] times = new double[100];
	

	// Constructor
	public TimeHandler() {
		//Blank Constructor
	}

	// Methods
	public void addBestTime(String time, int level) {
		String timeinString = time.split(" ")[0];
		double actualTime = Double.parseDouble(timeinString);
		System.out.println("Actual Time: " + actualTime);
		if (times[level - 1] == 0) {
			times[level - 1] = actualTime;
		} else if (times[level - 1] > actualTime) {
			times[level-1] = actualTime;
		}
	}

	public String getBestTime(int level) {
		return times[level - 1] + " Seconds";
	}
}
