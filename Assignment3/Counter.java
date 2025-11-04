public class Counter {
    static int count = 0;

    Counter() {
        count++;
    }

    static void show_count() {
        System.out.println("Number of objects created: " + count);
    }

    public static void main(String[] args) {
        Counter obj1 = new Counter();
        Counter obj2 = new Counter();
        Counter obj3 = new Counter();

        Counter.show_count();

        Counter obj4 = new Counter();
        Counter obj5 = new Counter();

        Counter.show_count();
    }
}
