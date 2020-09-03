import java.io.*;
import java.net.*;
import java.util.*; // For Scanner

public class Client {

    public static void main(String[] args) {
        String host = "localhost"; // can be changed
        int port = 5000;

        Scanner sc = new Scanner(System.in);

        String msg;
        try {
            Socket endpoint = new Socket(host, port);

            System.out.println("Client: Has connected to server " + host + ":" + port);

            DataInputStream reader = new DataInputStream(endpoint.getInputStream());
            DataOutputStream writer = new DataOutputStream(endpoint.getOutputStream());

            System.out.print("> ");
            // Let's try inputting a string in the console
            while (!(msg = sc.nextLine()).equals("END")) {
                // The message will be send to the server
                writer.writeUTF(msg);
                // The Server will append "Server: " so that
                // we know that the message really was accepted
                // by the server
                System.out.println(reader.readUTF());
                System.out.print("> ");
            }

            // Send the terminal String to the Server
            writer.writeUTF("END");

            System.out.println("Client: has terminated connection");

            endpoint.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}