package model;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * The test class MotionTest.
 *
 * @author  perrir@usi.ch, caglif@usi.ch
 * @version (a version number or a date)
 */
public class motionTest {

    private Grid grid = new Grid();
    private Motion motion;

    @Before
    public void setUp() throws Exception {
        grid.getGrid()[0][0] = 64;
        grid.getGrid()[0][1] = 4;
        grid.getGrid()[0][3] = 4;

        grid.getGrid()[1][0] = 16;

        grid.getGrid()[2][0] = 2;

        Spawn spawn = new Spawn(grid);
        Game game = new Game(grid);
        motion = new Motion(grid, game);
    }

    @Test
    public void testMoveLeft() {
        motion.leftMove();
        int[][] expectedGrid = new int[4][4];
        expectedGrid[0][0] = 64;
        expectedGrid[0][1] = 8;
        expectedGrid[1][0] = 16;
        expectedGrid[2][0] = 2;

        assertTrue(Arrays.deepEquals(grid.getGrid(), expectedGrid));
    }

    @Test
    public void testMoveRight() {
        motion.rightMove();
        int[][] expectedGrid = new int[4][4];
        expectedGrid[0][2] = 64;
        expectedGrid[0][3] = 8;
        expectedGrid[1][3] = 16;
        expectedGrid[2][3] = 2;

        assertTrue(Arrays.deepEquals(grid.getGrid(), expectedGrid));
    }

    @Test
    public void testMoveDown() {
        motion.downMove();
        int[][] expectedGrid = new int[4][4];
        expectedGrid[1][0] = 64;
        expectedGrid[2][0] = 16;
        expectedGrid[3][0] = 2;
        expectedGrid[3][1] = 4;
        expectedGrid[3][3] = 4;

        assertTrue(Arrays.deepEquals(grid.getGrid(), expectedGrid));
    }

    // [[64, 4, 0, 4],
    // [16, 0, 0, 0],
    // [2, 0, 0, 0],
    // [0, 0, 0, 0]]
    @Test
    public void testMoveUp() {
        motion.upMove();
        int[][] expectedGrid = new int[4][4];
        expectedGrid[0][0] = 64;
        expectedGrid[0][1] = 4;
        expectedGrid[0][3] = 4;

        expectedGrid[1][0] = 16;

        expectedGrid[2][0] = 2;

        assertTrue(Arrays.deepEquals(grid.getGrid(), expectedGrid));
    }

}
