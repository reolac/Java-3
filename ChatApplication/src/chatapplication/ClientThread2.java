package chatapplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Michael
 */
public class ClientThread2 extends Thread {

    private final Socket CLIENT_SOCKET;
    private final int CLIENT_ID;
    private boolean running = true;

    ClientThread2(Socket s, int i) {
        CLIENT_SOCKET = s;
        CLIENT_ID = i;
    }

    /**
     * @Override overrides the runnable run method which states what actions to
     * perform when the thread runs
     */
    @Override
    public void run() {

        System.out.println("Accepted Client : ID - " + CLIENT_ID);
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(CLIENT_SOCKET.getInputStream()));
            String id = in.readLine();
            PrintWriter out = new PrintWriter(new OutputStreamWriter(CLIENT_SOCKET.getOutputStream()));

            while (running) {

                String clientCommand = in.readLine();

                if (clientCommand.equalsIgnoreCase(".bye")) {
                    running = false;
                    System.out.println("Stopping client thread for client : " + id);
                } else {
                    out.println("hello");
                    System.out.println(id + ">>" + clientCommand);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
