package model;

/**
 * This class create the grid for playing, that is actually a 2D array.
 *
 * @author perrir@usi.ch, caglif@usi.ch
 * @version (05.05.2022)
 */
public class Grid
{
    private final int[][] grid;

    /**
     * Constructor for objects of class Grid.
     */
    public Grid()
    {
        grid = new int[4][4];
    }

    /**
     * Getter method.
     * @return the 2D array grid.
     */
    public int[][] getGrid() {
        return grid;
    }
}
