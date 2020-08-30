

public class CustomThread implements Runnable {

    private long delay;

    public CustomThread(long delay) {
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