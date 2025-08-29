import java.util.Scanner;

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Read two integers for division
            System.out.print("Enter the numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Enter the denominator: ");
            int denominator = scanner.nextInt();

            // Perform division
            int result = numerator / denominator;
            System.out.println("Result of division: " + result);

            // Create an array and attempt to access an invalid index
            int[] array = {1, 2, 3, 4, 5};
            System.out.print("Enter an index to access in the array: ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + array[index]);

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            // Multi-catch block to handle both exceptions
            System.out.println("Exception occurred: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
