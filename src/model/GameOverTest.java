package model;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * The test class GameOverTest.
 *
 * @author  perrir@usi.ch, caglif@usi.ch
 * @version (a version number or a date)
 */
public class GameOverTest
{
    private Grid grid; 
    private Game game;
    /**
     * Default constructor for test class GameOverTest
     */
    public GameOverTest()
    {
        grid = new Grid();
        game = new Game(grid);
    }

    @Before
    public void setUp() throws Exception {
        grid.getGrid()[0][0] = 64;
        grid.getGrid()[0][1] = 4;
        grid.getGrid()[0][3] = 4;

        grid.getGrid()[1][0] = 16;

        grid.getGrid()[2][0] = 2;

        // [[64, 4, 0, 4],
        // [16, 0, 0, 0],
        // [2, 0, 0, 0],
        // [0, 0, 0, 0]]
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test
    public void testCanMoveLeft()
    {
        game.canMoveLeft();
        assertEquals(true, game.canMoveLeft());
    } 
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test
    public void testCanMoveRight()
    {
        game.canMoveRight();
        assertEquals(true, game.canMoveRight());
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test
    public void testCanMoveUp()
    {
        game.canMoveUp();
        assertEquals(true, game.canMoveUp());
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test
    public void testCanMoveDown()
    {
        game.canMoveDown();
        assertEquals(true, game.canMoveDown());
    }

}
