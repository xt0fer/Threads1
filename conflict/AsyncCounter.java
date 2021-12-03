package conflict;

public class AsyncCounter implements Runnable {
    private int count = 0;

    public void run() {
        for(int i = 0; i < 1_000_000; i++) {
            count = count + 1;
        }
        String currentThread = Thread.currentThread().toString();
        System.out.println("\nTHREAD FINISHED: " + currentThread);
    }

    public int getCount() {
        return this.count;
    }
}
