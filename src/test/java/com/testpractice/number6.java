package com.testpractice;

import java.util.Scanner;

public class number6 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter a number ");
			int num = sc.nextInt();
			System.out.println("\nTable of " + num);
			for (int i = 1; i <= 10; i++) {
				System.out.println(num + "*" + i + "=" + num * i);
			}
		}
			}

}
