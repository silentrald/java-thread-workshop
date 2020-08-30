

public class Driver {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("hello");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("hello2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            t.start();
            t2.start();

            t.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}