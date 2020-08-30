import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        String host = "localhost"; // can be changed
        int port = 5000;

        String msg;
        try {
            Socket endpoint = new Socket(host, port);

            System.out.println("Client: Has connected to server " + host + ":" + port);

            DataInputStream reader = new DataInputStream(endpoint.getInputStream());
            // DataOutputStream writer = new DataOutputStream(endpoint.getOutputStream());

            // Check if the message read is not equal to "END"
            // so we can print what the server said
            while (!(msg = reader.readUTF()).equals("END")) {
                System.out.println("Server said " + msg);
            }

            System.out.println("Client has terminated connection");

            endpoint.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}