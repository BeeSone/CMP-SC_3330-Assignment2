package edu.mu.cmpsc3330.assignment2;

import java.util.List;

public class HelpDeskUtil {

    //Generic method to print any list of items
	public static <T> void printAll(List<T> items) {
		if (items != null) {
			for (T item : items) {
				System.out.println(item);
			}
		}
	}

    //sums up total service points
	public static int sumPoints(List<? extends Technician> technicians) {
		if (technicians == null) {
			return 0;
		}
		int totalPoints = 0;
		for (Technician tech : technicians) {
			totalPoints += tech.getServicePoints();
		}
		return totalPoints;
	}
}
