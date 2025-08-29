myshop/
    MyPizza.java

package myshop;

import java.util.Scanner;

public class MyPizza {
    private double pizzaPrice;
    private double pepsiPrice;

    // Constructor to initialize prices
    public MyPizza(double pizzaPrice, double pepsiPrice) {
        this.pizzaPrice = pizzaPrice;
        this.pepsiPrice = pepsiPrice;
    }

    // Method to calculate and display the cost of the pizza
    public void pizzaCost() {
        System.out.println("Cost of the ordered pizza: " + pizzaPrice + " Rs");
    }

    // Method to calculate and display the cost of the addon (Pepsi)
    public void addonCost() {
        System.out.println("Cost of the ordered Pepsi: " + pepsiPrice + " Rs");
    }
}

MyAddon.java

import myshop.MyPizza;
import java.util.Scanner;

public class MyAddon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for pizza and Pepsi prices
        System.out.print("Enter the price of the pizza: ");
        double pizzaPrice = scanner.nextDouble();

        System.out.print("Enter the price of the Pepsi: ");
        double pepsiPrice = scanner.nextDouble();

        // Create an instance of MyPizza
        MyPizza myPizza = new MyPizza(pizzaPrice, pepsiPrice);

        // Display the costs
        myPizza.pizzaCost();
        myPizza.addonCost();

        // Close the scanner
        scanner.close();
    }
}
