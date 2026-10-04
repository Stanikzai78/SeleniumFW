package JavaProgram;

public class SchoolGrade {

    public static void main(String[] args) {

        byte grade = 20;

        boolean isValidGrade = grade > 0 && grade < 19;
        String result = "";

        if (isValidGrade) {
            if (grade >= 17) {
                result = "Grad School";
            } else if (grade >= 13) {
                result = "College";
            } else if (grade >= 9) {
                result = "High School";
            } else if (grade >= 6) {
                result = "Middle School";
            } else { // these numbers can only be 1-5
                result = "Elementary";
            }
        } else {
            result = "Invalid grade level";
        }

        System.out.println(result);
    }
}