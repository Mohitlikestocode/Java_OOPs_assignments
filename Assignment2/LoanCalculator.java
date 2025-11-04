package Assignment2;
import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter loan amount: ");
        double loanAmount = sc.nextDouble();

        System.out.print("Enter annual interest rate (in %): ");
        double annualRate = sc.nextDouble();

        double monthlyRate = (annualRate / 100) / 12;

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double monthlyPayment = (loanAmount * monthlyRate) /
                (1 - (1 / Math.pow(1 + monthlyRate, years * 12)));

        System.out.printf("Monthly Payment = %.2f%n", monthlyPayment);
        sc.close();
    }
}
