

public class CustomThread implements Runnable {

    private Thread t;
    private long delay;

    public Thread getThread() {
        return t;
    }

    public CustomThread(long delay) {
        t = new Thread(this);
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println("Print with delay of " + delay);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}