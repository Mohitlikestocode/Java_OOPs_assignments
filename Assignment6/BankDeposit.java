//Sai Mohit Kotta
//2410110287
//Assignment6 Question 2
//Date - 02-10-2025

import java.util.Scanner;

class LowDepositException extends Exception {
    public LowDepositException(String message) {
        super(message);
    }
}

class ShortTenureException extends Exception {
    public ShortTenureException(String message) {
        super(message);
    }
}

public class BankDeposit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter deposit amount: ");
            double deposit = sc.nextDouble();
            try {
                System.out.print("Enter tenure (in months): ");
                int tenure = sc.nextInt();

                if (deposit < 50000) {
                    throw new LowDepositException("Deposit must be at least 50000!");
                }
                if (tenure < 12) {
                    throw new ShortTenureException("Tenure must be at least 12 months!");
                }

                double maturity = deposit + (deposit * 0.075 * tenure / 12);
                System.out.println("Maturity Amount = " + maturity);

            } catch (ShortTenureException e) {
                System.out.println("Condition Violated: " + e.getMessage());
            }
        } catch (LowDepositException e) {
            System.out.println("Condition Violated: " + e.getMessage());
        }
    }
}
