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
public class Voltmeter {

    double x;
    double y;

    /**
     * Constructor for the class
     *
     * @param x X coordinate from the Component
     * @param y Y coordinate from the Component
     */
    public Voltmeter(double x, double y) {
        this.x = x;
        this.y = y;
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
                = new Line2D.Double(x, y, x + 25, y);

        Ellipse2D.Double circle1
                = new Ellipse2D.Double(x + 25, y + -15, 30, 30);

        Line2D.Double line2
                = new Line2D.Double(x + 55, y, x + 80, y);

        g2.draw(line1);
        g2.draw(circle1);
        g2.draw(line2);

        Font voltmeterFont = new Font("Arial", Font.PLAIN, 18);
        g2.setFont(voltmeterFont);
        String voltmeterString = "V";
        g2.drawString(voltmeterString, (int) x + 36, (int) y + 7);
    }
}
