abstract class Shape {
    public abstract String getDescription();
}

abstract class TwoDimensionalShape extends Shape {
    public abstract double getArea();
}

abstract class ThreeDimensionalShape extends Shape {
    public abstract double getArea();
    public abstract double getVolume();
}

// Circle class
class Circle extends TwoDimensionalShape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return (Math.PI * radius * radius);
    }
    @Override
    public String getDescription() {
        return "Circle with radius " + radius;
    }
}

// Square class
class Square extends TwoDimensionalShape {
    private double side;
    public Square(double side) {
        this.side = side;
    }
    @Override
    public double getArea() {
        return side * side;
    }
    @Override
    public String getDescription() {
        return "Square with side " + side;
    }
}

// Triangle class
class Triangle extends TwoDimensionalShape {
    private double base, height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
    @Override
    public String getDescription() {
        return "Triangle with base " + base + " and height " + height;
    }
}

// Sphere class
class Sphere extends ThreeDimensionalShape {
    private double radius;
    public Sphere(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return 4 * Math.PI * radius * radius;
    }
    @Override
    public double getVolume() {
        return (4.0/3.0) * Math.PI * Math.pow(radius, 3);
    }
    @Override
    public String getDescription() {
        return "Sphere with radius " + radius;
    }
}

// Cube class
class Cube extends ThreeDimensionalShape {
    private double side;
    public Cube(double side) {
        this.side = side;
    }
    @Override
    public double getArea() {
        return 6 * side * side;
    }
    @Override
    public double getVolume() {
        return side * side * side;
    }
    @Override
    public String getDescription() {
        return "Cube with side " + side;
    }
}

// Tetrahedron class (regular tetrahedron)
class Tetrahedron extends ThreeDimensionalShape {
    private double side;
    public Tetrahedron(double side) {
        this.side = side;
    }
    @Override
    public double getArea() {
        return Math.sqrt(3) * side * side;
    }
    @Override
    public double getVolume() {
        return (Math.pow(side, 3)) / (6 * Math.sqrt(2));
    }
    @Override
    public String getDescription() {
        return "Tetrahedron with side " + side;
    }
}

// Main driver
public class ShapesDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Square(4),
            new Triangle(3, 6),
            new Sphere(3),
            new Cube(2),
            new Tetrahedron(3)
        };

        for (Shape s : shapes) {
            System.out.println(s.getDescription());
            if (s instanceof TwoDimensionalShape) {
                TwoDimensionalShape twoD = (TwoDimensionalShape) s;
                System.out.println("Area: " + twoD.getArea());
            } else if (s instanceof ThreeDimensionalShape) {
                ThreeDimensionalShape threeD = (ThreeDimensionalShape) s;
                System.out.println("Surface Area: " + threeD.getArea());
                System.out.println("Volume: " + threeD.getVolume());
            }
            System.out.println();
        }
    }
}
