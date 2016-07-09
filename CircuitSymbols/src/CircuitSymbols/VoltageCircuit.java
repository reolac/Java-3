package CircuitSymbols;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Instruction set to draw the circuit
 *
 * @author Michael Smith
 * @version 1.3
 * @since 7/10/14
 */
public class VoltageCircuit {

    double x;
    double y;
    boolean switchState;

    /**
     * Constructor for the class
     *
     * @param x X coordinate from the Component
     * @param y Y coordinate from the Component
     * @param switchState controls the light and opening and closing the switch
     */
    public VoltageCircuit(double x, double y, boolean switchState) {
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

        Line2D.Double wire1
                = new Line2D.Double(x, y + -50, x, y + 50);

        Line2D.Double wire2
                = new Line2D.Double(x + 150, y + -50, x + 150, y + 50);

        Line2D.Double wire3
                = new Line2D.Double(x, y, x + 50, y);

        Line2D.Double wire4
                = new Line2D.Double(x + 100, y, x + 150, y);

        Line2D.Double wire5
                = new Line2D.Double(x, y + 50, x + 50, y + 50);

        Line2D.Double wire6
                = new Line2D.Double(x + 100, y + 50, x + 150, y + 50);

        OpenSwitch openswitch1 = new OpenSwitch(0, -50, switchState);
        Cell cell1 = new Cell(x + 90, y + -50);
        Lamp lamp1 = new Lamp(x + 35, y + 0, switchState);
        Voltmeter voltMeter = new Voltmeter(x + 35, y + 50);

        openswitch1.draw(g2);
        cell1.draw(g2);
        lamp1.draw(g2);
        voltMeter.draw(g2);
        g2.draw(wire1);
        g2.draw(wire2);
        g2.draw(wire3);
        g2.draw(wire4);
        g2.draw(wire5);
        g2.draw(wire6);

        if (switchState == true) {
            lamp1.fill(g2);
        }
    }
}
