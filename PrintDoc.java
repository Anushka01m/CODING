public class Printer {
    // Synchronized method to print the document
    public synchronized void printDocument(String document) {
        System.out.println(Thread.currentThread().getName() + " started printing: " + document);
        
        // Synchronized block simulating critical section (e.g., accessing printer hardware)
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " is accessing printer hardware for: " + document);
            try {
                Thread.sleep(1000); // Simulate time taken to print
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + " finished accessing printer hardware for: " + document);
        }
        
        System.out.println(Thread.currentThread().getName() + " completed printing: " + document);
    }

    public static void main(String[] args) {
        Printer printer = new Printer();

        // Runnable task to print documents
        Runnable printTask = () -> {
            String documentName = "Document-" + Thread.currentThread().getId();
            printer.printDocument(documentName);
        };

        // Create and start multiple threads to print concurrently
        Thread t1 = new Thread(printTask, "Thread-1");
        Thread t2 = new Thread(printTask, "Thread-2");
        Thread t3 = new Thread(printTask, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        // Wait for threads to complete
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
