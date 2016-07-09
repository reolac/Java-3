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
public class ChatClient3 {

    private Socket socket;
    private ClientUI frame;
    

    /**
     *
     * @param serverName the connecting address of the server
     * @param port the connecting port of the address
     * @param frame the frame interface
     * @throws IOException if no address or port is found
     */
    public ChatClient3(String serverName, int port, ClientUI frame) throws IOException {
        this.frame = frame;
        frame.sendMessage(
                "Establishing connection. Please wait ...");
        try {
            Socket socket
                    = new Socket(serverName, port);
            frame.sendMessage(
                    "Client socket created: " + socket);
            Scanner in = new Scanner(System.in);
            PrintWriter out
                    = new PrintWriter(socket.getOutputStream());

            String line = ""; // Need an initial string
            while (!line.equals(".bye")) {

                line = frame.getText();
                
                out.println(line);
                out.flush();
            }
        } // End try
        catch (UnknownHostException e) {
        } catch (IOException e) {
        } finally {
            frame.sendMessage("Closing connection ...");
            //System.exit(1);
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[])
            throws IOException {
        ChatClient3 client;

        String serverName = "localhost";
        int port = 8888;

    }

}
