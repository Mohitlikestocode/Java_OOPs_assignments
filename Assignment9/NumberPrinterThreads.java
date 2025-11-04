import java.util.Scanner;

//SECOND ONEEE

public class NumberPrinterThreads {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        Thread naturalThread = new Thread(new NaturalNumbers(n));
        Thread evenThread = new Thread(new EvenNumbers(n));
        Thread oddThread = new Thread(new OddNumbers(n));

        try {
            // Start and complete natural numbers first
            naturalThread.start();
            naturalThread.join();

            // Then even numbers
            evenThread.start();
            evenThread.join();

            // Finally odd numbers
            oddThread.start();
            oddThread.join();

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }

    // Thread 1: Print natural numbers
    static class NaturalNumbers implements Runnable {
        int n;
        NaturalNumbers(int n) { this.n = n; }

        public void run() {
            System.out.print("Natural Numbers: ");
            for (int i = 1; i <= n; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // Thread 2: Print even numbers
    static class EvenNumbers implements Runnable {
        int n;
        EvenNumbers(int n) { this.n = n; }

        public void run() {
            System.out.print("Even Numbers: ");
            for (int i = 1; i <= n; i++) {
                System.out.print((2 * i) + " ");
            }
            System.out.println();
        }
    }

    // Thread 3: Print odd numbers
    static class OddNumbers implements Runnable {
        int n;
        OddNumbers(int n) { this.n = n; }

        public void run() {
            System.out.print("Odd Numbers: ");
            for (int i = 1; i <= n; i++) {
                System.out.print((2 * i - 1) + " ");
            }
            System.out.println();
        }
    }
}
