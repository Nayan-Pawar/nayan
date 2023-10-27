public class Singleton {

    // Declare a private volatile instance variable to ensure visibility to all threads.
    private static volatile Singleton instance;

    // Private constructor to prevent instantiation from other classes.
    private Singleton() {}

    // Public static method to get the instance of the Singleton class.
    public static Singleton getInstance() {
        // Check if the instance is null (not yet initialized).
        if (instance == null) {
            // Use synchronized block to ensure only one thread creates the instance.
            synchronized (Singleton.class) {
                // Double-check if another thread has created the instance while waiting.
                if (instance == null) {
                    // Create the Singleton instance.
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Example method to demonstrate Singleton functionality.
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

    public static void main(String[] args) {
        // Test the Singleton pattern with multiple threads.
        Runnable runnable = () -> {
            Singleton singleton = Singleton.getInstance();
            singleton.showMessage();
        };

        // Create multiple threads to access the Singleton instance.
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        // Start the threads.
        thread1.start();
        thread2.start();
    }
}

