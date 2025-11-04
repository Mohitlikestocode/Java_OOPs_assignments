package Assignment2;

import java.util.Scanner;

public class BankAccount {
    private String name;
    private int accountNumber;
    private String accountType;
    private double balance;

    // method to assign values
    public void assignValues(String name, int accountNumber, String accountType, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    // deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // display details
    public void display() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }

    // main program with menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Assign Initial Values");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account Holder Name and Balance");
            System.out.println("5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Account Type: ");
                    String accType = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    account.assignValues(name, accNo, accType, bal);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double wit = sc.nextDouble();
                    account.withdraw(wit);
                    break;
                case 4:
                    account.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
