package model;

/**
 * Write a description of class Score here.
 *
 * @author perrir@usi.ch, caglif@usi.ch
 * @version (a version number or a date)
 */
public class Score
{
    private Grid grid;
    private int score;

    /**
     * Constructor of class Score.
     * @param grid is the grid on which play.
     */
    public Score(Grid grid)
    {
        this.grid = grid;
        score = 0;
    }
    
    /**
     * This method set how the score is counted during a game.
     * @return a string that takes the value of the score.
     */
    public String getScore() {
        score = 0;
        for (int row = 0; row < grid.getGrid().length; row++) {
            for (int col = 0; col < grid.getGrid().length; col++) {
                score += grid.getGrid()[row][col];
            }
        }
        return String.valueOf(score); 
    }     
}
    
    
  
