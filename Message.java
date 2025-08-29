// File: MessageReceived.java
public class MessageReceived {
    public static void main(String[] args) {
        MessageSent messageSent = new MessageSent();

        // Create sender thread
        Thread senderThread = new Thread(() -> {
            String[] messages = {"Hello", "How are you?", "Goodbye"};
            for (String msg : messages) {
                messageSent.sendMessage(msg);
                try {
                    Thread.sleep(1000); // Simulate time taken to send messages
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Create receiver thread
        Thread receiverThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                messageSent.receiveMessage();
                try {
                    Thread.sleep(1500); // Simulate time taken to process received messages
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Start the threads
        senderThread.start();
        receiverThread.start();

        // Wait for both threads to finish
        try {
            senderThread.join();
            receiverThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
