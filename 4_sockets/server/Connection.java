import java.io.*;
import java.net.*;
import java.util.*;

public class Connection extends Thread {

    private Socket s;
    private static HashMap<String, Connection> connections = new HashMap<>();

    public Connection(Socket s) {
        this.s = s;
        connections.put(s.getRemoteSocketAddress().toString(), this);
    }

    @Override
    public void run() {
        try {
            int ctr = 0;

            // DataInputStream reader = new DataInputStream(s.getInputStream());
            DataOutputStream writer = new DataOutputStream(s.getOutputStream());

            while (ctr < 10) {
                Thread.sleep(1000);
                ctr++;
                System.out.println("Server: Sending Hello " + ctr + " to Client " + s.getRemoteSocketAddress());
                writer.writeUTF("Hello " + ctr);
            }
            writer.writeUTF("END");

            connections.remove(s.getRemoteSocketAddress().toString());
            s.close();
        } catch (Exception e) {
            // e.printStackTrace(); // Uncomment this if you want to look at the error thrown
        } finally {
            System.out.println("Server: Client " + s.getRemoteSocketAddress() + " has disconnected");
        }
    }

}