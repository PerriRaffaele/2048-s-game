package gui;


import javax.swing.JFrame;
 
/**
 * Write a description of class JFRAME here.
 * 
 * @author perrir@usi.ch, caglif@usi.ch
 * @version (a version number or a date)
 */
public abstract class LayoutFrame extends JFrame
{
    /**
     * Constructor for objects of class JFRAME.
     */
    public LayoutFrame()
    {
        super();
        this.setTitle("2048's game"); // sets title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit the application
        this.setSize(650,650);
        this.setResizable(false); // make the window resizable
        this.setLocationRelativeTo(null); 
    }
}
