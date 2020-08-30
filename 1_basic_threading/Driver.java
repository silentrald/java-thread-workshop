

public class Driver {

    public static void main(String[] args) {
        // Since CustomThread extends the Thread Class,
        // we can directly instatiate it to a Thread Object
        Thread ct2 = new CustomThread(2000);
        Thread ct1 = new CustomThread(1000);

        // This will start the thread
        ct1.start();
        ct2.start();

        try {
            ct1.join();
            ct2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Instead of the Class of Object is being instatiate,
        // We can instantiate a new Thread with the CustomThread
        // since the CustomThread is a Runnable Object
        Thread t1 = new Thread(new CustomThread("Hello in 2s", 2000));
        Thread t2 = new Thread(new CustomThread("Hello in 0.5s", 500));
        
        try {
            t1.start();
            t2.start();

            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // We can use a lambda expression to declare the run() function
        Thread lt1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Hello in 1s");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread lt2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Hello in 2s");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            lt1.start();
            lt2.start();

            lt.join();
            lt2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}