package com.testpractice;

public class Number9 {
    String empname;
    int empid;
    String department;

    public void printInfo() {
        System.out.println("Employee Name: " + empname);
        System.out.println("Employee ID: " + empid);
        System.out.println("Employee Department: " + department);
    }

    public static void main(String[] args) {
        Number9 emp1 = new Number9();
        emp1.empname = "John";
        emp1.empid = 54;
        emp1.department = "Management";
        emp1.printInfo();
    }
}