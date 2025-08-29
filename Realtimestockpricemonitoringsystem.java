import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Stock class representing a stock with a name and price
class Stock {
    private String name;
    private double price;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

// StockPriceUpdater thread to simulate real-time price updates
class StockPriceUpdater implements Runnable {
    private Stock stock;
    private Random random = new Random();

    public StockPriceUpdater(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Simulate price fluctuation
                double newPrice = stock.getPrice() + (random.nextDouble() - 0.5) * 10;
                stock.setPrice(newPrice);

                // Print the updated price
                System.out.printf("[%s] Price updated: %.2f%n", stock.getName(), stock.getPrice());

                // Sleep for a random interval (simulating real-time updates)
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.printf("[%s] Price updater stopped.%n", stock.getName());
                break;
            }
        }
    }
}

// StockMonitor class to monitor and alert on significant price changes
class StockMonitor implements Runnable {
    private Stock stock;
    private double lastPrice;
    private static final double THRESHOLD = 5.0; // Threshold for significant price change

    public StockMonitor(Stock stock) {
        this.stock = stock;
        this.lastPrice = stock.getPrice();
    }

    @Override
    public void run() {
        while (true) {
            try {
                double currentPrice = stock.getPrice();
                double change = Math.abs(currentPrice - lastPrice);

                // Alert if the price change exceeds the threshold
                if (change > THRESHOLD) {
                    System.out.printf("[%s] ALERT: Significant price change! %.2f -> %.2f (Change: %.2f)%n",
                            stock.getName(), lastPrice, currentPrice, change);
                    lastPrice = currentPrice;
                }

                // Sleep for a short interval
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.printf("[%s] Monitor stopped.%n", stock.getName());
                break;
            }
        }
    }
}

public class StockMonitoringSystem {
    public static void main(String[] args) {
        // Create stocks
        Stock apple = new Stock("AAPL", 150.0);
        Stock google = new Stock("GOOGL", 2800.0);

        // Create a thread pool for concurrent execution
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Start stock price updaters
        executor.submit(new StockPriceUpdater(apple));
        executor.submit(new StockPriceUpdater(google));

        // Start stock monitors
        executor.submit(new StockMonitor(apple));
        executor.submit(new StockMonitor(google));

        // Shutdown the executor after 30 seconds (for demonstration)
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        } finally {
            executor.shutdownNow();
        }
    }
}
