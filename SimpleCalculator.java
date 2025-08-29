import java.util.Scanner;

class Calculator {
    int num1;
    int num2;

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int Add() throws ArithmeticException {
        if (num1 < 0 || num2 < 0) {
            throw new ArithmeticException("Cannot add negative numbers.");
        }
        return num1 + num2;
    }

    public int Subtract() throws ArithmeticException {
        if (num1 < 0 || num2 < 0) {
            throw new ArithmeticException("Cannot subtract with negative numbers involved.");
        }
        return num1 - num2;
    }
}

public class CalculatorDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first integer for Calculator 1: ");
            int num1_obj1 = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the second integer for Calculator 1: ");
            int num2_obj1 = Integer.parseInt(scanner.nextLine());
            Calculator calculator1 = new Calculator(num1_obj1, num2_obj1);

            System.out.print("Enter the first integer for Calculator 2: ");
            int num1_obj2 = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the second integer for Calculator 2: ");
            int num2_obj2 = Integer.parseInt(scanner.nextLine());
            Calculator calculator2 = new Calculator(num1_obj2, num2_obj2);

            try {
                int sum = calculator1.Add();
                System.out.println("Addition (Calculator 1): " + sum);
            } catch (ArithmeticException e) {
                System.out.println("Error during addition (Calculator 1): " + e.getMessage());
            }

            try {
                int difference = calculator2.Subtract();
                System.out.println("Subtraction (Calculator 2): " + difference);
            } catch (ArithmeticException e) {
                System.out.println("Error during subtraction (Calculator 2): " + e.getMessage());
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter integer values only.");
        } finally {
            scanner.close();
        }
    }
}
