

public class Driver {

    public static void main(String[] args) {
        CustomThread ct1 = new CustomThread("Hello in 2s", 2000);
        CustomThread ct2 = new CustomThread("Hello in 0.5s", 500);

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