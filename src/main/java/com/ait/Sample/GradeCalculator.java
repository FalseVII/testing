package com.ait.Sample;

public class GradeCalculator {
	
	private static final int MIN_MARK = 0;
	private static final int MAX_MARK = 20;
	
	public int calculateTotalMarks(int[] marksPerQuestion) {
		for (int mark : marksPerQuestion) {
			if (mark < MIN_MARK || mark > MAX_MARK) {
				throw new IllegalArgumentException("Invalid mark " + mark + " received");
			}
		}
		int totalMarks = 0;
		for (int mark : marksPerQuestion) {
			totalMarks += mark;
		}
		return totalMarks;
	}
	

}
