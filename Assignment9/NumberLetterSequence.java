public class NumberLetterSequence {

    //THIRD ONEEE

    public static void main(String[] args) {
        SharedPrinter shared = new SharedPrinter();

        Thread numberThread = new Thread(new NumberThread(shared), "NumberThread");
        Thread letterThread = new Thread(new LetterThread(shared), "LetterThread");

        numberThread.start();
        letterThread.start();
    }
}

class SharedPrinter {
    private int currentLetterIndex = 1;  // Tracks which letter we are on (A=1, B=2, ...)
    private boolean numberTurn = true;   // Whose turn is it to print?

    // Method for number thread
    synchronized void printNumbers() {
        while (currentLetterIndex <= 26) {
            try {
                while (!numberTurn) {
                    wait();
                }
                // Print numbers from 1 to currentLetterIndex
                for (int i = 1; i <= currentLetterIndex; i++) {
                    System.out.print(i + " ");
                }
                numberTurn = false; // Switch turn
                notifyAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Method for letter thread
    synchronized void printLetters() {
        while (currentLetterIndex <= 26) {
            try {
                while (numberTurn) {
                    wait();
                }
                // Print corresponding letter (A + index - 1)
                char letter = (char) ('A' + currentLetterIndex - 1);
                System.out.println(letter);
                currentLetterIndex++;
                numberTurn = true; // Switch turn
                notifyAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Thread to print numbers
class NumberThread implements Runnable {
    private SharedPrinter shared;
    NumberThread(SharedPrinter shared) { this.shared = shared; }

    @Override
    public void run() {
        shared.printNumbers();
    }
}

// Thread to print letters
class LetterThread implements Runnable {
    private SharedPrinter shared;
    LetterThread(SharedPrinter shared) { this.shared = shared; }

    @Override
    public void run() {
        shared.printLetters();
    }
}
