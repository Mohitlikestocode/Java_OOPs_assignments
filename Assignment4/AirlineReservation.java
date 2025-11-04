import java.util.Scanner;

public class AirlineReservation {
    public static void main(String[] args) {
        boolean[] seats = new boolean[10]; // all false by default
        Scanner sc = new Scanner(System.in);
        boolean flightFull = false;

        while (!flightFull) {
            System.out.println("Please type 1 for First Class");
            System.out.println("Please type 2 for Economy");
            int choice = sc.nextInt();

            if (choice == 1) {
                if (assignSeat(seats, 0, 4)) {
                    // Seat assigned in first class
                } else if (assignSeat(seats, 5, 9)) {
                    System.out.println("First Class is full. Assigned Economy seat instead.");
                } else {
                    flightFull = true;
                    System.out.println("All seats are full. Next flight leaves in 3 hours.");
                }
            } else if (choice == 2) {
                if (assignSeat(seats, 5, 9)) {
                    // Seat assigned in economy
                } else if (assignSeat(seats, 0, 4)) {
                    System.out.println("Economy is full. Assigned First Class seat instead.");
                } else {
                    flightFull = true;
                    System.out.println("All seats are full. Next flight leaves in 3 hours.");
                }
            } else {
                System.out.println("Invalid input. Please type 1 or 2.");
            }

            // Check if plane is fully booked
            flightFull = true;
            for (boolean seat : seats) {
                if (!seat) {
                    flightFull = false;
                    break;
                }
            }
        }

        sc.close();
    }

    // Method to assign a seat in the given range
    private static boolean assignSeat(boolean[] seats, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (!seats[i]) {
                seats[i] = true;
                if (i < 5) {
                    System.out.println("Boarding Pass: Seat " + (i + 1) + " - First Class");
                } else {
                    System.out.println("Boarding Pass: Seat " + (i + 1) + " - Economy");
                }
                return true; // seat assigned
            }
        }
        return false; // no seat available in this range
    }
}
