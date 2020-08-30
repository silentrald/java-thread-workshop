

public class Driver {

    public static void main(String[] args) {
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

        System.out.println("Done");
    }

}