package chatapplication;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Michael
 */
public final class ChatServer2 {

    /**
     *
     * @param port the connecting port of the address
     * @throws IOException if no address or port exists
     */
    public ChatServer2(int port) throws IOException {

        ServerSocket server;
        Socket socket = null;
        try {
// Register service on port 8888
            server = new ServerSocket(port);
// Wait and accept a connection
            socket = getConnection(server, socket);
            
            // Get streams associated with the socket
            
            while (true) {
            
                Scanner in = new Scanner(socket.getInputStream());
                String line = in.nextLine();
                System.out.println(line);
                if (line.equals(".bye")) {
                    socket = getConnection(server, socket);
                }
            }
            
                
        } 
//End try
        catch (IOException e) {
            System.out.println(e);
        } finally {
            socket.close();
            System.out.println("Connection closed ...");
        }
    }

    /**
     *
     * @param server the address of the server
     * @param socket the socket to listen
     * @return the client connecting to the socket
     * @throws IOException if the client does not exist
     */
    public Socket getConnection(ServerSocket server, Socket socket) throws IOException {
        System.out.println("Server started: " + server);
        System.out.println("Waiting for conection ...");
        socket = server.accept();
        System.out.println("Socket created: " + socket);
        System.out.println("Connected to client ...");
        return socket;
    }

    /**
     *
     * @param args command line arguments
     * @throws IOException if the client does not exist
     */
    public static void main(String[] args) throws IOException {
        ChatServer2 server;
        int port = Integer.parseInt("8888");
        System.out.println("port = " + port);
        server = new ChatServer2(port);
    }
}
