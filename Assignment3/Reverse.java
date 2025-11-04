import java.util.*;

public class Reverse {

    // Function to reverse the array in-place
    public static void reverseArray(int[] arr, int n) {
        int start = 0;      
        int end = n - 1;    

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create array of size 11
        int[] arr = new int[11];
        System.out.println("Enter 11 integers:");

        // take input
        for (int i = 0; i < 11; i++) {
            arr[i] = sc.nextInt();
        }

        // print original array
        System.out.print("Original Array: ");
        for (int i = 0; i < 11; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // reverse array
        reverseArray(arr, 11);

        // print reversed array
        System.out.print("Reversed Array: ");
        for (int i = 0; i < 11; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
