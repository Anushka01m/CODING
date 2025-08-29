import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read height and weight from the user
        System.out.print("Enter height in meters: ");
        double height = scanner.nextDouble();
        
        System.out.print("Enter weight in kilograms: ");
        double weight = scanner.nextDouble();
        
        // Calculate BMI
        double bmi = calculateBMI(weight, height);
        
        // Print BMI rounded to two decimal places
        System.out.printf("BMI: %.2f%n", bmi);
        
        // Determine and print the classification
        String classification = classifyBMI(bmi);
        System.out.println("Classification: " + classification);
        
        // Close the scanner
        scanner.close();
    }

    // Method to calculate BMI
    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    // Method to classify BMI
    public static String classifyBMI(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal Weight";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
