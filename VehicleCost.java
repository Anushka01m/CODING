interface Vehicle {
    double getBasicCost();
    int getCarriageCapacity();
    void displayDetails();
}

class Car implements Vehicle {
    private double basicCost;
    private int numberOfSeats;

    public Car(double basicCost, int numberOfSeats) {
        this.basicCost = basicCost;
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public double getBasicCost() {
        return basicCost;
    }

    @Override
    public int getCarriageCapacity() {
        return numberOfSeats;
    }

    @Override
    public void displayDetails() {
        System.out.println("Vehicle Type: Car");
        System.out.println("Basic Cost: $" + getBasicCost());
        System.out.println("Number of Seats: " + getCarriageCapacity());
        System.out.println("--------------------");
    }
}

class Bicycle implements Vehicle {
    private double basicCost;

    public Bicycle(double basicCost) {
        this.basicCost = basicCost;
    }

    @Override
    public double getBasicCost() {
        return basicCost;
    }

    @Override
    public int getCarriageCapacity() {
        return 1; // A bicycle typically carries one person
    }

    @Override
    public void displayDetails() {
        System.out.println("Vehicle Type: Bicycle");
        System.out.println("Basic Cost: $" + getBasicCost());
        System.out.println("Carriage Capacity: " + getCarriageCapacity() + " person");
        System.out.println("--------------------");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Car myCar = new Car(25000, 5);
        Bicycle myBike = new Bicycle(300);

        myCar.displayDetails();
        myBike.displayDetails();
    }
}
