package CircuitSymbols;

import javax.swing.*;

/**
 * Main method to view the JFrame
 * 
 * @author Michael Smith
 * @version 1.3
 * @since 7/10/14
 */
public class AmmeterViewer {

    /**
     * Creates and displays an empty JFrame and plugs in Components
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 400;
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Ammeter Viewer");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AmmeterComponent ammeterComponent = new AmmeterComponent();
        frame.add(ammeterComponent);
    }
}
