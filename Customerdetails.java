public class Customer {
    private int cid;
    private String cname;
    private PermanentAddress permanentAddress;
    private CommunicationAddress communicationAddress;

    // Constructor
    public Customer(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
        this.permanentAddress = new PermanentAddress();
        this.communicationAddress = new CommunicationAddress();
    }

    // Setters for addresses
    public void setPermanentAddress(String street, String zipcode) {
        permanentAddress.street = street;
        permanentAddress.zipcode = zipcode;
    }

    public void setCommunicationAddress(String street, String zipcode) {
        communicationAddress.street = street;
        communicationAddress.zipcode = zipcode;
    }

    // Static inner class for Permanent Address
    public static class PermanentAddress {
        private String street;
        private String zipcode;

        // Getters
        public String getStreet() {
            return street;
        }

        public String getZipcode() {
            return zipcode;
        }
    }

    // Non-static inner class for Communication Address
    public class CommunicationAddress {
        private String street;
        private String zipcode;

        // Getters
        public String getStreet() {
            return street;
        }

        public String getZipcode() {
            return zipcode;
        }
    }

    // Method to display address details
    public void displayAddressDetails() {
        if (permanentAddress.zipcode.equals(communicationAddress.zipcode)) {
            System.out.println("Permanent Address:");
            System.out.println("Street: " + permanentAddress.getStreet());
            System.out.println("Zipcode: " + permanentAddress.getZipcode());
        } else {
            System.out.println("Communication Address:");
            System.out.println("Street: " + communicationAddress.getStreet());
            System.out.println("Zipcode: " + communicationAddress.getZipcode());
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Customer object
        System.out.print("Enter Customer ID: ");
        int cid = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Customer Name: ");
        String cname = scanner.nextLine();

        Customer customer = new Customer(cid, cname);

        // Set Permanent Address
        System.out.print("Enter Permanent Address Street: ");
        String permStreet = scanner.nextLine();
        System.out.print("Enter Permanent Address Zipcode: ");
        String permZipcode = scanner.nextLine();
        customer.setPermanentAddress(permStreet, permZipcode);

        // Set Communication Address
        System.out.print("Enter Communication Address Street: ");
        String commStreet = scanner.nextLine();
        System.out.print("Enter Communication Address Zipcode: ");
        String commZipcode = scanner.nextLine();
        customer.setCommunicationAddress(commStreet, commZipcode);

        // Display address details
        customer.displayAddressDetails();

        scanner.close();
    }
}
