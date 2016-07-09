package chatapplication;

import java.net.*;
import java.io.*;

/**
 *
 * @author Michael
 */
public final class ChatServer5 {

    private int id = 0;

    private static ServerUI frame;

    /**
     *
     * @param port the connecting port of the address
     * @param frame the server frame interface
     * @throws IOException if no address or port exists
     */
    public ChatServer5(int port, ServerUI frame) throws IOException {
        this.frame = frame;
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
                ClientThread3 cliThread = new ClientThread3(socket, id++);

                cliThread.start();

            }
        } //End try
        catch (IOException e) {
            System.out.println(e);
        } finally {
            socket.close();
            frame.sendMessage("Connection closed ...");
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
        frame.sendMessage("Server started: " + server);
        frame.sendMessage("Waiting for conection ...");
        return socket;
    }

    /**
     *
     * @param args command line arguments
     * @throws IOException if the client does not exist
     */
    public static void main(String[] args) throws IOException {

        ChatServer5 server;
        int port = Integer.parseInt("8888");
        frame.sendMessage("port = " + port);
        server = new ChatServer5(port, frame);
    }
}
