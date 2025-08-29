// Employee.java - Abstract base class demonstrating dynamic binding
abstract class Employee {
    protected String name;
    protected int id;

    /**
     * Constructor for the Employee class.
     * @param name The name of the employee.
     * @param id The ID of the employee.
     */
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Abstract method to calculate the salary of an employee.
     * Subclasses must provide their own implementation for this method.
     * @return The calculated salary.
     */
    public abstract double calculateSalary();

    /**
     * Returns a string representation of the employee.
     * @return Employee's name and ID.
     */
    @Override
    public String toString() {
        return "Employee Name: " + name + ", ID: " + id;
    }
}

// FullTimeEmployee.java - Subclass extending Employee
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    /**
     * Constructor for FullTimeEmployee.
     * @param name The name of the full-time employee.
     * @param id The ID of the full-time employee.
     * @param monthlySalary The fixed monthly salary.
     */
    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    /**
     * Provides a concrete implementation for calculateSalary() for full-time employees.
     * @return The monthly salary.
     */
    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// PartTimeEmployee.java - Subclass extending Employee
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    /**
     * Constructor for PartTimeEmployee.
     * @param name The name of the part-time employee.
     * @param id The ID of the part-time employee.
     * @param hourlyRate The hourly rate of pay.
     * @param hoursWorked The number of hours worked.
     */
    public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    /**
     * Provides a concrete implementation for calculateSalary() for part-time employees.
     * @return The calculated salary based on hourly rate and hours worked.
     */
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

// Main.java - Main class to demonstrate dynamic binding
public class Main {

    /**
     * This method demonstrates dynamic binding. It takes an Employee object
     * and calls its calculateSalary() method. The actual method invoked
     * depends on the runtime type of the Employee object passed.
     * @param employee The Employee object (can be FullTimeEmployee or PartTimeEmployee).
     */
    public static void processEmployeeSalary(Employee employee) {
        System.out.println(employee); // Prints employee details using toString()
        double salary = employee.calculateSalary(); // Dynamic binding occurs here
        System.out.println("Calculated Salary: $" + String.format("%.2f", salary));
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        // Create instances of FullTimeEmployee and PartTimeEmployee
        FullTimeEmployee fullTimeEmp = new FullTimeEmployee("Alice Smith", 101, 5000.00);
        PartTimeEmployee partTimeEmp = new PartTimeEmployee("Bob Johnson", 102, 25.00, 120);

        System.out.println("--- Demonstrating Dynamic Binding ---");

        // Pass FullTimeEmployee instance to the generic method
        System.out.println("Processing Full-Time Employee:");
        processEmployeeSalary(fullTimeEmp);

        // Pass PartTimeEmployee instance to the generic method
        System.out.println("Processing Part-Time Employee:");
        processEmployeeSalary(partTimeEmp);

        // You can also create an Employee reference and assign different types at runtime
        Employee empRef;

        empRef = new FullTimeEmployee("Charlie Brown", 103, 6000.00);
        System.out.println("Processing Employee Reference (Full-Time):");
        processEmployeeSalary(empRef);

        empRef = new PartTimeEmployee("Diana Prince", 104, 30.00, 80);
        System.out.println("Processing Employee Reference (Part-Time):");
        processEmployeeSalary(empRef);
    }
}
