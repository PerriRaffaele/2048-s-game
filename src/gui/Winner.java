package gui;

/**
 * The interface if you win the game.
 *
 * @author perrir@usi.ch, caglif@usi.ch
 * @version (a version number or a date)
 */
public class Winner extends GameOver
{
    /**
     * Constructor for the winner JFrame.
     */
    public Winner()
    {
        super();
        
        playerName.setText("Compliments new Highest Score ");
        playerName.setBounds(10, 100, 600, 50);
    }

    @Override
    public String getImageName() {
        return "../images/Winner.jpeg";
    }
}
