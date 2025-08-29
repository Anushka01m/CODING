// File: Banking.java
public class Banking {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initial balance of $1000

        // Create a thread for depositing money
        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(200.0); // Deposit $200 five times
                try {
                    Thread.sleep(100); // Sleep for a short time to simulate processing
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Create a thread for withdrawing money
        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(150.0); // Withdraw $150 five times
                try {
                    Thread.sleep(150); // Sleep for a short time to simulate processing
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Start both threads
        depositThread.start();
        withdrawThread.start();

        // Wait for both threads to finish
        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Final balance
        System.out.println("Final balance: " + account.getBalance());
    }
}
