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
            String msg;
            DataInputStream reader = new DataInputStream(s.getInputStream());
            DataOutputStream writer = new DataOutputStream(s.getOutputStream());
            
            // This checks whether the string that was sent from
            // the client side is the terminal "END" else we
            // send the string back to the client
            while (!(msg = reader.readUTF()).equals("END")) {
                writer.writeUTF("Server: " + msg);
            }

            s.close();
        } catch (Exception e) {
            // e.printStackTrace(); // Uncomment this if you want to look at the error thrown
        } finally {
            System.out.println("Server: Client " + s.getRemoteSocketAddress() + " has disconnected");
        }
    }

}