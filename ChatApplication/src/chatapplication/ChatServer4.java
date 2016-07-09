package chatapplication;

import java.net.*;
import java.io.*;

/**
 *
 * @author Michael
 */
public final class ChatServer4 {

    private int id = 0;

    /**
     *
     * @param port the connecting port of the address
     * @throws IOException if no address or port exists
     */
    public ChatServer4(int port) throws IOException {
        ServerSocket server;
        Socket socket = null;
        try {
// Register service on port 8888
            server = new ServerSocket(port);
// Wait and accept a connection
            socket = getConnection(server, socket);

            // Get streams associated with the socket
            while (true) {
                socket = server.accept();
                ClientThread2 cliThread = new ClientThread2(socket, id++);
                cliThread.start();
            }
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
     * @param server the address of the server
     * @param socket the socket to listen
     * @return the client connecting to the socket
     * @throws IOException if the client does not exist
     */
    public Socket getConnection(ServerSocket server, Socket socket) throws IOException {
        socket = null;
        System.out.println("Server started: " + server);
        System.out.println("Waiting for conection ...");

        return socket;
    }

    /**
     *
     * @param args command line arguments
     * @throws IOException if the client does not exist
     */
    public static void main(String[] args) throws IOException {
        ChatServer4 server;
        int port = Integer.parseInt("8888");
        System.out.println("port = " + port);
        server = new ChatServer4(port);

    }
}
