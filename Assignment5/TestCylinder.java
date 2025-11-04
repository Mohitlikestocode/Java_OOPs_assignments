// Save this whole code as TestCylinder.java

public class TestCylinder {
    public static void main(String[] args) {
        // Test default cylinder
        Cylinder c1 = new Cylinder();
        System.out.println(c1); // calls toString()

        // Test cylinder with radius and height
        Cylinder c2 = new Cylinder(2.5, 5.0);
        System.out.println("Radius: " + c2.getRadius());
        System.out.println("Height: " + c2.getHeight());
        System.out.println("Area: " + c2.getArea());
        System.out.println("Volume: " + c2.getVolume());
        System.out.println(c2);

        // Test cylinder with radius, height and color
        Cylinder c3 = new Cylinder(3.0, 7.0, "blue");
        System.out.println(c3);
    }
}

// -------- Circle Class --------
class Circle {
    // Data fields
    private double radius = 1.0;
    private String color = "red";

    // Constructors
    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    // Getters and setters
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Area of circle
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // toString method
    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }
}

// -------- Cylinder Class --------
class Cylinder extends Circle {
    // Data field
    private double height = 1.0;

    // Constructors
    public Cylinder() {
        super();
    }

    public Cylinder(double radius) {
        super(radius);
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    // Getter and Setter
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Volume of cylinder
    public double getVolume() {
        return super.getArea() * height; // base area * height
    }

    // toString overridden
    @Override
    public String toString() {
        return "Cylinder: subclass of " + super.toString()
                + " height=" + height
                + " volume=" + getVolume();
    }
}


// What is inheritance in Java?
// Mechanism where a class (subclass) acquires the properties and behaviors of another (superclass).
// Here, Cylinder inherits from Circle.

// Difference between overriding and overloading?
// Overloading: same method name, different parameter list (e.g., constructors in Circle).
// Overriding: subclass provides a new implementation of a parent method (toString()).

// Why use super keyword?
// To access parent’s methods or constructors.
// E.g., super.getArea() or super(radius).

// What is polymorphism?
// Ability of a method call to behave differently depending on the actual object.
// Example: System.out.println(c1) calls the correct toString() at runtime.

// Why keep fields private and use getters/setters?
// Encapsulation: protects data from being modified directly.

// Why override toString()?
// To provide a meaningful string representation when printing the object.

// How is the volume of a cylinder calculated?
// Base area × height. Base area is obtained from Circle’s getArea().

// Java-specific

// Why is main method static?
// So it can run without creating an object of TestCylinder.

// What is @Override annotation used for?
// Informs compiler that we are overriding a parent method.

// Can we access radius directly in Cylinder?
// No, it is private. We use getRadius() or call super methods.