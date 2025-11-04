public class Fan {
    // Constants for fan speed
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // Data fields with default values
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    // No-arg constructor (default fan)
    public Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5.0;
        this.color = "blue";
    }

    // Getters (accessors)
    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    // Setters (mutators)
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // toString method
    @Override
    public String toString() {
        if (on) {
            return "Fan speed: " + speed + ", color: " + color + ", radius: " + radius;
        } else {
            return "Fan color: " + color + ", radius: " + radius + ", fan is off";
        }
    }

    // Test program
    public static void main(String[] args) {
        // First fan: maximum speed, radius 10, color yellow, ON
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);

        // Second fan: medium speed, radius 5, color blue, OFF
        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        // Display fans
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
