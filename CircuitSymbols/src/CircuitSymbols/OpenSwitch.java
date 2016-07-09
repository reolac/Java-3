package CircuitSymbols;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 * Instruction set to draw the shape
 *
 * @author Michael Smith
 * @version 1.3
 * @since 7/10/14
 */
public class OpenSwitch {

    double x;
    double y;
    boolean switchState;

    /**
     * Constructor for the class
     *
     * @param x X coordinate from the Component
     * @param y Y coordinate from the Component
     * @param switchState states if the switch is open or closed
     */
    public OpenSwitch(double x, double y, boolean switchState) {
        this.x = x;
        this.y = y;
        this.switchState = switchState;
    }

    /**
     * Creates objects of each shape which is to be drawn, sets coordinates and
     * size then draws each shape
     *
     * @param g2 Graphics2D paintComponent attribute from the JComponent class
     */
    public void draw(Graphics2D g2) {

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setStroke(new BasicStroke(2));

        Line2D.Double line1
                = new Line2D.Double(x + 100, y + 150, x + 125, y + 150);

        Ellipse2D.Double circle1
                = new Ellipse2D.Double(x + 125, y + 145, 10, 10);

        Line2D.Double openswitch1
                = new Line2D.Double(x + 135, y + 150, x + 160, y + 140);

        Line2D.Double closeswitch1
                = new Line2D.Double(x + 135, y + 150, x + 160, y + 150);

        Ellipse2D.Double circle2
                = new Ellipse2D.Double(x + 160, y + 145, 10, 10);

        Line2D.Double line3
                = new Line2D.Double(x + 170, y + 150, x + 195, y + 150);

        g2.draw(line1);
        g2.draw(circle1);

        if (switchState == false) {
            g2.draw(openswitch1);
        }

        if (switchState == true) {
            g2.draw(closeswitch1);
        }

        g2.draw(circle2);
        g2.draw(line3);
    }
}
