class Employee
{
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateNetSalary() {
        return baseSalary; // Base class does not calculate net salary
    }
}

// Derived class for Engineers
class Engineer extends Employee {
    protected double bonus;

    public Engineer(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateNetSalary() {
        double grossSalary = baseSalary + bonus;
        double tax = grossSalary * 0.10; // 10% tax for Engineers
        double benefit = 100.0; // Benefit for Engineers
        return grossSalary - tax + benefit;
    }
}

// Derived class for Software Engineers
class SoftwareEngineer extends Engineer {
    public SoftwareEngineer(String name, double baseSalary, double bonus) {
        super(name, baseSalary, bonus);
    }

    @Override
    public double calculateNetSalary() {
        double grossSalary = baseSalary + bonus;
        double tax = grossSalary * 0.15; // 15% tax for Software Engineers
        double benefit = 150.0; // Benefit for Software Engineers
        return grossSalary - tax + benefit;
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        // Sample input
        String name = "John Doe"; // Example name
        double baseSalary = 800.0; // Example base salary
        double bonus = 200.0; // Example bonus
        int employeeType = 2; // 1 for Engineer, 2 for Software Engineer

        Employee employee;
        if (employeeType == 1) {
            employee = new Engineer(name, baseSalary, bonus);
        } else if (employeeType == 2) {
            employee = new SoftwareEngineer(name, baseSalary, bonus);
        } else {
            throw new IllegalArgumentException("Invalid employee type");
        }

        // Calculate and print the net salary
        double netSalary = employee.calculateNetSalary();
        System.out.printf("%.2f%n", netSalary); // Output format
    }
}
