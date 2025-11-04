import java.util.*;

public class Sorting {

    // 1. Sort int array in ascending order
    public static void sort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 2. Sort int array with reverse option
    public static void sort(int[] arr, int n, boolean reverse) {
        // first do normal ascending bubble sort
        sort(arr, n);

        // if reverse = true → reverse the array
        if (reverse) {
            int start = 0, end = n - 1;
            while (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }

    // 3. Sort String array lexicographically
    public static void sort(String[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // swap
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example with integer array
        System.out.print("Enter size of integer array: ");
        int n = sc.nextInt();
        int[] intArr = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            intArr[i] = sc.nextInt();
        }

        sort(intArr, n); // ascending sort
        System.out.println("Sorted in Ascending: " + Arrays.toString(intArr));

        sort(intArr, n, true); // descending sort
        System.out.println("Sorted in Descending: " + Arrays.toString(intArr));

        // Example with string array
        System.out.print("\nEnter size of string array: ");
        int m = sc.nextInt();
        String[] strArr = new String[m];

        System.out.println("Enter " + m + " strings:");
        for (int i = 0; i < m; i++) {
            strArr[i] = sc.next();
        }

        sort(strArr, m); // lexicographic sort
        System.out.println("Sorted Strings: " + Arrays.toString(strArr));

        sc.close();
    }
}
