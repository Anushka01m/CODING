import java.util.Scanner;

public class PrimeCheck {
    // Method to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false; // 0 and 1 are not prime numbers
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // Found a divisor, not prime
            }
        }
        return true; // No divisors found, it is prime
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int N = scanner.nextInt();

        try {
            // Check if the number is prime
            if (isPrime(N)) {
                throw new PrimeNumberException(N + " is a Prime Number");
            } else {
                System.out.println(N + " is not a Prime Number");
            }
        } catch (PrimeNumberException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
