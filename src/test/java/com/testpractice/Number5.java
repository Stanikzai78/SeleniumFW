package com.testpractice;

import java.util.Scanner;

public class Number5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number > 0) {
            System.out.println("You have entered a positive number i.e. " + number);
        } else if (number == 0) {
            System.out.println("You have entered zero i.e. " + number);
        } else {
            System.out.println("You have entered a negative number i.e. " + number);
        }

        sc.close();
    }
}