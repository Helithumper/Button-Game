package com.peyton.buttongame;

import java.util.ArrayList;

public class TimeHandler {
	// fields
	private ArrayList<Double> times = new ArrayList<Double>();

	// Constructor
	public TimeHandler() {

	}

	// Methods
	public void addBestTime(String time, int level) {
		if (level > times.size()) {
			for (int i = level - times.size(); i > 0; i--) {
				System.out.println(i);
				times.add(-1.1);
			}
		}
		String timeinString = time.split(" ")[0];
		double actualTime = Double.parseDouble(timeinString);
		System.out.println("Actual Time: " + actualTime);
		if (times.get(level - 1) == -1.1) {
			times.set(level - 1, actualTime);
		} else if (times.get(level - 1) > actualTime) {
			times.set(level - 1, actualTime);
		}
	}

	public String getBestTime(int level) {
		return times.get(level - 1) + " Seconds";
	}
}
