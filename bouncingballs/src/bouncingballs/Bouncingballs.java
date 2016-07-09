package bouncingballs;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Michael Smith
 */
public class Bouncingballs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BallsFrame ballsFrame = new BallsFrame();
                ballsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        });
    }

}
