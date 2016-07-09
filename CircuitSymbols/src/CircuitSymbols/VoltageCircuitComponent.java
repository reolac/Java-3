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
public class VoltageCircuitComponent extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        VoltageCircuit voltagecircuit1 = new VoltageCircuit(100, 150, false);
        voltagecircuit1.draw(g2);
    }
}
