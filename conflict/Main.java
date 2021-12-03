package conflict;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nRun Two AsyncCounters");
        runTwo();
        System.out.println("\n\nRun Three AsyncCounters");
        runThree();

        System.out.println("\n\nRun With ReEntrantLock Counter");
        runWithLock();

        System.out.println("\n\nRun With synchronized Counter");
        runWithSyncdCounter();

        System.out.println("\n\nRun With synchronized Block");
        runWithSyncdBlock();
    }
    public static void runTwo() {
        AsyncCounter runnable = new AsyncCounter();
        Thread first = new Thread(runnable);
        Thread second = new Thread(runnable);
        first.start();
        second.start();

        ThreadUtils.sleep(4000); // sleep 4 seconds
        System.out.println("\n\n1000000");
        System.out.println(runnable.getCount());
    }
    public static void runThree() {
        AsyncCounter runnable = new AsyncCounter();
        Thread first = new Thread(runnable);
        Thread second = new Thread(runnable);
        Thread third = new Thread(runnable);
        first.start();
        second.start();
        third.start();

        ThreadUtils.sleep(4000); // sleep 4 seconds
        System.out.println("\n\n1000000");
        System.out.println(runnable.getCount());
    }

    public static void runWithLock() {
        ReentrantLock lock = new ReentrantLock();
        ReentrantCounter runnable = new ReentrantCounter(lock);
        Thread first = new Thread(runnable);
        Thread second = new Thread(runnable);
        first.start();
        second.start();
    
        ThreadUtils.sleep(5000); // sleep 5 seconds
        System.out.println(runnable.getCount());
    }
    

    public static void runWithSyncdCounter() {
        SynchronizedCounter runnable = new SynchronizedCounter();
        Thread first = new Thread(runnable);
        Thread second = new Thread(runnable);
        first.start();
        second.start();
    
        ThreadUtils.sleep(5000); // sleep 5 seconds
        System.out.println(runnable.getCount());
    }
    public static void runWithSyncdBlock() {
        SynchronizedBlock runnable = new SynchronizedBlock();
        Thread first = new Thread(runnable);
        Thread second = new Thread(runnable);
        first.start();
        second.start();
    
        ThreadUtils.sleep(5000); // sleep 5 seconds
        System.out.println(runnable.getCount());
    }
}
