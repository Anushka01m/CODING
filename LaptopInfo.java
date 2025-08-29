public class Laptop {
    private String brand;
    private String processor;
    private int yearOfPurchase;
    private double price;

    // Constructor
    public Laptop(String brand, String processor, int yearOfPurchase, double price) {
        this.brand = brand;
        this.processor = processor;
        this.yearOfPurchase = yearOfPurchase;
        this.price = price;
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getProcessor() {
        return processor;
    }

    public int getYearOfPurchase() {
        return yearOfPurchase;
    }

    public double getPrice() {
        return price;
    }
}

public class LaptopWorking {
    private String brand;
    private String processor;
    private int yearOfPurchase;
    private double price;

    // Constructor
    public LaptopWorking(String brand, String processor, int yearOfPurchase, double price) {
        if (brand == null) {
            throw new NullPointerException("Brand cannot be null");
        }
        if (price < 0) {
            throw new NumberFormatException("Price cannot be negative");
        }

        this.brand = brand;
        this.processor = processor;
        this.yearOfPurchase = yearOfPurchase;
        this.price = price;
    }

    // Method to convert brand to a number format (for demonstration)
    public int convertBrandToNumber() {
        return brand.hashCode(); // Using hashCode as a simple conversion to number
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getProcessor() {
        return processor;
    }

    public int getYearOfPurchase() {
        return yearOfPurchase;
    }

    public double getPrice() {
        return price;
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input for Laptop
            System.out.print("Enter brand: ");
            String brand = scanner.nextLine();

            System.out.print("Enter processor: ");
            String processor = scanner.nextLine();

            System.out.print("Enter year of purchase: ");
            int yearOfPurchase = scanner.nextInt();

            System.out.print("Enter price: ");
            double price = scanner.nextDouble();

            // Create LaptopWorking object
            LaptopWorking laptopWorking = new LaptopWorking(brand, processor, yearOfPurchase, price);

            // Display brand in number format
            System.out.println("Brand in number format: " + laptopWorking.convertBrandToNumber());

        } catch (NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
