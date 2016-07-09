package bouncingballs;

/**
 *
 * @author Michael Smith
 */
public class ColoredBallRunnable implements Runnable {

    final int DELAY = 100;
    private final ColoredBall ball;
    private final ColoredBallPanel coloredBallPanel;
    private final int RADIUS = 20;
    static boolean running = true;
    static int speed = 3;

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;

    private int ballSpeedX = speed;
    private int ballSpeedY = speed;

    /**
     *
     * @param ball calls the current ball on this thread
     * @param coloredBallPanel calls the JPanel where the balls are drawn
     */
    public ColoredBallRunnable(ColoredBall ball, ColoredBallPanel coloredBallPanel) {
        this.ball = ball;
        this.coloredBallPanel = coloredBallPanel;

        PANEL_WIDTH = coloredBallPanel.getWidth();
        PANEL_HEIGHT = coloredBallPanel.getHeight();
    }

    @Override
    public void run() {
        while (true) {
            while (running == false) {
            }
            ball.repaint();
            ball.x += ballSpeedX;
            ball.y += ballSpeedY;

            if (ball.x - RADIUS < 0) {
                ballSpeedX = -ballSpeedX; // Reflect along normal
                ball.x = RADIUS; // Re-position the ball at the edge
            } else if (ball.x + RADIUS > PANEL_WIDTH) {
                ballSpeedX = -ballSpeedX;
                ball.x = PANEL_WIDTH - RADIUS;
            }
            // May cross both x and y bounds
            if (ball.y - RADIUS < 0) {
                ballSpeedY = -ballSpeedY;
                ball.y = RADIUS;
            } else if (ball.y + RADIUS > PANEL_HEIGHT) {
                ballSpeedY = -ballSpeedY;
                ball.y = PANEL_HEIGHT - RADIUS;
            }

            coloredBallPanel.repaint();

            try {
                Thread.sleep(DELAY);

            } catch (InterruptedException e) {
                System.out.println(String.format("interrupt %s", Thread
                        .currentThread().getName()));
            }
        }
    }
}
