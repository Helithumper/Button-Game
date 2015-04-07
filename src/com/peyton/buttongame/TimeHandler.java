package com.peyton.buttongame;

import java.util.ArrayList;

public class TimeHandler {
	// fields
	private ArrayList<Double> times = new ArrayList<Double>();

	// Constructor
	public TimeHandler() {
		for(int i = 0; i < 10000; i++){
			times.add(10000000000000.0);
		}
	}

	// Methods
	public void addBestTime(String time, int level) {

		String timeinString = time.split(" ")[0];
		double actualTime = Double.parseDouble(timeinString);
		System.out.println("Actual Time: " + actualTime);
		if (times.get(level - 1) > actualTime) {
			times.set(level - 1, actualTime);
		}
	}

	public String getBestTime(int level) {
		return times.get(level - 1) + " Seconds";
	}
}
