public class Triangle {
    private double side1;
    private double side2;
    private double side3;

    // No-arg constructor
    public Triangle() {
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    // Parameterized constructor
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Getters
    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public double getSide3() { return side3; }

    // Setters
    public void setSide1(double side1) { this.side1 = side1; }
    public void setSide2(double side2) { this.side2 = side2; }
    public void setSide3(double side3) { this.side3 = side3; }

    // Method to calculate area using Heron's formula
    public double getArea() {
        double s = (side1 + side2 + side3) / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // Method to calculate perimeter
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // Main method to test
    public static void main(String[] args) {
        Triangle t1 = new Triangle(4, 5, 6);
        Triangle t2 = new Triangle(1.5, 2.5, 3.5);

        System.out.println("Triangle 1:");
        System.out.println("Sides: " + t1.getSide1() + ", " + t1.getSide2() + ", " + t1.getSide3());
        System.out.println("Perimeter: " + t1.getPerimeter());
        System.out.println("Area: " + t1.getArea());

        System.out.println();

        System.out.println("Triangle 2:");
        System.out.println("Sides: " + t2.getSide1() + ", " + t2.getSide2() + ", " + t2.getSide3());
        System.out.println("Perimeter: " + t2.getPerimeter());
        System.out.println("Area: " + t2.getArea());
    }
}
