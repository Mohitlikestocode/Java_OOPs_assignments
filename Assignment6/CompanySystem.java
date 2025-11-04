//Sai Mohit Kotta
//2410110287
//Assignment6 Question 5
//Date - 02-10-2025

import java.io.*;
import java.util.*;

class Product implements Serializable {
    String productName;
    int maxQuantity;

    public Product(String productName, int maxQuantity) {
        this.productName = productName;
        this.maxQuantity = maxQuantity;
    }

    public String toString() {
        return productName + " (Limit per customer: " + maxQuantity + ")";
    }
}

class Customer implements Serializable {
    String name;
    int purchasedQuantity;

    public Customer(String name, int purchasedQuantity) {
        this.name = name;
        this.purchasedQuantity = purchasedQuantity;
    }

    public String toString() {
        return "Customer: " + name + ", Purchased: " + purchasedQuantity;
    }
}

public class CompanySystem {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter product name: ");
            String pname = sc.nextLine();
            System.out.print("Enter max quantity per customer: ");
            int maxQ = sc.nextInt();
            Product product = new Product(pname, maxQ);

            sc.nextLine(); // consume leftover newline
            System.out.print("Enter customer name: ");
            String cname = sc.nextLine();
            System.out.print("Enter quantity purchased: ");
            int q = sc.nextInt();

            if (q > maxQ) {
                throw new IOException("Purchase quantity exceeds allowed limit!");
            }

            Customer cust = new Customer(cname, q);

            System.out.println("\nProduct Details: " + product);
            System.out.println("Customer Details: " + cust);

            // Serialize objects
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.ser"));
            out.writeObject(product);
            out.writeObject(cust);
            out.close();

            System.out.println("Data saved successfully!");

        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        }
    }
}
