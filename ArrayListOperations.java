import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListOperations {
    public static void main(String[] args) {
        // Create an ArrayList with initial values
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("kiwi");
        fruits.add("orange");
        fruits.add("pineapple");
        fruits.add("grapes");
        fruits.add("banana");

        // Print the initial list
        System.out.println("Initial list: " + fruits);

        // Prompt user for input and add "watermelon" at index 2
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a new fruit to add: ");
        String newFruit = scanner.nextLine();
        fruits.add(2, newFruit);

        // Print the updated list
        System.out.println("List after adding " + newFruit + ": " + fruits);

        // Remove "kiwi" from the list
        fruits.remove("kiwi");

        // Print the list after removing "kiwi"
        System.out.println("List after removing kiwi: " + fruits);

        // Sort the list in ascending order
        Collections.sort(fruits);

        // Print the sorted list
        System.out.println("Sorted list: " + fruits);

        scanner.close();
    }
}
