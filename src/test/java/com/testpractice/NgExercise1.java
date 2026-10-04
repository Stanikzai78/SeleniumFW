package com.testpractice;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class NgExercise1 {

	public int addition(int a, int b) {
		int c = a + b;
		return c;
	}

	@Test
	public void testaddition() {
		int a = 50;
		int b = 135;
		int expectedsum = 185;
		int actualsum = addition(a, b);
		assertEquals(actualsum, expectedsum, "The sum is not as expected. Expected sum is " + expectedsum + " and actual sum is " + actualsum);
		System.out.println("The expected sum is " + expectedsum + " and actual sum is " + actualsum);
	}
}