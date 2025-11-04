import java.util.*;

public class Oddevenprime {

    // Function to check if a number is prime
    public static boolean isPrime(int num, int i) {
        if (num <= 1) return false;
        if (i == 1) return true;
        if (num % i == 0) return false;
        return isPrime(num, i - 1);
    }

    // Find smallest even number using recursion
    public static int smallestEven(int[] arr, int n, int index, int currentMin) {
        if (index == n) return currentMin;  // end of array

        if (arr[index] % 2 == 0) {  // even check
            if (currentMin == -1 || arr[index] < currentMin) {
                currentMin = arr[index];  // update smallest
            }
        }

        return smallestEven(arr, n, index + 1, currentMin);
    }

    // Find largest odd number using recursion
    public static int largestOdd(int[] arr, int n, int index, int currentMax) {
        if (index == n) return currentMax;  // end of array

        if (arr[index] % 2 != 0) {  // odd check
            if (currentMax == -1 || arr[index] > currentMax) {
                currentMax = arr[index];  // update largest
            }
        }

        return largestOdd(arr, n, index + 1, currentMax);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Smallest even
        int even = smallestEven(arr, n, 0, -1);
        if (even == -1)
            System.out.println("No even number found.");
        else
            System.out.println("Smallest even number: " + even);

        // Largest odd
        int odd = largestOdd(arr, n, 0, -1);
        if (odd == -1)
            System.out.println("No odd number found.");
        else
            System.out.println("Largest odd number: " + odd);

        // Prime numbers
        System.out.println("Prime numbers in the array:");
        for (int i = 0; i < n; i++) {
            if (isPrime(arr[i], arr[i] / 2)) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

        sc.close();
    }
}
