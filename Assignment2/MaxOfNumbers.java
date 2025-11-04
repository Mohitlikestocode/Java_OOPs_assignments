package Assignment2;
import java.util.Scanner;

public class MaxOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many numbers? ");
        int count = sc.nextInt();

        int max = Integer.MIN_VALUE;
        System.out.println("Enter " + count + " numbers:");
        for (int i = 0; i < count; i++) {
            int val = sc.nextInt();
            if (val > max) {
                max = val;
            }
        }

        System.out.println("Maximum number is: " + max);
        sc.close();
    }
}
