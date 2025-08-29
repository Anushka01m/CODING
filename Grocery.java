import java.util.ArrayList;

public class Grocery {
    public static void main(String[] args) {
        // Create ArrayLists for item IDs and names
        ArrayList<Integer> itemIds = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();

        // Add 10 items to each ArrayList
        for (int i = 1; i <= 10; i++) {
            itemIds.add(i); // Adding item IDs 1 to 10
            names.add("Vegetable " + i); // Adding vegetable names
        }

        // Display the ArrayLists before sorting
        System.out.println("Before Sorting:");
        displayLists(itemIds, names);

        // Create an instance of SortGrocery to sort and display the lists
        SortGrocery sortGrocery = new SortGrocery();
        sortGrocery.sortAndDisplay(itemIds, names);
    }

    // Method to display the lists
    public static void displayLists(ArrayList<Integer> itemIds, ArrayList<String> names) {
        System.out.println("Item IDs: " + itemIds);
        System.out.println("Names: " + names);
    }
}

import java.util.ArrayList;
import java.util.Collections;

public class SortGrocery {
    // Method to sort and display the lists
    public void sortAndDisplay(ArrayList<Integer> itemIds, ArrayList<String> names) {
        // Create copies of the original lists for sorting
        ArrayList<Integer> sortedItemIds = new ArrayList<>(itemIds);
        ArrayList<String> sortedNames = new ArrayList<>(names);

        // Sort the lists
        Collections.sort(sortedItemIds);
        Collections.sort(sortedNames);

        // Display the ArrayLists after sorting
        System.out.println("\nAfter Sorting:");
        System.out.println("Sorted Item IDs: " + sortedItemIds);
        System.out.println("Sorted Names: " + sortedNames);
    }
}
