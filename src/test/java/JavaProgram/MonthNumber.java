package JavaProgram;

public class MonthNumber {

    public static void main(String[] args) {

        int monthNum = 10;

        String month = switch (monthNum) {
            case 1  -> "January";
            case 2  -> "February";
            case 3  -> "March";
            case 4  -> "April";
            case 5  -> "May";
            case 6  -> "June";
            case 7  -> "July";
            case 8  -> "August";
            case 9  -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "No Valid Month";
        };

        System.out.println(month);
    }
}