// Abstract class Grade
abstract class Grade {
    // Abstract method to calculate CGPA
    public abstract double getCGPA();
}

// Class Sam that extends Grade
class Sam extends Grade {
    private double[] grades; // Array to hold grades for 4 subjects

    // Constructor to initialize grades
    public Sam(double grade1, double grade2, double grade3, double grade4) {
        grades = new double[]{grade1, grade2, grade3, grade4};
    }

    // Method to calculate CGPA
    @Override
    public double getCGPA() {
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        return total / grades.length; // CGPA calculation
    }
}

// Class John that extends Grade
class John extends Grade {
    private double[] grades; // Array to hold grades for 3 subjects

    // Constructor to initialize grades
    public John(double grade1, double grade2, double grade3) {
        grades = new double[]{grade1, grade2, grade3};
    }

    // Method to calculate CGPA
    @Override
    public double getCGPA() {
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        return total / grades.length; // CGPA calculation
    }
}

// Main class to test the program
public class CGPACalculator {
    public static void main(String[] args) {
        // Create an object for Sam with grades in 4 subjects
        Sam sam = new Sam(8.5, 9.0, 7.5, 8.0);
        // Create an object for John with grades in 3 subjects
        John john = new John(9.0, 8.5, 9.5);

        // Print the CGPA for both students
        System.out.printf("CGPA of Sam: %.2f%n", sam.getCGPA());
        System.out.printf("CGPA of John: %.2f%n", john.getCGPA());
    }
}
