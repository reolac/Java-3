package chatapplication;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Michael
 */
public class ChatServer {

    /**
     *
     * @param port the connecting port of the address
     * @throws IOException if no address or port exists
     */
    public ChatServer(int port) throws IOException {

        ServerSocket server;
        Socket socket = null;
        try {
// Register service on port 8888
            server = new ServerSocket(port);
// Wait and accept a connection
            System.out.println("Server started: " + server);
            System.out.println("Waiting for conection ...");
            socket = server.accept();
            System.out.println("Socket created: " + socket);
            System.out.println("Connected to client ...");
            // Get streams associated with the socket
            Scanner in = new Scanner(socket.getInputStream());
            boolean done = false;
            while (!done) {
                String line = in.nextLine();
                System.out.println(line);
                done = line.equals(".bye");
            }
            server = new ServerSocket(port);
// Wait and accept a connection
            System.out.println("Server started: " + server);
            System.out.println("Waiting for conection ...");
            socket = server.accept();
            System.out.println("Socket created: " + socket);
            System.out.println("Connected to client ...");
        } //End try
        catch (IOException e) {
            System.out.println(e);
        } finally {
            socket.close();
            System.out.println("Connection closed ...");
        }
    }

    /**
     *
     * @param args command line arguments
     * @throws IOException if the client does not exist
     */
    public static void main(String[] args) throws IOException {
        ChatServer server;
        int port = Integer.parseInt("8888");
        System.out.println("port = " + port);
        server = new ChatServer(port);
    }
}
