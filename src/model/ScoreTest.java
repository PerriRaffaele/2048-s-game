package model;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ScoreTest.
 *
 * @author  perrir@usi.ch, caglif@usi.ch
 * @version (a version number or a date)
 */
public class ScoreTest
{
    private Grid grid;
    private Score score;
    /**
     * Default constructor for test class ScoreTest
     */
    public ScoreTest()
    {
        grid = new Grid();
        score = new Score(grid);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() throws Exception 
    {
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
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @Test
    public void testGetScore()
    {
        score.getScore();
        assertEquals("90",score.getScore());
    }
}
