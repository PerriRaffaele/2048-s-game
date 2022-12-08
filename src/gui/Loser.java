package gui;

/**
 * The interface if you lose the game.
 *
 * @author perrir@usi.ch, caglif@usi.ch
 * @version (a version number or a date)
 */
public class Loser extends GameOver
{
    /**
     * Constructor for the loser JFrame.
     */
    public Loser()
    {
        super();
        
        playerName.setText("You could have done better :( ");
        playerName.setBounds(10, 10, 600, 50 );
    }
    
    @Override
    public String getImageName() {
        return "../images/Loser.jpg";
    }
}
