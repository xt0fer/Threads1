package conflict;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nRun Two AsyncCounters");
        runTwo();
        System.out.println("\n\nRun Three AsyncCounters");
        runThree();
    }
    public static void runTwo() {
        AsyncCounter runnable = new AsyncCounter();
        Thread first = new Thread(runnable);
        Thread second = new Thread(runnable);
        first.start();
        second.start();

        ThreadUtils.sleep(5000); // sleep 5 seconds
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

        ThreadUtils.sleep(5000); // sleep 5 seconds
        System.out.println("\n\n1000000");
        System.out.println(runnable.getCount());
    }
}
