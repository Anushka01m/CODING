import java.util.Scanner;

interface Student {
    // Abstract method to calculate grade
    String calculateGrade(int mark1, int mark2, int mark3);

    // Default method to display grade
    default void displayGrade(String grade) {
        System.out.println("Grade: " + grade);
    }
}

class Main implements Student {
    @Override
    public String calculateGrade(int mark1, int mark2, int mark3) {
        int average = (mark1 + mark2 + mark3) / 3;
        if (average >= 90 && average <= 100) {
            return "A";
        } else if (average >= 80 && average <= 89) {
            return "B";
        } else if (average >= 70 && average <= 79) {
            return "C";
        } else if (average >= 60 && average <= 69) {
            return "D";
        } else if (average >= 50 && average <= 59) {
            return "E";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main student = new Main();

        System.out.print("Enter Mark 1: ");
        int mark1 = scanner.nextInt();

        System.out.print("Enter Mark 2: ");
        int mark2 = scanner.nextInt();

        System.out.print("Enter Mark 3: ");
        int mark3 = scanner.nextInt();

        String grade = student.calculateGrade(mark1, mark2, mark3);
        student.displayGrade(grade);
        scanner.close();
    }
}
