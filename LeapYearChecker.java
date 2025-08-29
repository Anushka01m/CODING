import java.util.Scanner;
public class LeapYearChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year to check: ");
        int year = scanner.nextInt();

        boolean isLeapYear;

        // Check if the year is divisible by 4
        boolean divisibleBy4 = (year % 4 == 0);

        // Check if the year is divisible by 100
        boolean divisibleBy100 = (year % 100 == 0);

        // Check if the year is divisible by 400
        boolean divisibleBy400 = (year % 400 == 0);

        // Determine if it's a leap year using logical operators
        // A year is a leap year if:
        // (it is divisible by 4 AND NOT divisible by 100)
        // OR
        // (it IS divisible by 400)
        isLeapYear = (divisibleBy4 && !divisibleBy100) || divisibleBy400;

        // Output the result
        if (isLeapYear) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }

        // Test cases (you can uncomment these to quickly test common scenarios)
        /*
        System.out.println("\n--- Test Cases ---");
        testLeapYear(2000); // Leap (divisible by 400)
        testLeapYear(2020); // Leap (divisible by 4, not by 100)
        testLeapYear(1900); // Not Leap (divisible by 100, not by 400)
        testLeapYear(2021); // Not Leap
        testLeapYear(2024); // Leap
        testLeapYear(1600); // Leap
        */

        scanner.close();
    }

    /**
     * Helper method for testing specific years.
     * @param year The year to test.
     */
    public static void testLeapYear(int year) {
        boolean isLeap;
        isLeap = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
        if (isLeap) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }
}
