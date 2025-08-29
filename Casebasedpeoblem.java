import java.util.Scanner;

public class OddDigitProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the positive integer input
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();
        
        // Call the method to calculate the product of odd digits
        String result = productOfOddDigits(n);
        
        // Print the result
        System.out.println(result);
        
        // Close the scanner
        scanner.close();
    }

    public static String productOfOddDigits(int n) {
        int product = 1;
        boolean foundOdd = false;

        while (n > 0) {
            int digit = n % 10; // Get the last digit
            if (digit % 2 != 0) { // Check if the digit is odd
                product *= digit;
                foundOdd = true;
            }
            n /= 10; // Remove the last digit
        }

        if (foundOdd) {
            return String.valueOf(product);
        } else {
            return "No odd digits found";
        }
    }
}
