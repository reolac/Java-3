package chatapplication;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Michael
 */
public class ServerUI extends JFrame {

    public static JTextArea chat = new JTextArea(35, 5);

    private ChatServer5 server;

    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 200;

    /**
     * Constructs the JFrame and adds Panels, Buttons, Sliders and Listeners to
     * it
     *
     * @param port the connecting port 
     * @throws java.io.IOException if the port or address do not exist
     */
    public ServerUI(int port) throws IOException {
        server = null;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);

        JPanel chatPanel = new JPanel();
        chat.setEditable(false);

        JScrollPane scroll = new JScrollPane(chat);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        chatPanel.add(chat);

        add(chatPanel);

        setTitle("Chat Server");

        class ButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {

            }
        }

        ActionListener listener = new ButtonListener();

        server = new ChatServer5(port, this);
    }

    /**
     *
     * @param args command line arguments
     * @throws IOException if the port or address do not exist
     */
    public static void main(String[] args) throws IOException {
        new ServerUI(8888);
    }

    /**
     *
     * @param message the message to be send to the text area
     */
    public void sendMessage(String message) {

        chat.append(message + "\n");

    }

}
