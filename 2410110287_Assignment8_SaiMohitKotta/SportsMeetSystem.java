//Sai Mohit Kotta
//2410110287
//23-10-2025
//I have done this by myself :)

class Ticket {
    private String eventName;
    private double price;

    public Ticket(String eventName, double price) {
        this.eventName = eventName;
        this.price = price;
    }

    public String getEventName() {
        return eventName;
    }

    public double getPrice() {
        return price;
    }
}

class Event {
    private String eventName;
    private String venue;

    public Event(String eventName, String venue) {
        this.eventName = eventName;
        this.venue = venue;
    }

    public String getEventName() {
        return eventName;
    }

    public String getVenue() {
        return venue;
    }
}

class Student {
    private String name;
    private String studentID;

    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public String getStudentID() {
        return studentID;
    }
}

class Booking {
    protected Student student;
    protected Event event;
    protected Ticket[] tickets;
    protected int ticketCount;

    public Booking(Student student, Event event, int maxTickets) {
        this.student = student;
        this.event = event;
        this.tickets = new Ticket[maxTickets];
        this.ticketCount = 0;
    }

    public void addTicket(Ticket t) {
        if (ticketCount < tickets.length) {
            tickets[ticketCount++] = t;
        }
    }

    public void addTicket(Ticket t, int quantity) {
        for (int i = 0; i < quantity && ticketCount < tickets.length; i++) {
            tickets[ticketCount++] = t;
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < ticketCount; i++) {
            total += tickets[i].getPrice();
        }
        return total;
    }

    public void printBooking() {
        System.out.println("Student: " + student.getName() + " (ID: " + student.getStudentID() + ")");
        System.out.println("Event: " + event.getEventName() + " at " + event.getVenue());
        System.out.println("Tickets Booked: " + ticketCount);
        for (int i = 0; i < ticketCount; i++) {
            System.out.println("  - " + tickets[i].getEventName() + " - Rs. " + tickets[i].getPrice());
        }
        System.out.println("Total Cost: Rs. " + calculateTotal());
        System.out.println();
    }
}

class GeneralBooking extends Booking {
    public GeneralBooking(Student student, Event event, int maxTickets) {
        super(student, event, maxTickets);
    }

    @Override
    public double calculateTotal() {
        return super.calculateTotal();
    }
}

class VIPBooking extends Booking {
    private static final double VIP_CHARGE = 200.0;

    public VIPBooking(Student student, Event event, int maxTickets) {
        super(student, event, maxTickets);
    }

    @Override
    public double calculateTotal() {
        return super.calculateTotal() + VIP_CHARGE;
    }
}

public class SportsMeetSystem {
    public static void main(String[] args) {
        Event footballEvent = new Event("Football Championship", "Main Stadium");
        Student student1 = new Student("Rahul Sharma", "STU001");
        Student student2 = new Student("Priya Patel", "STU002");

        Ticket ticket1 = new Ticket("Football Match", 150.0);
        Ticket ticket2 = new Ticket("Football Match", 150.0);
        Ticket ticket3 = new Ticket("Football VIP Pass", 500.0);

        GeneralBooking generalBooking = new GeneralBooking(student1, footballEvent, 5);
        generalBooking.addTicket(ticket1);
        generalBooking.addTicket(ticket2, 2);

        VIPBooking vipBooking = new VIPBooking(student2, footballEvent, 5);
        vipBooking.addTicket(ticket3);
        vipBooking.addTicket(ticket3, 1);

        System.out.println("=== General Booking ===");
        generalBooking.printBooking();

        System.out.println("=== VIP Booking ===");
        vipBooking.printBooking();
    }
}