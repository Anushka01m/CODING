// InvalidAgeException.java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
        System.out.println("Welcome to Voting system");
    }
}

// Application.java
class Application {
    String candidateName;
    int age;
    String qualification;

    public Application(String name, int age, String qualification) {
        this.candidateName = name;
        this.age = age;
        this.qualification = qualification;
    }

    public void validate() throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Invalid Candidate: Age is less than 18.");
        } else {
            System.out.println("Application processed successfully.");
        }
    }

    public void evaluate() {
        try {
            validate();
            // Further evaluation logic if the candidate is valid
            System.out.println("Further evaluation in progress for " + candidateName);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Application candidate1 = new Application("Alice", 25, "Bachelor's");
        candidate1.evaluate();

        Application candidate2 = new Application("Bob", 15, "High School");
        candidate2.evaluate();
    }
}
