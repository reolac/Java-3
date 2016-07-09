package bouncingballs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Michael Smith
 */
public class ColoredBallPanel extends JPanel {

    List<ColoredBall> balls = new ArrayList<>();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (ColoredBall ball : balls) {
            g.setColor(getRandomColor());
            ball.draw(g);

        }
    }

    /**
     *
     * @param ball
     */
    public void addBall(ColoredBall ball) {
        balls.add(ball);
        repaint();
    }

    private final Random randomNumber = new Random();

    private Color getRandomColor() {
        return new Color(randomNumber.nextFloat(),
                randomNumber.nextFloat(), randomNumber.nextFloat());
    }

}
