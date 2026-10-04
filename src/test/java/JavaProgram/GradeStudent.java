package JavaProgram;

public class GradeStudent {

    public static void main(String[] args) {

        char grade = 'F';
        boolean isValidGrade = (grade >= 'A' && grade <= 'D') || grade == 'F';
        String result = "";

        if (isValidGrade) {
            if (grade == 'A') {
                result = "Excellent";
            } else if (grade == 'B') {
                result = "Great Job";
            } else if (grade == 'C') {
                result = "Good";
            } else if (grade == 'D') {
                result = "Passed";
            } else {
                result = "Failed";
            }
        } else {
            result = "Invalid Grade";
        }

        System.out.println(result);
    }
}