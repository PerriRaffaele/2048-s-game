package gui;

import javax.swing.JFrame;


/**
 * The grid where you play the actual game.
 *
 * @author perrir@usi.ch, caglif@usi.ch
 * @version (a version number or a date)
 */
public class GameBoard extends JFrame
{
    /**
     * Constructor for the GameBoard JFrame.
     */
    public GameBoard()
    {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit the application
        this.setTitle("2048's game"); // sets title
        this.setResizable(true); // make the window resizable

        this.setSize(800,800);

        BoardPanel panel = new BoardPanel();
        this.setContentPane(panel);

        


        this.setLocationRelativeTo(null); 
        this.setVisible(true);    
    }    
}
