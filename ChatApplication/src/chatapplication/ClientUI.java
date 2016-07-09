package chatapplication;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Michael
 */
public class ClientUI extends JFrame {

    private ChatClient3 client;

    private final JTextArea chat;

    private JTextField input;

    private String name;

    private boolean spamFlag = false;

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 200;

    /**
     *
     * @param port the server port to connect to 
     * @throws IOException if the port or address do not exist
     */
    public ClientUI(int port) throws IOException {

        final JFrame frame = new JFrame();
        frame.setSize(200, 325);
        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel usr = new JLabel("Username:");
        final JTextField username = new JTextField("", 10);
        JLabel pass = new JLabel("Password:");
        final JPasswordField password = new JPasswordField("", 10);
        final JButton login = new JButton("login");

        panel.add(usr);
        panel.add(username);
        panel.add(pass);
        panel.add(password);
        panel.add(login);
        frame.add(panel);

        frame.setVisible(true);

        client = null;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        JPanel inputPanel = new JPanel();
        final JButton send = new JButton("send");
        input = new JTextField("", 20);

        inputPanel.add(input, BorderLayout.CENTER);
        inputPanel.add(send, BorderLayout.EAST);

        add(inputPanel, BorderLayout.NORTH);

        JPanel chatPanel = new JPanel();
        chat = new JTextArea(35, 5);
        chat.setEditable(false);

        chatPanel.add(chat);

        add(chatPanel);

        setTitle("Chat Client");

        class ButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == send) {

                    if (input.getText().length() > 20 && spamFlag == false) {
                        sendMessage(name + " - too prolix!!!");
                        sendMessage("Disconnecting now ...");
                        input.setText("disconnected");
                        input.setEditable(false);
                        send.setEnabled(false);
                        spamFlag = true;
                    } else if (input.getText().length() > 0 && spamFlag == false) {

                        String message = input.getText();
                        input.setText("");

                        sendMessage(name + ">>" + message);
                    }

                }

                if (event.getSource() == login) {

                    if (password.getPassword().length == 0 || username.getText().length() == 0) {
                        JOptionPane.showMessageDialog(frame,
                                "Invalid username or password",
                                "Error Message",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        name = username.getText();
                        setVisible(true);
                        frame.setVisible(false);
                    }
                }
            }
        }
        ActionListener listener = new ButtonListener();
        send.addActionListener(listener);
        login.addActionListener(listener);
        client = new ChatClient3("localhost", 8888, this);
    }

    /**
     *
     * @param args command line arguments
     * @throws IOException if the port or address do not exist
     */
    public static void main(String[] args) throws IOException {

        new ClientUI(8888);
    }

    /**
     *
     * @param message message to be printed onto the text area
     */
    public void sendMessage(String message) {
        chat.append(message + "\n");

    }

    /**
     *
     * @return text placed in the text field
     */
    public String getText() {
        String text = input.getText() + "";
        return text;
    }

}
