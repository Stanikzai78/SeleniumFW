package com.testpractice;

import org.testng.annotations.Test;

public abstract class NgParallelTest {
	@Test
	public void testMethod1() throws InterruptedException {
Thread.sleep(1000);
	System.out.println("Sleep time is 1 sec");		
//write code
	}
	@Test
	public void testMethod2() throws InterruptedException {
	Thread.sleep(10000);
	System.out.println("Sleep time is 10 sec");		
//write code
	}
@Test
	public void testMethod3() throws InterruptedException {
	Thread.sleep(5000);
	System.out.println("Sleep time is 5 sec");
	//write code
}
}