public class Cylinder extends Circle {
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
