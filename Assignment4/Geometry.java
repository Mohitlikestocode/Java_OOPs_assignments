// Base abstract class
abstract class Shape {
    // Abstract method for area
    public abstract double area();
}

// Circle class
class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Getter
    public double getRadius() {
        return radius;
    }

    // Setter
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Area function
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Rectangle class
class Rectangle extends Shape {
    private double length;
    private double breadth;

    // Constructor
    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Getters
    public double getLength() {
        return length;
    }

    public double getBreadth() {
        return breadth;
    }

    // Setters
    public void setLength(double length) {
        this.length = length;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    // Area function
    @Override
    public double area() {
        return length * breadth;
    }
}

// Triangle class
class Triangle extends Shape {
    private double side1, side2, side3;

    // Constructor
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Getters
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    // Setters
    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    // Area function using Heron's formula
    @Override
    public double area() {
        double s = (side1 + side2 + side3) / 2; // semi-perimeter
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}

// Main class
public class Geometry {
    public static void main(String[] args) {
        // Polymorphism: Shape references to different objects
        Shape circle = new Circle(5);             // radius = 5
        Shape rectangle = new Rectangle(4, 6);    // length = 4, breadth = 6
        Shape triangle = new Triangle(3, 4, 5);   // sides = 3, 4, 5

        // Print areas
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Triangle Area: " + triangle.area());
    }
}
