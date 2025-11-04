import java.util.Scanner;

public class ThreadSleepOrder {

    //FOURUTH ONEE 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x (ms): ");
        long x = sc.nextLong();

        System.out.print("Enter y (ms): ");
        long y = sc.nextLong();

        System.out.print("Enter z (ms): ");
        long z = sc.nextLong();

        // --- Step 1: Main Thread runs first ---
        System.out.println("Main Thread: Sleeping for " + x + " milliseconds");
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // --- Step 2: Start Thread T1 ---
        Thread t1 = new Thread(() -> {
            System.out.println("T1: Sleeping for " + y + " milliseconds");
            try {
                Thread.sleep(y);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();

        // --- Step 3: Wait until T1 starts, then start T2 ---
        Thread t2 = new Thread(() -> {
            System.out.println("T2: Sleeping for " + z + " milliseconds");
            try {
                Thread.sleep(z);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        try {
            // Ensures T2 starts after T1 has started execution
            t1.join(10); // small join delay to ensure order, but still concurrent
            t2.start();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Wait for all threads to complete before exiting main
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All threads have finished execution.");
    }
}
