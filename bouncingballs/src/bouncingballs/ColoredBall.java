package bouncingballs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

/**
 *
 * @author Michael Smith
 */
public class ColoredBall extends JPanel {

    int x;
    int y;

    /**
     *
     * @param x the horizontal position of the ball
     * @param y the vertical position of the ball
     */
    public ColoredBall(int x, int y) {
        this.x = x;
        this.y = y;

    }

    /**
     *
     * @param g swings graphic api calling to paint shapes to the panel
     */
    public void draw(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Ellipse2D.Double ball
                = new Ellipse2D.Double(x, y, 20, 20);

        g2.fill(ball);
    }

}
