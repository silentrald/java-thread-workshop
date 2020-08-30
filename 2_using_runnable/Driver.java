

public class Driver {

    public static void main(String[] args) {
        // Instead of the Class of Object is being instatiate,
        // We can instantiate a new Thread with the CustomThread
        // since the CustomThread is a Runnable Object
        Thread t1 = new Thread(new CustomThread("Hello in 2s", 2000));
        Thread t2 = new Thread(new CustomThread("Hello in 0.5s", 500));
        
        try {
            ct1.start();
            ct2.start();

            ct1.join();
            ct2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}