package chatapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class ChatClient2 {

    private Socket socket;

    /**
     *
     * @param serverName the connecting address of the server
     * @param port the connecting port of the address
     * @throws IOException if no address or port is found
     */
    public ChatClient2(String serverName, int port) throws IOException {

        System.out.println(
                "Establishing connection. Please wait ...");
        try {
            Socket socket
                    = new Socket(serverName, port);
            System.out.println(
                    "Client socket created: " + socket);
            System.out.print("Enter your chat name :> ");
            Scanner in = new Scanner(System.in);
            PrintWriter out
                    = new PrintWriter(socket.getOutputStream());
            
            

            String line = ""; // Need an initial string
            while (!line.equals(".bye")) {

                line = in.nextLine();

                out.println(line);
                out.flush();

            }
        } // End try
        catch (UnknownHostException e) {
        } catch (IOException e) {
        } finally {
            System.out.println("Closing connection ...");
            //System.exit(1);
        }
    }

    /**
     * @param args the command line arguments
     * @throws IOException if no address or port is found
     */
    public static void main(String args[])
            throws IOException {
        ChatClient2 client;

        String serverName = "localhost";
        int port = 8888;
        client = new ChatClient2(serverName, port);

    }

}
