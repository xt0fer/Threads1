package conflict;

public class SynchronizedCounter implements Runnable {
    private int count = 0;

    public void run() {
        for(int i = 0; i < 1_000_000; i++) { incrementCount(); }
        String currentThread = Thread.currentThread().toString();
        System.out.println("THREAD FINISHED: " + currentThread);
    }

    /* 
    * LOOKE HERE: see the synchronized KEYWORD???
    */
    public synchronized void incrementCount() { this.count+=1; }

    public int getCount() { return count; }
}