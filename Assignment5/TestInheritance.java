// TestInheritance.java
import java.util.Date;

class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person: " + name;
    }
}

class Student extends Person {
    // Constants for status
    public static final String FRESHMAN = "Freshman";
    public static final String SOPHOMORE = "Sophomore";
    public static final String JUNIOR = "Junior";
    public static final String SENIOR = "Senior";

    private String status;

    public Student(String name, String address, String phoneNumber, String emailAddress, String status) {
        super(name, address, phoneNumber, emailAddress);
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student: " + getName();
    }
}

class Employee extends Person {
    private String office;
    private double salary;
    private Date dateHired;

    public Employee(String name, String address, String phoneNumber, String emailAddress,
                    String office, double salary, Date dateHired) {
        super(name, address, phoneNumber, emailAddress);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return "Employee: " + getName();
    }
}

class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty(String name, String address, String phoneNumber, String emailAddress,
                   String office, double salary, Date dateHired,
                   String officeHours, String rank) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Faculty: " + getName();
    }
}

class Staff extends Employee {
    private String title;

    public Staff(String name, String address, String phoneNumber, String emailAddress,
                 String office, double salary, Date dateHired,
                 String title) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.title = title;
    }

    @Override
    public String toString() {
        return "Staff: " + getName();
    }
}

public class TestInheritance {
    public static void main(String[] args) {
        Person person = new Person("John Doe", "123 Street", "1234567890", "john@example.com");
        Student student = new Student("Alice Smith", "456 Avenue", "0987654321", "alice@example.com", Student.JUNIOR);
        Employee employee = new Employee("Bob Johnson", "789 Boulevard", "1122334455", "bob@example.com",
                "Main Office", 50000, new Date());
        Faculty faculty = new Faculty("Dr. Jane", "321 Road", "5566778899", "jane@example.com",
                "Science Building", 70000, new Date(), "9-5", "Professor");
        Staff staff = new Staff("Mr. Mike", "654 Lane", "6677889900", "mike@example.com",
                "Admin Block", 40000, new Date(), "Clerk");

        System.out.println(person);
        System.out.println(student);
        System.out.println(employee);
        System.out.println(faculty);
        System.out.println(staff);
    }
}
