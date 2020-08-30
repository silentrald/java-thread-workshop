

public class Driver {

    public static void main(String[] args) {
        Thread t1 = new Thread(new CustomThread("Hello in 2s", 2000));
        Thread t2 = new Thread(new CustomThread("Hello in 0.5s", 500));
        
        try {
            ct1.start();
            ct2.start();

            ct1.getThread().join();
            ct2.getThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}