

public class CustomThread extends Thread {

    private String msg;
    private long delay;

    public CustomThread(String msg, long delay) {
        this.msg = msg;
        this.delay = delay;
    }

    /**
     * Once the thread has been started (called by start())
     * Then, this function will be run asynchronously with
     * the main thread.
     */
    @Override
    public void run() {
        try {
            // Thread.sleep will make the thread sleep for
            // delay(long) millisecond
            Thread.sleep(delay);
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}