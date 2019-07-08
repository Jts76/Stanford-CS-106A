/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 *
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Breakout Game
 *
 * @author Jonathan T Smith
 * @version 1.0
 */
public class Breakout extends GraphicsProgram {

    /*
     * Instance Variables
     ********************************/
    private GRect paddle;
    private GOval ball;
    private int lives = NTURNS;
    private int numBricks = NBRICK_ROWS * NBRICKS_PER_ROW;
    // Pause in milliseconds
    private int ps = 10;
    // Velocity of the ball
    private double vx = 3;
    private RandomGenerator rgen = RandomGenerator.getInstance();

    /* Labels **********************************************************************************/

    private GLabel numLives = new GLabel("Lives: " + lives);
    private GLabel num_Bricks = new GLabel("Bricks Left: " + numBricks);


    public void init() {
        addMouseListeners();
    }

    public void mouseMoved(MouseEvent e) {
        double px = paddle.getX();
        paddle.move(e.getX() - px, 0);
    }

    /* Method: run() *************************************************************/

    /**
     * Runs the Breakout program.
     */
    public void run() {
        setup();
        waitForClick();
        play();
    }

    /**
     * Starts the game!
     */
    public void play() {
        double dx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5)) {
            dx = changeDirection(dx);
        }
        double dy = vx;
        numLives.setLabel("Lives: " + (lives - 1));
        while (numBricks > 0 && lives > 0) {
            ball.move(dx, dy);
            println(ball.getX() + ", " + ball.getY());
            GObject collider = getCollidingObject();
            println(collider);
            pause(ps);
            if (ball.getX() + BALL_RADIUS * 2 >= APPLICATION_WIDTH - 1) {
                dx = changeDirection(dx);
                bounceClip();
            } else if (ball.getY() + BALL_RADIUS * 2 >= APPLICATION_HEIGHT) {
                loseLife();
            } else if (ball.getX() <= 0) {
                dx = changeDirection(dx);
                bounceClip();
            } else if (ball.getY() <= 0) {
                dy = changeDirection(dy);
                bounceClip();
            }
            if (collider == paddle) {
                double pw = paddle.getWidth() / 4;
                double px = paddle.getX();
                double py = paddle.getY();
                double bc = ball.getX() + BALL_RADIUS;
                double by = ball.getY() + BALL_RADIUS * 2;

                if (by > py) {
                    if (bc < px + pw) {
                        dx = changeDirection(dx);
                        bounceClip();

                    } else if (bc > (px + PADDLE_WIDTH) - pw) {
                        dx = changeDirection(dx);
                        bounceClip();

                    }
                    dy = changeDirection(dy);

                    if (dx < 0) {
                        dx = rgen.nextDouble(1.0, 3.0);
                        dx = -dx;
                        bounceClip();
                    } else {
                        dx = rgen.nextDouble(1.0, 3.0);
                        bounceClip();
                    }
                }

            } else if (collider == num_Bricks || collider == numLives) {
                collider = null;
            } else if (collider != null) {
                remove(collider);
                numBricks -= 1;
                num_Bricks.setLabel("Bricks Left: " + numBricks);
                brickPopClip();
                if (numBricks % 20 == 0) {
                    ps -= 1;
                }
                dy = changeDirection(dy);
            }
        }
        gameOver();
    }


    /**
     * Sets up the game!
     */
    private void setup() {
        //setBackground(Color.PINK);
        drawBricks();
        paddle = drawPaddle();
        paddle.setFillColor(Color.GRAY);
        add(paddle);
        drawBall();
        add(num_Bricks, 0, num_Bricks.getHeight());
        add(numLives, getWidth() - (numLives.getWidth() + BRICK_SEP), numLives.getHeight());

    }

    private void drawBall() {
        int cx = getWidth() / 2 - BALL_RADIUS / 2;
        int cy = getHeight() / 2 - BALL_RADIUS / 2;
        ball = new GOval(cx, cy, BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setFilled(true);
        ball.setFillColor(Color.MAGENTA);
        add(ball);
    }

    private GRect drawPaddle() {
        int cx = (getWidth() / 2) - (PADDLE_WIDTH / 2);
        int cy = getHeight() - PADDLE_Y_OFFSET;
        GRect paddle = new GRect(cx, cy, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        return paddle;
    }

    private void drawBricks() {
        for (int i = 0; i < NBRICK_ROWS; i++) {
            for (int j = 0; j < NBRICKS_PER_ROW; j++) {
                int x = j * (BRICK_WIDTH + BRICK_SEP);
                int y = i * (BRICK_HEIGHT + BRICK_SEP);
                GRect bricks = new GRect(x + BRICK_SEP, y + BRICK_Y_OFFSET, BRICK_WIDTH, BRICK_HEIGHT);
                if (NBRICK_ROWS / 5 != 0) {
                    int colorPicker = i / (NBRICK_ROWS / 5);
                    switch (colorPicker) {
                        case 0:
                            setColor(bricks, Color.RED);
                            break;
                        case 1:
                            setColor(bricks, Color.ORANGE);

                            break;
                        case 2:
                            setColor(bricks, Color.YELLOW);

                            break;
                        case 3:
                            setColor(bricks, Color.GREEN);

                            break;
                        case 4:
                            setColor(bricks, Color.CYAN);
                            break;
                        default:
                            setColor(bricks, Color.MAGENTA);
                            break;
                    }
                } else {
                    switch (i) {
                        case 0:
                            setColor(bricks, Color.RED);
                            break;
                        case 1:
                            setColor(bricks, Color.ORANGE);

                            break;
                        case 2:
                            setColor(bricks, Color.YELLOW);

                            break;
                        case 3:
                            setColor(bricks, Color.GREEN);

                            break;
                        case 4:
                            setColor(bricks, Color.CYAN);
                            break;
                        default:
                            setColor(bricks, Color.MAGENTA);
                            break;
                    }
                }
            }
        }

    }

    private void setColor(GRect obj, Color color) {
        obj.setFilled(true);
        obj.setColor(Color.BLACK);
        obj.setFillColor(color);
        add(obj);
    }

    private GObject getCollidingObject() {
        double bx = ball.getX();
        double by = ball.getY();
        int b2r = BALL_RADIUS * 2;
        GObject obj;

        // Ball top left (x, y)
        GObject ballTopLeft = getElementAt(bx, by);

        // Ball top right (x + 2r, y)
        GObject ballTopRight = getElementAt(bx + b2r, by);

        // Ball bottom left (x, y + 2r)
        GObject ballBottomLeft = getElementAt(bx, by + b2r);

        // Ball bottom right (x +2r, y + 2r)
        GObject ballBottomRight = getElementAt(bx + b2r, by + b2r);

        if (ballTopLeft != null) {
            obj = ballTopLeft;
        } else if (ballTopRight != null) {
            obj = ballTopRight;
        } else if (ballBottomLeft != null) {
            obj = ballBottomLeft;
        } else if (ballBottomRight != null) {
            obj = ballBottomRight;
        } else {
            obj = null;
        }
        return obj;
    }

    private double changeDirection(double x) {
        if (x > 0) {
            x = -x;
        } else {
            x = Math.abs(x);
        }
        return x;
    }

    private void loseLife() {
        lives -= 1;
        loseLifeClip();
        numLives.setLabel("Lives: " + lives);
        if (lives <= 0){
            gameOver();
        } else {
            GLabel livesRemaining = new GLabel("You have " + lives + " lives remaining.");
            add(livesRemaining, getWidth() / 2 - livesRemaining.getWidth() / 2, getHeight() / 2 - livesRemaining.getHeight() / 2);
            ball.setLocation(getWidth() / 2 - BALL_RADIUS / 2, getHeight() / 2 - BALL_RADIUS / 2);
            waitForClick();
            remove(livesRemaining);
//            play();
        }
    }

    private void gameOver() {
        if (numBricks > 0) {
            clear();
            GLabel gameOver = new GLabel("Game Over, you lose!");
            add(gameOver, getWidth() / 2 - gameOver.getWidth() / 2, getHeight() / 2 - gameOver.getHeight() / 2);
            gameOverClip();
        } else {
            clear();
            GLabel gameOver = new GLabel("Game Over, You have WON!!");
            add(gameOver, getWidth() / 2 - gameOver.getWidth() / 2, getHeight() / 2 - gameOver.getHeight() / 2);
            winningGameClip();
            pause(2100);
            voiceWinningGameClip();
        }
    }

    private void clear() {
        remove(ball);
        ball = null;
        remove(paddle);
        paddle = null;

    }
    /* SOUND ***************************************************************************/

    private void bounceClip() {
        try {
        AudioInputStream clip = AudioSystem.getAudioInputStream(new File("src/sounds/media.io_zapsplat_sport_ball_netball_single_cheap_bounce_court_002_31147.wav"));
        Clip bounceClip = AudioSystem.getClip();
        bounceClip.open(clip);
        bounceClip.start();
        bounceClip.setFramePosition(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }private void gameOverClip() {
        try {
        AudioInputStream clip = AudioSystem.getAudioInputStream(new File("src/sounds/little_robot_sound_factory_Jingle_Lose_00.wav"));
        Clip gameOverClip = AudioSystem.getClip();
        gameOverClip.open(clip);
        gameOverClip.start();
        gameOverClip.setFramePosition(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }private void loseLifeClip() {
        try {
        AudioInputStream clip = AudioSystem.getAudioInputStream(new File("src/sounds/zapsplat_multimedia_game_retro_musical_descend_fail_lose_life_21483.wav"));
        Clip loseLifeClip = AudioSystem.getClip();
        loseLifeClip.open(clip);
        loseLifeClip.start();
        loseLifeClip.setFramePosition(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }private void winningGameClip() {
        try {
        AudioInputStream clip = AudioSystem.getAudioInputStream(new File("src/sounds/media.io_little_robot_sound_factory_Jingle_Win_00.wav"));
        Clip winningGameClip = AudioSystem.getClip();
        winningGameClip.open(clip);
        winningGameClip.start();
        winningGameClip.setFramePosition(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void voiceWinningGameClip() {
        try {
        AudioInputStream clip = AudioSystem.getAudioInputStream(new File("src/sounds/media.io_zapsplat_multimedia_male_voice_processed_says_you_win_002_21573.wav"));
        Clip voiceWinningGameClip = AudioSystem.getClip();
        voiceWinningGameClip.open(clip);
        voiceWinningGameClip.start();
        voiceWinningGameClip.setFramePosition(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void brickPopClip() {
        try {
        AudioInputStream clip = AudioSystem.getAudioInputStream(new File("src/sounds/zapsplat_multimedia_game_designed_pop_wet_009_26321.wav"));
        Clip brickPopClip = AudioSystem.getClip();
        brickPopClip.open(clip);
        brickPopClip.start();
        brickPopClip.setFramePosition(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /* CONSTANTS ****************************************************/
    /**
     * Width and height of application window in pixels
     */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /**
     * Dimensions of game board (usually the same)
     */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    /**
     * Dimensions of the paddle
     */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /**
     * Offset of the paddle up from the bottom
     */
    private static final int PADDLE_Y_OFFSET = 30;

    /**
     * Number of bricks per row
     */
    private static final int NBRICKS_PER_ROW = 10;

    /**
     * Number of rows of bricks
     */
    private static final int NBRICK_ROWS = 10;

    /**
     * Separation between bricks
     */
    private static final int BRICK_SEP = 4;

    /**
     * Width of a brick
     */
    private static final int BRICK_WIDTH =
            (WIDTH - ((NBRICKS_PER_ROW + 1) * BRICK_SEP)) / NBRICKS_PER_ROW;

    /**
     * sd
     * Height of a brick
     */
    private static final int BRICK_HEIGHT = 8;

    /**
     * Radius of the ball in pixels
     */
    private static final int BALL_RADIUS = 7;

    /**
     * Offset of the top brick row from the top
     */
    private static final int BRICK_Y_OFFSET = 70;

    /**
     * Number of turns
     */
    private static final int NTURNS = 3;

}
