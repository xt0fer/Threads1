package conflict;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantCounter implements Runnable {
    private int count = 0;
    private ReentrantLock lock;

    public ReentrantCounter(ReentrantLock lock) {this.lock = lock;}

    public void run() {
        lock.lock(); // thread resources locked
        for(int i = 0; i < 1_000_000; i++) {
            count = count + 1;
        }
        String currentThread = Thread.currentThread().toString();
        System.out.println("THREAD FINISHED: " + currentThread);
        lock.unlock();  // thread resources unlocked
    }

    public int getCount() {
        return this.count;
    }
}