package CircuitSymbols;

import java.awt.*;
import javax.swing.*;

/**
 * Sets up the paintComponent and calls on the Shape class for the instruction
 * set
 *
 * @author Michael Smith
 * @version 1.3
 * @since 7/10/14
 */
public class OpenSwitchComponent extends JComponent {

    /**
     * @param g parameter referring to the graphics in JComponent
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        OpenSwitch openswitch1 = new OpenSwitch(0, 0, false);
        openswitch1.draw(g2);
    }
}
