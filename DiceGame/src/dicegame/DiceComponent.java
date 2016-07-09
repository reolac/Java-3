package dicegame;

import java.awt.*;
import javax.swing.*;

/**
 * Combines the instructions of drawing the shape with the game logic to update the dice 
 * graphics based on the status of the game
 * @author Michael Smith
 * @since 23/10/2014
 * @version 3
 */
public class DiceComponent extends JComponent {
    

    /**
     * Flag to tell if the game is current running
     */
    public boolean running = false;

    /**
     * Flag to tell if the first roll has happened in the current game
     */
    public boolean firstRoll = false;

    int point;

    /**
     * Constructor to set the frame size for the DiceComponent
     */
    public DiceComponent() {
        setPreferredSize(new Dimension(400, 200));
    }

    /**
     * Paints the dice on the screen based on the values defined in the game
     * logic
     *
     * @param g implements the swing library to paint the class
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Font myFont = new Font("Arial", Font.BOLD, 12);
        g2.setFont(myFont);
        CrapsGame game = new CrapsGame();

        if (running == false) {
            g2.drawString("Sum = 0", 135, 30);
            g2.drawString("Point = 0", 200, 30);
            DiceFace die1 = new DiceFace(100, 40, 60, (int) (Math.random() * 6 + 1), "black");
            DiceFace die2 = new DiceFace(100, 240, 60, (int) (Math.random() * 6 + 1), "red");
            die1.draw(g2);
            die2.draw(g2);
        }

        if (running == true) {
            if (firstRoll == false) {
                String first = game.doFirstroll();
                System.out.println(first);
                point = game.getd1() + game.getd2();
                firstRoll = true;
            } else {
                game.rollAgain();
                System.out.println("d1 = " + game.getd1() + " d2 = " + game.getd2()
                        + " sum = " + (game.getd1() + game.getd2()) + " point = " + point);
            }

            int d1 = game.getd1();
            int d2 = game.getd2();

            g2.drawString("Sum = " + (d1 + d2), 135, 30);
            g2.drawString("Point = " + point, 200, 30);

            DiceFace die1 = new DiceFace(100, 40, 60, d1, "black");
            DiceFace die2 = new DiceFace(100, 240, 60, d2, "red");

            die1.draw(g2);
            die2.draw(g2);

            if (game.isWon() == true && game.isOver() == true) {
                repaint();
                JOptionPane.showMessageDialog(null, "You win, big man!", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(1);
            }

            if (game.isWon() == false && game.isOver() == true) {
                repaint();
                JOptionPane.showMessageDialog(null, "You win, big man!", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(1);
            }
        }
        running = true;
    }
}
