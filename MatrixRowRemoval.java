import java.util.Scanner;

public class MatrixRowRemoval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the dimensions of the matrix
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        
        // Initialize the matrix
        int[][] matrix = new int[rows][cols];
        
        // Read the matrix elements
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        // Find the row with the highest sum
        int maxSumIndex = -1;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < rows; i++) {
            int currentSum = 0;
            for (int j = 0; j < cols; j++) {
                currentSum += matrix[i][j];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxSumIndex = i;
            }
        }
        
        // Create a new matrix without the row with the highest sum
        int[][] updatedMatrix = new int[rows - 1][cols];
        int updatedRowIndex = 0;
        
        for (int i = 0; i < rows; i++) {
            if (i != maxSumIndex) {
                updatedMatrix[updatedRowIndex] = matrix[i];
                updatedRowIndex++;
            }
        }
        
        // Print the updated matrix
        for (int i = 0; i < updatedMatrix.length; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(updatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
