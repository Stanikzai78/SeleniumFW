package com.testpractice;

import org.testng.annotations.Test;

public class NgIgnoreTest {
	@Test
	public void testMethod1() {
		System.out.println("I am test Method 1");
		//write code
	}
	@Test(enabled=false)
	public void testMethod2() {
		System.out.println("I am test Method 2");
		//write code
	}
@Test
	public void testMethod3() {
		System.out.println("I am test Method 3");
		//write code
	}
}
