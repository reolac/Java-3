package dicegame;

import javax.swing.*;

/**
 * Creates the game logic for CrapsGame used for the Tester and the component
 * @author Michael Smith
 * @since 28/10/2014
 * @version 1.3
 */
public class CrapsGame extends JComponent {

    int points;

    boolean over = false;
    boolean won;

    int d1;
    int d2;

    /**
     * Sets the dice to be a random number between 1 and 6
     *
     * @return returns the random value to d1
     */
    private int setd1() {
        d1 = (int) (Math.random() * 6 + 1);
        return d1;
    }

    /**
     * Sets the dice to be a random number between 1 and 6
     *
     * @return returns the random value to d2
     */
    private int setd2() {
        d2 = (int) (Math.random() * 6 + 1);
        return d2;
    }

    /**
     * Get the value of the first dice
     *
     * @return value of dice 1
     */
    public int getd1() {
        return d1;
    }

    /**
     * Get the value of the second dice
     *
     * @return value of dice 2
     */
    public int getd2() {
        return d2;
    }

    /**
     * Starts the first roll of the game and saves the point returning all of
     * the information as a string
     *
     * @return a string which prints out information regarding the first roll
     */
    public String doFirstroll() {
        d1 = setd1();
        d2 = setd2();
        points = d1 + d2;
        int sum = d1 + d2;
        if (sum == 7 || sum == 11) {
            won = true;
            over = true;
        }
        if (sum == 2 || sum == 3 || sum == 12) {
            won = false;
            over = true;
        }
        String firstRoll = ("d1 = " + d1 + " d2 = " + d2);
        return firstRoll;
    }

    /**
     * Rolls the dice again recording all of the values and returning it as a
     * string
     *
     * @return a string which prints out all the information regarding the
     * latest roll
     */
    public String rollAgain() {
        d1 = setd1();
        d2 = setd2();
        int sum = d1 + d2;
        String roll = ("d1 = " + d1 + " d2 = " + d2 + " sum = " + sum + " point = " + points);
        if (sum == 7 || sum == 11 || sum == points) {
            won = true;
            over = true;
        }
        if (sum == 2 || sum == 3 || sum == 12) {
            won = false;
            over = true;
        }
        return roll;
    }

    /**
     * Checks to see if the win condition was met during rolls
     *
     * @return if the game is won or lost
     */
    public boolean isWon() {
        return won;
    }

    /**
     * Checks to see if the game is currently in progress or not
     *
     * @return if the game is over or not
     */
    public boolean isOver() {
        return over;
    }
}
