package conflict;

public class ThreadUtils {
    public static void sleep(Integer milliseconds) {
        try {
          Thread.sleep(milliseconds);
        } catch(InterruptedException e) {
          e.printStackTrace();
        }
      }
}
