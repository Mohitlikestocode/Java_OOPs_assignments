public class QueueOfIntegers {
    private int[] data;    // array to store queue elements
    private int front;     // index of the front element
    private int rear;      // index after the last element
    private int size;      // number of elements in queue

    // Constructor with capacity
    //used to establish default values of these variables. 
    public QueueOfIntegers(int capacity) {
        data = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Add an element to the queue
    public void enqueue(int value) {
        if (size == data.length) {
            System.out.println("Queue is full! Cannot enqueue " + value);
            return;
        }
        data[rear] = value;
        rear = (rear + 1) % data.length; // circular increment
        size++;
    }

    // Remove and return the front element
    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1; // or throw exception
        }
        int value = data[front];
        front = (front + 1) % data.length; // circular increment
        size--;
        return value;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == data.length;
    }

    // Display the queue
    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue contents: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[(front + i) % data.length] + " ");
        }
        System.out.println();
    }

    // ---- MAIN METHOD FOR TESTING ----
    public static void main(String[] args) {
        // Create queue of capacity 5
        QueueOfIntegers q = new QueueOfIntegers(5);

        // Enqueue some elements
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(); // 10 20 30

        // Dequeue one element
        System.out.println("Dequeued: " + q.dequeue());
        q.display(); // 20 30

        // Enqueue more elements
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60); // This will fill the queue
        q.display(); // 20 30 40 50 60

        // Try to enqueue when full
        q.enqueue(70); // should show error

        // Dequeue all elements
        while (!q.isEmpty()) {
            System.out.println("Dequeued: " + q.dequeue());
        }
        q.display(); // empty queue
    }
}


// Difference between Stack and Queue?
// Stack → Last-In First-Out (LIFO).
// Queue → First-In First-Out (FIFO).

// Why do we need a circular array here?
// Without wrapping around, rear would run off the end even if there is free space at the beginning. Circular indexing reuses space efficiently.

// What is the time complexity of enqueue and dequeue?
// Both are O(1) because we just move pointers and assign values.

// What are other ways to implement a queue?
// Linked list, Java’s built-in Queue interface, or java.util.LinkedList.

// What is the difference between front and rear?
// front marks the element to remove next.
// rear marks the position where the next element will be added.

// What happens if you call dequeue on an empty queue?
// Here it prints a message and returns -1. In production code we usually throw an exception.

// Java-specific

// Why is data declared private?
// To follow encapsulation—outside code should not directly mess with internal array.

// What is % (modulus) operator doing?
// Ensures indices wrap around to stay inside array bounds.

// Why is main method static?
// So Java can run the program without needing to first create an object of the class.