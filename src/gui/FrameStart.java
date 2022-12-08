package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


/**
 * The starting frame.
 *
 * @author perrir@usi.ch, caglif@usi.ch
 * @version (a version number or a date)
 */
public class FrameStart extends LayoutFrame implements ActionListener
{
    private JButton start;
    private JButton quit;
    
    /**
     * Constructor for the starting JFrame.
     */
    public FrameStart()
    {
        super();
        
        
        start = new JButton();
        start.setText("Start");
        start.setBounds(100, 480, 120, 50);
        setButton(start);
        
        
        quit = new JButton();
        quit.setText("Quit");
        quit.setBounds(500, 480, 100, 50);
        setButton(quit);
        
    
        ImageIcon background = new ImageIcon("../images/starting_frame.png");
        JLabel label = new JLabel(background, JLabel.CENTER);
        this.add(label);
        
        this.setVisible(true);
    } 
    
    
    /**
     * This method set the features for the button.
     * @param button is the button that will get the features.
     */
    public void setButton(JButton button) {
        button.setForeground(new Color(0, 0, 0));
        button.setFont(new Font("Arial", Font.BOLD, 25));   
        button.setBackground(new Color(255, 255, 255));
        button.addActionListener(this);
        this.add(button);
    }

   
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == start) {
            this.dispose();
            new Login();
        } else if (event.getSource() == quit) {
            this.dispose();
        }
    }
}
