package dicegame;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Deals with displaying the interface and graphics on the screen
 * @author Michael Smith
 * @since 23/10/2014
 * @version 1.3
 */
public class DiceViewer {

    /**
     * Sets up JFrame, JPanel and ActionListener using BorderLayout and pack to
     * position
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 300;
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Simple Dice Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final DiceComponent diceComponent = new DiceComponent();
        frame.add(diceComponent);
        JButton roll = new JButton("Roll'em!");
        JButton reset = new JButton("Reset");

        roll.addActionListener(new ActionListener() {
            @Override
            /**
             * Creates an ActionListener which repaints the instructions from
             * paintComponent
             *
             * @param e implements ActionListener
             */
            public void actionPerformed(ActionEvent e) {
                diceComponent.repaint();
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            /**
             * Creates an ActionListener which repaints the instructions from
             * paintComponent
             *
             * @param e implements ActionListener
             */
            public void actionPerformed(ActionEvent e) {
                diceComponent.running = false;
                diceComponent.firstRoll = false;
                diceComponent.repaint();
            }
        });

        JPanel panel = new JPanel();
        panel.add(roll);
        panel.add(reset);
        frame.add(panel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}
