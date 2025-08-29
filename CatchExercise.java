public class CatchExercise {
    public static void main(String[] args) {
        try {
            // Outer try block
            int[] a = new int[5];
            a[3] = 30 / 0; // This will throw ArithmeticException

            try {
                // Inner try block
                System.out.println("Value at a[10]: " + a[10]); // This will throw ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Caught an ArrayIndexOutOfBoundsException: " + e.getMessage());
            }

        } catch (ArithmeticException e) {
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
        }

        System.out.println("Program continues after handling exceptions.");
    }
}
