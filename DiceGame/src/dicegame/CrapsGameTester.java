package dicegame;

/**
 * Prints out the helper methods defined in CrapsGame to test the logic
 * @author Michael
 * @since 29/10/2014
 * @version 1
 */
public class CrapsGameTester {

    /**
     * Tests the login of CrapsGame by printing out the methods into the console
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CrapsGame game = new CrapsGame();
        String message = game.doFirstroll();
        System.out.println(message);

        while (!game.isOver()) {
            message = game.rollAgain();
            System.out.println(message);
        }

        if (game.isWon()) {
            System.out.println("You win, big man!");
        } else {
            System.out.println("Loser ...");
        }
    }
}
