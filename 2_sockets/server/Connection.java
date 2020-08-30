import java.io.*;
import java.net.*;

public class Connection extends Thread {

    private Socket s;

    public Connection(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            int ctr = 0;

            // DataInputStream reader = new DataInputStream(s.getInputStream());
            DataOutputStream writer = new DataOutputStream(s.getOutputStream());

            // Send the Client 10 Hello messages
            while (ctr < 10) {
                Thread.sleep(1000);
                ctr++;
                System.out.println("Server: Sending Hello " + ctr + " to Client " + s.getRemoteSocketAddress());
                writer.writeUTF("Hello " + ctr);
            }
            // Give the terminal value to the client
            writer.writeUTF("END");

            s.close();
        } catch (Exception e) {
            // e.printStackTrace(); // Uncomment this if you want to look at the error thrown
        } finally {
            System.out.println("Server: Client " + s.getRemoteSocketAddress() + " has disconnected");
        }
    }

}