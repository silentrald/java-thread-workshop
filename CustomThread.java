

public class CustomThread extends Thread {

    private String msg;
    private long delay;

    public CustomThread(String msg, long delay) {
        this.msg = msg;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}