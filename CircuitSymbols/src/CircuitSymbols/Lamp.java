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
public class Lamp{

    double x;
    double y;
    Boolean switchState;

    /**
     * Constructor for the class
     *
     * @param x X coordinate from the Component
     * @param y Y coordinate from the Component
     */
    public Lamp(double x, double y, Boolean switchState) {
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
                = new Line2D.Double(x, y, x + 25, y);

        Ellipse2D.Double circle1
                = new Ellipse2D.Double(x + 25, y + -15, 30, 30);

        Line2D.Double cross1
                = new Line2D.Double(x + 30.5, y + -8.5, x + 51, y + 8);

        Line2D.Double cross2
                = new Line2D.Double(x + 51, y + -8.5, x + 30.5, y + 8);

        Line2D.Double line2
                = new Line2D.Double(x + 55, y, x + 80, y);

        g2.draw(line1);
        g2.draw(circle1);
        g2.draw(cross1);
        g2.draw(cross2);
        g2.draw(line2);
    }
    
    public void fill(Graphics2D g2) {
        
          Ellipse2D.Double circle1
                = new Ellipse2D.Double(x + 25, y + -15, 30, 30);
          
          g2.setColor(Color.YELLOW);
          
          g2.fill(circle1);
        
    }
    
}
