//Using join() to wait for threads to finish.
class NewThread implements Runnable{
    String name; //name of thread
    Thread t;

    NewThread(String threadname){ // Constructor
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New thread: " +t);
        t.start(); // Start the thread
    }

    public void run(){
        try{
            // Thread prints its name and a count from 5 down to 1
            for(int i = 5; i > 0; i--) { // The condition i > 0 is misplaced here (should be in the middle of the for loop) but the code logic suggests it intends to run 5 times.
                System.out.println(name + ":" + i);
                Thread.sleep(1000); // Thread sleeps for 1 second
            }
        }catch(InterruptedException e){
            System.out.println(name + "Interrupted");
        }
        System.out.println(name + "exiting.");
    }
}

class DemoJoin{
    public static void main(String args[]){
        // 1. Create and start three threads
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");
        NewThread ob3 = new NewThread("Three");

        // 2. Check if threads are alive immediately after starting them
        System.out.println("Thread One is alive: " + ob1.t.isAlive());
        System.out.println("Thread Two is alive: " + ob2.t.isAlive());
        System.out.println("Thread Three is alive: " + ob3.t.isAlive());

        // 3. Wait for all threads to finish using join()
        try{
            System.out.println("Waiting for threads to finish.");
            ob1.t.join(); // Main thread blocks (waits) until ob1 finishes
            ob2.t.join(); // Main thread blocks (waits) until ob2 finishes
            ob3.t.join(); // Main thread blocks (waits) until ob3 finishes
        }catch(InterruptedException e){
            System.out.println("Main thread Interrupted");
        }
        
        // 4. Check if threads are alive after join() completes
        System.out.println("Thread One is alive:" + ob1.t.isAlive());
        System.out.println("Thread Two is alive:" + ob2.t.isAlive());
        System.out.println("Thread Three is alive:" + ob3.t.isAlive());
        System.out.println("Main thread exiting.");
    }
}