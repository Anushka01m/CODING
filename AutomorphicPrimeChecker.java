public class AutomorphicNumberException extends Exception {
    public AutomorphicNumberException(String message) {
        super(message);
    }
}

public class PrimeNumberException extends Exception {
    public PrimeNumberException(String message) {
        super(message);
    }
}

public class NonPrimeException extends Exception {
    public NonPrimeException(String message) {
        super(message);
    }
}

import java.util.Scanner;

public class AutomorphicPrimeChecker {

    // Method to check if a number is Automorphic
    public static boolean isAutomorphic(int n) {
        int square = n * n;
        return String.valueOf(square).endsWith(String.valueOf(n));
    }

    // Method to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false; // 0 and 1 are not prime numbers
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int N = scanner.nextInt();

        try {
            // Check if the number is Automorphic
            if (isAutomorphic(N)) {
                throw new AutomorphicNumberException(N + " is an Automorphic Number");
            }

            // Check if the number is prime
            if (isPrime(N)) {
                throw new PrimeNumberException(N + " is a Prime Number");
            } else {
                throw new NonPrimeException(N + " is not a Prime Number");
            }

        } catch (AutomorphicNumberException e) {
            System.out.println(e.getMessage());
        } catch (PrimeNumberException e) {
            System.out.println(e.getMessage());
        } catch (NonPrimeException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
