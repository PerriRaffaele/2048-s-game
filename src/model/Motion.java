package model;

/**
 * This class define the commands that can be given to play.
 *
 * @author perrir@usi.ch, caglif@usi.ch
 * @version (05.05.2022)
 */
public class Motion
{
    private Grid grid;
    private Game game;

    /**
     * Constructor for objects of class Motion.
     * @param grid for having a place in which have motions
     * @param sp for having spawned numbers to move
     * @param game to check if you won or lost after every move 
     */
    public Motion(Grid grid, Game game)
    {
        this.grid = grid;
        this.game = game;
    }

    /**
     * This method let you move right in the grid.
     */
    public void rightMove()
    {
        for (int row = 0; row < grid.getGrid().length; row++) {
            // use counter in order to move left one by one the tiles
            int counter = 0;
            for (int col = grid.getGrid().length - 1; col >= 0 ; col--) {
                if (grid.getGrid()[row][col] != 0) {
                    grid.getGrid()[row][grid.getGrid().length - 1 - counter] = grid.getGrid()[row][col];
                    // "empty" the original tile position afetr movement
                    if (grid.getGrid().length - 1 - counter != col) {
                        grid.getGrid()[row][col] = 0;
                    }
                    counter++;
                }
            }
        }
        
        for (int row = 0; row < grid.getGrid().length; row++) {
            for (int col = grid.getGrid().length - 1; col > 0 ; col--) {
                if (grid.getGrid()[row][col] == grid.getGrid()[row][col - 1]) {
                    // add tiles with the same value
                    grid.getGrid()[row][col] += grid.getGrid()[row][col - 1];
                    grid.getGrid()[row][col - 1] = 0;
                }
            }
        }
        
        for (int row = 0; row < grid.getGrid().length; row++) {
            // use counter in order to move left one by one the tiles
            int counter = 0;
            for (int col = grid.getGrid().length - 1; col >= 0 ; col--) {
                if (grid.getGrid()[row][col] != 0) {
                    grid.getGrid()[row][grid.getGrid().length - 1 - counter] = grid.getGrid()[row][col];
                    // "empty" the original tile position afetr movement
                    if (grid.getGrid().length - 1 - counter != col) {
                        grid.getGrid()[row][col] = 0;
                    }
                    counter++;
                }
            }
        }
        
        game.isGameOver();
        game.youWon();
    }

    /**
     * This method let you move left in the grid.
     */
    public void leftMove() {
        for (int row = 0; row < grid.getGrid().length; row++) {
            // use counter in order to move left one by one the tiles
            int counter = 0;
            for (int col = 0; col < grid.getGrid().length; col++) {
                if (grid.getGrid()[row][col] != 0) {
                    grid.getGrid()[row][0 + counter] = grid.getGrid()[row][col];
                    // "empty" the original tile position afetr movement
                    if ( 0 + counter != col) {
                        grid.getGrid()[row][col] = 0;
                    }
                    counter++;
                }
            }
        }
        
        for (int row = 0; row < grid.getGrid().length; row++) {
            for (int col = 0; col < grid.getGrid().length - 1; col++) {
                if (grid.getGrid()[row][col] == grid.getGrid()[row][col + 1]) {
                    // add tiles with the same value
                    grid.getGrid()[row][col] += grid.getGrid()[row][col + 1];
                    grid.getGrid()[row][col + 1] = 0;
                }
            }
        }
        
        // repeat the first loop to move all the tiles to the left, after adding the two tiles
        for (int row = 0; row < grid.getGrid().length; row++) {
            int counter = 0;
            for (int col = 0; col < grid.getGrid().length; col++) {
                if (grid.getGrid()[row][col] != 0) {
                    grid.getGrid()[row][0 + counter] = grid.getGrid()[row][col];
                    // "empty" the original tile position afetr movement
                    if (0 + counter != col) {
                        grid.getGrid()[row][col] = 0;
                    }
                    counter++;
                }
            }
        } 
        game.isGameOver();
        game.youWon();
    }

    /**
     * This method let you move up in the grid.
     */
    public void upMove() {
        for (int col = 0; col < grid.getGrid().length; col++) {
            // use counter in order to move left one by one the tiles
            int counter = 0;
            for (int row = 0; row < grid.getGrid().length; row++) {
                if (grid.getGrid()[row][col] != 0) {
                    grid.getGrid()[0 + counter][col] = grid.getGrid()[row][col];
                    // "empty" the original tile position afetr movement
                    if ( 0 + counter != row) {
                        grid.getGrid()[row][col] = 0;
                    }
                    counter++;
                }
            }
        }
        
        for (int col = 0; col < grid.getGrid().length; col++) {
            for (int row = 0; row < grid.getGrid().length - 1; row++) {
                if (grid.getGrid()[row][col] == grid.getGrid()[row + 1][col]) {
                    // add tiles with the same value
                    grid.getGrid()[row][col] += grid.getGrid()[row + 1][col];
                    grid.getGrid()[row + 1][col] = 0;
                }
            }
        }
        
        // repeat the first loop to move all the tiles to the left, after adding the two tiles
        for (int col = 0; col < grid.getGrid().length; col++) {
            // use counter in order to move left one by one the tiles
            int counter = 0;
            for (int row = 0; row < grid.getGrid().length; row++) {
                if (grid.getGrid()[row][col] != 0) {
                    grid.getGrid()[0 + counter][col] = grid.getGrid()[row][col];
                    // "empty" the original tile position afetr movement
                    if ( 0 + counter != row) {
                        grid.getGrid()[row][col] = 0;
                    }
                    counter++;
                }
            }
        }
        game.isGameOver();
        game.youWon();
    }

    /**
     * This method let you move down in the grid.
     */
    public void downMove() {
        for (int col = 0; col < grid.getGrid().length; col++) {
            // use counter in order to move left one by one the tiles
            int counter = 0;
            for (int row = grid.getGrid().length - 1; row >= 0 ; row--) {
                if (grid.getGrid()[row][col] != 0) {
                    grid.getGrid()[grid.getGrid().length - 1 - counter][col] = grid.getGrid()[row][col];
                    // "empty" the original tile position afetr movement
                    if (grid.getGrid().length - 1 - counter != row) {
                        grid.getGrid()[row][col] = 0;
                    }
                    counter++;
                }
            }
        }
        
        for (int col = 0; col < grid.getGrid().length; col++) {
            for (int row = grid.getGrid().length - 1; row > 0 ; row--) {
                if (grid.getGrid()[row][col] == grid.getGrid()[row - 1][col]) {
                    // add tiles with the same value
                    grid.getGrid()[row][col] += grid.getGrid()[row - 1][col];
                    grid.getGrid()[row - 1][col] = 0;
                }
            }
        }
        
        // repeat the first loop to move all the tiles to the left, after adding the two tiles
        for (int col = 0; col < grid.getGrid().length; col++) {
            // use counter in order to move left one by one the tiles
            int counter = 0;
            for (int row = grid.getGrid().length - 1; row >= 0 ; row--) {
                if (grid.getGrid()[row][col] != 0) {
                    grid.getGrid()[grid.getGrid().length - 1 - counter][col] = grid.getGrid()[row][col];
                    // "empty" the original tile position afetr movement
                    if (grid.getGrid().length - 1 - counter != row) {
                        grid.getGrid()[row][col] = 0;
                    }
                    counter++;
                }
            }
        }
        game.isGameOver();
        game.youWon();
    }
}
