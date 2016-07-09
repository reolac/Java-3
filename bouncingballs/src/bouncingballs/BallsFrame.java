package bouncingballs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Michael
 */
public class BallsFrame extends JFrame {

    private ColoredBallPanel coloredBallPanel;

    private final int FRAME_WIDTH = 600;
    private final int FRAME_HEIGHT = 500;

    /**
     * Constructs the JFrame and adds Panels, Buttons, Sliders and Listeners to
     * it
     */
    public BallsFrame() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);
        JPanel controlPanel = new JPanel();
        final JButton start = new JButton("Start");
        final JButton pause = new JButton("Pause");
        final JButton stop = new JButton("Stop");
        final JSlider velocity = new JSlider(JSlider.HORIZONTAL, 1, 5, 3);
        velocity.setPaintTicks(true);
        velocity.setMajorTickSpacing(1);
        velocity.setPaintLabels(true);
        velocity.setSnapToTicks(true);

        controlPanel.add(start);
        controlPanel.add(pause);
        controlPanel.add(stop);
        controlPanel.add(velocity);
        setTitle("Bouncing Balls");
        coloredBallPanel = new ColoredBallPanel();
        add(coloredBallPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        class ButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == start) {

                    addBall((int) (Math.random() * FRAME_WIDTH), (int) (Math.random() * FRAME_HEIGHT));
                    ColoredBallRunnable.running = true;
                }

                if (event.getSource() == pause) {

                    ColoredBallRunnable.running = false;

                }

                if (event.getSource() == stop) {
                    System.exit(1);
                }
            }
        }

        class SliderListener implements ChangeListener {

            @Override
            public void stateChanged(ChangeEvent velocity) {
                JSlider slider = (JSlider) velocity.getSource();
                if (!slider.getValueIsAdjusting()) {
                    System.out.println("slider.getValue() = " + slider.getValue());
                    ColoredBallRunnable.speed = slider.getValue();
                    coloredBallPanel.repaint();

                }
            }
        }

        ActionListener listener = new ButtonListener();
        start.addActionListener(listener);
        pause.addActionListener(listener);
        stop.addActionListener(listener);

        ChangeListener cListener = new SliderListener();
        velocity.addChangeListener(cListener);
    }

    // addBall to panel at specified coordinates (x,y)
    /**
     *
     * @param x the starting horizontal position of the ball
     * @param y the starting vertical position of the ball
     */
    public void addBall(int x, int y) {
        // create coloured ball and add to panel

        ColoredBall ball = new ColoredBall(x, y);
        coloredBallPanel.addBall(ball);

        // create a runnable to control ball
        Runnable r
                = new ColoredBallRunnable(ball, coloredBallPanel);

        Thread t = new Thread(r);
        t.start();
    }
}
