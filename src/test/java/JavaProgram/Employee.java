package JavaProgram;

public class Employee {

	    private String name;
		private int age;
		private char gender;
		private String jobTitle;
		private int salary;

		public static void main(String[] args) {

	        Employee employee1 = new Employee();
	        employee1.name     = "James Bond";
	        employee1.age      = 45;
	        employee1.gender   = 'M';
	        employee1.jobTitle = "Secret Agent";
	        employee1.salary   = 1_000_000;

	        System.out.println(employee1.name);
	        System.out.println(employee1.age);
	        System.out.println(employee1.gender);
	        System.out.println(employee1.jobTitle);
	        System.out.println(employee1.salary);

	        Employee employee2 = new Employee();
	        employee2.name     = "Anna Smith";
	        employee2.age      = 27;
	        employee2.gender   = 'F';
	        employee2.jobTitle = "CEO";
	        employee2.salary   = 10_000_000;

	        System.out.println(employee2.name);
	        System.out.println(employee2.age);
	        System.out.println(employee2.gender);
	        System.out.println(employee2.jobTitle);
	        System.out.println(employee2.salary);
	    }
	}