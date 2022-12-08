package model;

/**
 * Write a description of class GameOver here.
 *
 * @author perrir@usi.ch, caglif@usi.ch
 * @version (a version number or a date)
 */
public class Game
{
    private Grid grid;

    /**
     * Constructor for objects of class GameOver.
     * @param grid to create a Grid object 
     */
    public Game(Grid grid)
    {
        this.grid = grid;
    }

    /**
     * This method check if you can move left in the grid.
     * @return true if you can move.
     */
    public boolean canMoveLeft() {
        for (int row = 0; row < grid.getGrid().length; row++) {
            for (int col = 0; col < grid.getGrid().length - 1; col++) {
                if (grid.getGrid()[row][col] == 0 && grid.getGrid()[row][col + 1] != 0 || grid.getGrid()[row][col] == grid.getGrid()[row][col + 1])  {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method check if you can move right in the grid.
     * @return true if you can move.
     */
    public boolean canMoveRight() {
        for (int row = 0; row < grid.getGrid().length; row++) {
            for (int col = 0; col < grid.getGrid().length - 1; col++) {
                if (grid.getGrid()[row][col] != 0 && grid.getGrid()[row][col + 1] == 0 || grid.getGrid()[row][col] == grid.getGrid()[row][col + 1])  {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method check if you can move up in the grid.
     * @return true if you can move.
     */
    public boolean canMoveUp() {
        for (int row = 0; row < grid.getGrid().length - 1; row++) {
            for (int col = 0; col < grid.getGrid().length; col++) {
                if (grid.getGrid()[row][col] == 0 && grid.getGrid()[row + 1][col] != 0 || grid.getGrid()[row][col] == grid.getGrid()[row + 1][col]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method check if you can move down in the grid.
     * @return true if you can move
     */
    public boolean canMoveDown() {
        for (int row = 0; row < grid.getGrid().length - 1; row++) {
            for (int col = 0; col < grid.getGrid().length; col++) {
                if (grid.getGrid()[row][col] != 0 && grid.getGrid()[row + 1][col] == 0 || grid.getGrid()[row][col] == grid.getGrid()[row + 1][col]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if you won.
     * @return it returns a Boolean if you won
     */
    public boolean youWon() 
    {
        for (int x = 0; x < grid.getGrid().length; x++) {
            for (int y = 0; y  < grid.getGrid().length; y++) {
                if (grid.getGrid()[x][y] == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if you lost.
     * @return it return a Boolean if you lost 
     */
    public boolean isGameOver() {
        return !canMoveRight() && !canMoveLeft() && !canMoveUp() && !canMoveDown();
    } 
}
