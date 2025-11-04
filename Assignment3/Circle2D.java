public class Circle2D {
    // fields
    private double x;
    private double y;
    private double radius;

    // default constructor
    public Circle2D() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }

    // constructor with parameters
    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // getters
    public double getX() { return x; }
    public double getY() { return y; }
    public double getRadius() { return radius; }

    // area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // perimeter (circumference)
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // distance between two points
    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    // check if point (px,py) lies inside circle
    public boolean contains(double px, double py) {
        double d = distance(this.x, this.y, px, py);
        return d <= radius;
    }

    // check if circle c is inside this circle
    public boolean contains(Circle2D c) {
        double d = distance(this.x, this.y, c.x, c.y);
        return d + c.radius <= this.radius;
    }

    // check if circle c overlaps this circle
    public boolean overlaps(Circle2D c) {
        double d = distance(this.x, this.y, c.x, c.y);
        return d <= (this.radius + c.radius);
    }

    // main to test
    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 5.5);

        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());

        System.out.println("Contains point (3,3): " + c1.contains(3, 3));
        System.out.println("Contains circle (4,5,10.5): " + c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println("Overlaps circle (3,5,2.3): " + c1.overlaps(new Circle2D(3, 5, 2.3)));
    }
}
