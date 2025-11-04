package Assignment2;

import java.util.Scanner;

public class InsertionSortProgram {

    // method for insertion sort
    public static void insertionSort(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            double key = arr[i];
            int j = i - 1;

            // move elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[10];

        System.out.println("Enter 10 double numbers:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextDouble();
        }

        insertionSort(arr);

        System.out.println("Sorted numbers:");
        for (double num : arr) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}
