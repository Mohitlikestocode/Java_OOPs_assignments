import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.Random;

//FIRST PROGRAM!!

public class ProducerConsumerNumberWords {

    // Shared single-slot buffer
    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
    private final Random rand = new Random();

    public static void main(String[] args) {
        ProducerConsumerNumberWords pc = new ProducerConsumerNumberWords();
        pc.start();
    }

    private void start() {
        Thread producer = new Thread(new Producer(), "Producer");
        Thread consumer = new Thread(new Consumer(), "Consumer");

        producer.start();
        consumer.start();
    }

    // Producer: generates random integers and puts into queue
    private class Producer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    int n = rand.nextInt(1_000_000_000); // [0, 1 billion)
                    queue.put(n); // blocks if buffer full
                    System.out.println("Produced: " + n);
                    Thread.sleep(700); // simulate some delay before producing next
                }
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Consumer: takes integers and prints in words
    private class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    int n = queue.take(); // blocks if buffer empty
                    String words = numberToWords(n);
                    System.out.println("Consumed (in words): " + words);
                    // simulate variable processing time
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Convert number to English words (supports 0 to 999,999,999)
    private static String numberToWords(long num) {
        if (num == 0) {
            return "Zero";
        }
        if (num < 0) {
            return "Minus " + numberToWords(-num);
        }

        String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"}; // can extend if needed

        StringBuilder sb = new StringBuilder();

        int groupIndex = 0; // thousands group index
        while (num > 0) {
            int group = (int) (num % 1000);
            if (group != 0) {
                String groupWords = threeDigitToWords(group, below20, tens);
                if (sb.length() > 0) {
                    sb.insert(0, " ");
                }
                if (!thousands[groupIndex].isEmpty()) {
                    sb.insert(0, groupWords + " " + thousands[groupIndex]);
                } else {
                    sb.insert(0, groupWords);
                }
            }
            num /= 1000;
            groupIndex++;
        }

        // Clean up extra spaces
        String result = sb.toString().trim().replaceAll("\\s+", " ");
        // Capitalize first letter and return
        if (result.length() > 0) {
            return result.substring(0, 1).toUpperCase() + result.substring(1);
        }
        return result;
    }

    private static String threeDigitToWords(int num, String[] below20, String[] tens) {
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            int h = num / 100;
            sb.append(below20[h]).append(" Hundred");
            num = num % 100;
            if (num != 0) {
                sb.append(" ");
            }
        }
        if (num >= 20) {
            int t = num / 10;
            sb.append(tens[t]);
            int r = num % 10;
            if (r != 0) {
                sb.append(" ").append(below20[r]);
            }
        } else if (num > 0) { // 1..19
            sb.append(below20[num]);
        }
        return sb.toString();
    }
}
