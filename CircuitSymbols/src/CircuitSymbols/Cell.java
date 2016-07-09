package CircuitSymbols;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Instruction set to draw the shape
 * 
 * @author Michael Smith
 * @version 1.3
 * @since 7/10/14
 */
public class Cell{

    double x;
    double y;

    /**
     * Constructor for the class
     *
     * @param x X coordinate from the Component
     * @param y Y coordinate from the Component
     */
    public Cell(double x, double y) {
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

        //x =  - 100
                //y = -150
        
        
        Line2D.Double line1
                = new Line2D.Double(x, y, x + 24, y);

        Line2D.Double line2
                = new Line2D.Double(x + 25, y + 10, x + 25, y + -10);

        Rectangle2D.Double rect1
                = new Rectangle2D.Double(x + 30, y + -7, 5, 15);

        Line2D.Double line3
                = new Line2D.Double(x + 35, y, x + 60, y);

        g2.draw(line1);
        g2.draw(line2);
        g2.fill(rect1);
        g2.draw(line3);
    }
}
