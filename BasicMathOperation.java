public class MathOperation {

    // Generic method to perform mathematical operations
    public <T extends Number> double performOperation(T num1, T num2, String operation) {
        double result = 0.0;

        switch (operation) {
            case "add":
                result = num1.doubleValue() + num2.doubleValue();
                break;
            case "subtract":
                result = num1.doubleValue() - num2.doubleValue();
                break;
            case "multiply":
                result = num1.doubleValue() * num2.doubleValue();
                break;
            case "divide":
                if (num2.doubleValue() != 0) {
                    result = num1.doubleValue() / num2.doubleValue();
                } else {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }

        return result;
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        MathOperation mathOperation = new MathOperation();

        // Performing addition on two integers
        int int1 = 10;
        int int2 = 20;
        double additionResult = mathOperation.performOperation(int1, int2, "add");
        System.out.println("Addition of " + int1 + " and " + int2 + " is: " + additionResult);

        // Performing multiplication on two doubles
        double double1 = 5.5;
        double double2 = 4.0;
        double multiplicationResult = mathOperation.performOperation(double1, double2, "multiply");
        System.out.println("Multiplication of " + double1 + " and " + double2 + " is: " + multiplicationResult);

        // Performing subtraction on two floats
        float float1 = 15.5f;
        float float2 = 5.5f;
        double subtractionResult = mathOperation.performOperation(float1, float2, "subtract");
        System.out.println("Subtraction of " + float1 + " and " + float2 + " is: " + subtractionResult);
    }
}
