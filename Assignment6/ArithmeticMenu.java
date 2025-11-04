//Sai Mohit Kotta
//2410110287
//Assignment6 Question 3
//Date - 02-10-2025

import java.util.Scanner;

class DivisionByZeroException extends Exception {
    public String toString() {
        return "Error: Cannot divide by zero!";
    }
}

class NegativeSqrtException extends Exception {
    public String toString() {
        return "Error: Cannot take square root of negative number!";
    }
}

class NegativeFactorialException extends Exception {
    public String toString() {
        return "Error: Cannot compute factorial of negative number!";
    }
}

public class ArithmeticMenu {
    public static int factorial(int n) throws NegativeFactorialException {
        if (n < 0) throw new NegativeFactorialException();
        int result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Division\n2. Square Root\n3. Factorial");
        int choice = sc.nextInt();
        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter numerator: ");
                    int num = sc.nextInt();
                    System.out.print("Enter denominator: ");
                    int den = sc.nextInt();
                    if (den == 0) throw new DivisionByZeroException();
                    System.out.println("Result = " + (num / den));
                    break;
                case 2:
                    System.out.print("Enter number: ");
                    int x = sc.nextInt();
                    if (x < 0) throw new NegativeSqrtException();
                    System.out.println("Square root = " + Math.sqrt(x));
                    break;
                case 3:
                    System.out.print("Enter number: ");
                    int n = sc.nextInt();
                    System.out.println("Factorial = " + factorial(n));
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
