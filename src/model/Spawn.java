package model;

import java.util.ArrayList;
import java.util.Random;


/**
 * This class create the random numbers that must spawn in the grid during the game.
 *
 * @author perrir@usi.ch, caglif@usi.ch
 * @version (05.05.2022)
 */
public class Spawn
{
    private Random rand;
    private Grid grid;
    
    /**
     * Constructor for objects of class Spawn.
     * @param grid for having a spawning place
     */
    public Spawn(Grid grid)
    {
        this.grid = grid;
        rand = new Random();
    }
    
    /**
     * This method generates the number to create between 2 and 4, in a random position.
     */
    public void spawn() {
        ArrayList<Integer> xs = new ArrayList<Integer>();
        ArrayList<Integer> ys = new ArrayList<Integer>();
        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid()[i].length; j++) {
                if (grid.getGrid()[i][j] == 0) {
                    xs.add(j);
                    ys.add(i);
                }
            }
        }
        
        int rdn = rand.nextInt( xs.size());
        int row = ys.get(rdn);
        int col = xs.get(rdn);
        grid.getGrid()[row][col] = rand.nextInt(100) < 90 ? 2 : 4;
    }
    
}

