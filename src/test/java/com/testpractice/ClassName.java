package com.testpractice;

import java.util.Scanner;

public class ClassName {
public static void main(String[] args) 
{
double principal;
double rate;
double time;

	try (Scanner sc = new Scanner(System.in)) {
		System.out.print("Enter the principal amount  ");
		principal = sc.nextDouble();
		System.out.print("Enter the rate of interest ");
		rate = sc.nextDouble();
		System.out.print("Enter the time ");
		time = sc.nextDouble();
	}
	double interest = (principal * rate * time) / 100;
	System.out.println("The calculated Simple Interest is  " + interest);
}
}


