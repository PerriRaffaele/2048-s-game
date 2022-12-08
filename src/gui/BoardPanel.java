package gui;

import model.Game;
import model.Grid;
import model.Motion;
import model.Score;
import model.Spawn;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 * Creates the board for playing.
 *
 * @author perrir@usi.ch, caglif@usi.ch
 * @version (a version number or a date)
 */
public class BoardPanel extends JPanel
{
    private final Color[] table = {
      new Color(0x701710), new Color(0xFFE4C3), new Color(0xfff4d3),
      new Color(0xffdac3), new Color(0xe7b08e), new Color(0xe7bf8e),
      new Color(0xffc4c3), new Color(0xE7948e), new Color(0xbe7e56),
      new Color(0xbe5e56), new Color(0x9c3931), new Color(0x701710)};

    private Grid grid;
    private Spawn sp;
    private Score score;
    private Motion mt;
    private Game game;
    private int space = 10;
    private int leftDistance = 80;
    private int topDistance = 70;
    private int squareSize = 160;
    private State gamestate = State.START;
    
    /**
     * Constructor for objects of class BoardPanel.
     */

    public BoardPanel()
    {
        super();
        grid = new Grid();
        sp = new Spawn(grid);
        game = new Game(grid);
        mt = new Motion(grid,game);
        

        addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent event) {
                    startGame();
                    repaint();
                }
            });

        setFocusable(true);
        requestFocus();

        addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent event) {
                    switch (event.getKeyCode()) {
                        case KeyEvent.VK_LEFT:
                            if (game.canMoveLeft()) {
                                mt.leftMove();
                                sp.spawn();
                            } else if (game.isGameOver()) {
                                gamestate = State.OVER;
                            } else if (game.youWon()) {
                                gamestate = State.WON;
                            }
                            break;
                        case KeyEvent.VK_RIGHT:
                            if (game.canMoveRight()) {
                                mt.rightMove();
                                sp.spawn();
                            } else if (game.isGameOver()) {
                                gamestate = State.OVER;
                            } else if (game.youWon()) {
                                gamestate = State.WON;
                            }
                            break;
                        case KeyEvent.VK_UP:
                            if (game.canMoveUp()) {
                                mt.upMove();
                                sp.spawn();
                            } else if (game.isGameOver()) {
                                gamestate = State.OVER;
                            } else if (game.youWon()) {
                                gamestate = State.WON;
                            }
                            break;
                        case KeyEvent.VK_DOWN:
                            if (game.canMoveDown()) {
                                mt.downMove();
                                sp.spawn();
                            } else if (game.isGameOver()) {
                                gamestate = State.OVER;
                            } else if (game.youWon()) {
                                gamestate = State.WON;
                            }
                            break; 
                            
                        default:
                            break;
                    }

                    repaint();
                }
            });
    }

    @Override
    protected void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g2D = (Graphics2D) gg;

        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawGrid(g2D);
    }

    /**
     * This method starts the game. 
     */
    public void startGame() {
        if (gamestate != State.RUNNING) {
            score = new Score(grid);
            gamestate = State.RUNNING;
            sp.spawn();
            sp.spawn();
        }
    }

    /**
     * This method draw the grid in which play.
     * @param g2D to draw the graphics.
     */
    public void drawGrid(Graphics2D g2D) {
        g2D.setColor(Color.DARK_GRAY);
        g2D.fillRoundRect(80,70,640,640,21,21);
        
        if (gamestate == State.RUNNING) {
            g2D.fillRoundRect(80,10,130,50,15,15);
            g2D.setFont(new Font("Arial", Font.PLAIN, 18));
            g2D.setColor(Color.WHITE);
            g2D.drawString("SCORE: ", 84, 38);
            g2D.drawString(score.getScore(), 160, 38);
            
            for (int i = 0; i < grid.getGrid().length; i++) {
                for (int j = 0; j < grid.getGrid().length; j++) {
                    if (grid.getGrid()[i][j] == 0) {
                        g2D.setColor(Color.gray);
                        g2D.fillRoundRect(space + j * squareSize + leftDistance, space + i * squareSize + topDistance , squareSize - 2 * space, squareSize - 2 * space, 15,15);
                    } else {
                        drawTile(g2D, i, j);
                    }
                }   
            }
        } else if (gamestate == State.WON) {
            new Winner();
            setVisible(false);
            // CLOSE TAB
        } else if (gamestate == State.OVER) {
            new Loser();
            setVisible(false);
            // CLOSE TAB 
        } else {
            g2D.setColor(Color.DARK_GRAY);
            g2D.fillRoundRect(80,70,640,640,21,21);

            g2D.setColor(Color.white);
            g2D.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 180));
            g2D.drawString("2048", 150, 250);

            g2D.setColor(Color.gray);
            g2D.setFont(new Font("SansSerif", Font.BOLD, 40));
            g2D.drawString("CLICK TO START", 210, 470);
            g2D.drawString("use arrows to move tiles", 120, 530);
        }
    }

    /**
     * This method draw the tile used for playing.
     * @param g2D to draw the tiles.
     * @param row for rows.
     * @param col for columns.
     */
    public void drawTile(Graphics2D g2D, int row, int col) {
        int value = grid.getGrid()[row][col];

        g2D.setColor(table[(int) (Math.log(value) / Math.log(2)) + 1]);
        g2D.fillRoundRect(space + col * squareSize + leftDistance, space + row * squareSize + topDistance , squareSize - 2 * space, squareSize - 2 * space, 15,15);
        g2D.setFont(new Font("SansSerif", Font.BOLD, 70));
        String string = String.valueOf(value);

        g2D.setColor(value < 128 ? table[0] : table[1]);

        FontMetrics fm = g2D.getFontMetrics();
        int ascent = fm.getAscent();
        int descent = fm.getDescent();

        int sideX = space + col * squareSize + leftDistance + ((squareSize - 2 * space) - fm.stringWidth(string)) / 2;
        int sideY = space + row * squareSize + topDistance + (ascent + ((squareSize - 2 * space) - (ascent + descent)) / 2);

        g2D.drawString(string, sideX, sideY);
    }
}

