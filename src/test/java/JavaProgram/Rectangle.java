package JavaProgram;

public class Rectangle {

    public static void main(String[] args) {

        double length = 8.1, width = 4.2;
        double area = length * width;
        double perimeter = 2 * (length + width);

        System.out.println("The area of the rectangle is " + area);
        System.out.println("The perimeter of rectangle is " + perimeter);
    }

	public double width;
	public double length;
}