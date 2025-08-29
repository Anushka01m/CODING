import java.util.Scanner;

public class StringComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = null;
        String str2 = null;

        try {
            // Read two strings from the console
            System.out.print("Enter the first string: ");
            str1 = scanner.nextLine();
            System.out.print("Enter the second string: ");
            str2 = scanner.nextLine();

            // Compare the strings
            if (str1.equals(str2)) {
                System.out.println("The strings are equal.");
            } else {
                System.out.println("The strings are not equal.");
            }

        } catch (NullPointerException e) {
            // Handle NullPointerException
            System.out.println("A NullPointerException occurred: " + e.getMessage());
        } finally {
            // Finally block to indicate completion
            System.out.println("Program has completed.");
            scanner.close();
        }
    }
}
