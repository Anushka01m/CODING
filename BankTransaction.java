import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Singleton class to manage bank accounts
class BankAccountManager 
{
    private static BankAccountManager instance;
    private double balance;
    private Lock lock = new ReentrantLock();

    private BankAccountManager() {
        balance = 1000; // Initial balance
    }

    public static BankAccountManager getInstance() {
        if (instance == null) {
            instance = new BankAccountManager();
        }
        return instance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited $" + amount + ". New balance: $" + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrew $" + amount + ". New balance: $" + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to withdraw $" + amount + ". Insufficient funds.");
            }
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Builder pattern for creating Customer objects
class Customer {
    private String name;
    private double depositAmount;
    private double withdrawAmount;

    private Customer(CustomerBuilder builder) {
        this.name = builder.name;
        this.depositAmount = builder.depositAmount;
        this.withdrawAmount = builder.withdrawAmount;
    }

    public String getName() {
        return name;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public static class CustomerBuilder {
        private String name;
        private double depositAmount;
        private double withdrawAmount;

        public CustomerBuilder(String name) {
            this.name = name;
        }

        public CustomerBuilder setDepositAmount(double depositAmount) {
            this.depositAmount = depositAmount;
            return this;
        }

        public CustomerBuilder setWithdrawAmount(double withdrawAmount) {
            this.withdrawAmount = withdrawAmount;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}

// Runnable class for customer transactions
class TransactionTask implements Runnable {
    private Customer customer;

    public TransactionTask(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        BankAccountManager manager = BankAccountManager.getInstance();
        if (customer.getDepositAmount() > 0) {
            manager.deposit(customer.getDepositAmount());
        }
        if (customer.getWithdrawAmount() > 0) {
            manager.withdraw(customer.getWithdrawAmount());
        }
    }
}

// Main class to simulate the bank transaction system
public class BankTransactionSystem {
    public static void main(String[] args) {
        // Create customers using the Builder pattern
        Customer customer1 = new Customer.CustomerBuilder("Alice")
                .setDepositAmount(200)
                .setWithdrawAmount(100)
                .build();

        Customer customer2 = new Customer.CustomerBuilder("Bob")
                .setDepositAmount(300)
                .setWithdrawAmount(500)
                .build();

        Customer customer3 = new Customer.CustomerBuilder("Charlie")
                .setDepositAmount(150)
                .setWithdrawAmount(200)
                .build();

        // Create threads for each customer
        Thread thread1 = new Thread(new TransactionTask(customer1), "Customer 1");
        Thread thread2 = new Thread(new TransactionTask(customer2), "Customer 2");
        Thread thread3 = new Thread(new TransactionTask(customer3), "Customer 3");

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // Display final balance
        System.out.println("Final balance: $" + BankAccountManager.getInstance().getBalance());
    }
}
