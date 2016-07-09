package dicegame;

import java.awt.*;

/**
 * Instruction set to draw the dice depending on the value rolled
 * @author Michael Smith
 * @version 1.1
 * @since 23/10/2014
 */
public class DiceFace {

    String m;

    /**
     * @param i size of the dice
     * @param j x position of the dice
     * @param k y position of the dice
     * @param l value of the dice
     * @param m colour of the dice
     */
    public DiceFace(int i, int j, int k, int l, String m) {
        dots = new java.awt.geom.Ellipse2D.Double[7];
        side = i;
        xLeft = j;
        yTop = k;
        diceValue = l;
        this.m = m;
    }

    /**
     * Sets the face value of the dice
     *
     * @param i diceValue carried from constructor
     */
    public void setDiceFace(int i) {
        diceValue = i;
    }

    /**
     * Uses graphics to draw the dice based on colour, dice value and position
     * from the constructor
     *
     * @param graphics2d implements swing
     */
    public void draw(Graphics2D graphics2d) {
        box = new Rectangle(xLeft, yTop, side, side);
        makeDots();

        if (m == "black") {
            graphics2d.setColor(Color.BLACK);
        }

        if (m == "red") {
            graphics2d.setColor(Color.RED);
        }

        graphics2d.fill(box);
        graphics2d.setColor(Color.WHITE);
        if (diceValue == 1) {
            graphics2d.fill(dots[0]);
        } else if (diceValue == 2) {
            graphics2d.fill(dots[1]);
            graphics2d.fill(dots[2]);
        } else if (diceValue == 3) {
            graphics2d.fill(dots[0]);
            graphics2d.fill(dots[1]);
            graphics2d.fill(dots[2]);
        } else if (diceValue == 4) {
            graphics2d.fill(dots[1]);
            graphics2d.fill(dots[2]);
            graphics2d.fill(dots[3]);
            graphics2d.fill(dots[4]);
        } else if (diceValue == 5) {
            graphics2d.fill(dots[0]);
            graphics2d.fill(dots[1]);
            graphics2d.fill(dots[2]);
            graphics2d.fill(dots[3]);
            graphics2d.fill(dots[4]);
        } else if (diceValue == 6) {
            graphics2d.fill(dots[1]);
            graphics2d.fill(dots[2]);
            graphics2d.fill(dots[3]);
            graphics2d.fill(dots[4]);
            graphics2d.fill(dots[5]);
            graphics2d.fill(dots[6]);
        }
    }

    /**
     * Creates dots to be filled
     */
    public void makeDots() {
        int i = side / 6;
        int j = side / 6;
        dots[0] = new java.awt.geom.Ellipse2D.Double((double) xLeft + (2.5D * (double) side) / 6D, (double) yTop + (2.5D * (double) side) / 6D, j, i);
        dots[1] = new java.awt.geom.Ellipse2D.Double((double) xLeft + (3.75D * (double) side) / 6D, (double) yTop + (3.75D * (double) side) / 6D, j, i);
        dots[2] = new java.awt.geom.Ellipse2D.Double((double) xLeft + (1.25D * (double) side) / 6D, (double) yTop + (1.25D * (double) side) / 6D, j, i);
        dots[3] = new java.awt.geom.Ellipse2D.Double((double) xLeft + (1.25D * (double) side) / 6D, (double) yTop + (3.75D * (double) side) / 6D, j, i);
        dots[4] = new java.awt.geom.Ellipse2D.Double((double) xLeft + (3.75D * (double) side) / 6D, (double) yTop + (1.25D * (double) side) / 6D, j, i);
        dots[5] = new java.awt.geom.Ellipse2D.Double((double) xLeft + (1.25D * (double) side) / 6D, (double) yTop + (2.5D * (double) side) / 6D, j, i);
        dots[6] = new java.awt.geom.Ellipse2D.Double((double) xLeft + (3.75D * (double) side) / 6D, (double) yTop + (2.5D * (double) side) / 6D, j, i);
    }

    private java.awt.geom.Ellipse2D.Double dots[];
    private Rectangle box;
    private int xLeft;
    private int yTop;
    private int side;
    private int diceValue;
}
