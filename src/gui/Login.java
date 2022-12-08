package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * The frame where the player inputs his name.
 *
 * @author perrir@usi.ch, caglif@usi.ch
 * @version (a version number or a date)
 */
public class Login extends LayoutFrame implements ActionListener {
    private JTextField field;
    private JButton button;
    private static String playerName;   // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    /**
     * Constructor for class Login.
     */
    public Login()
    {
        super();

        JLabel welcomeLabel = new JLabel("Welcome to 2048's Game");
        welcomeLabel.setBounds(120,40,600,25);
        setLabel(welcomeLabel);
        welcomeLabel.setFont(new Font("Anton", Font.BOLD, 30));
        

        JLabel enterLabel = new JLabel("Please enter your name:");
        enterLabel.setBounds(105,200,500,25);
        setLabel(enterLabel);

        JLabel label = new JLabel("Player :");
        label.setBounds(200,260,80,25);
        setLabel(label);

        
        field = new JTextField();
        field.setBounds(270, 260, 165, 30);
        this.add(field);
        
        

        button = new JButton();
        button.setText("Play");
        button.setBounds(260,450,100,50);
        setButton(button);
        
        
        ImageIcon icon = new ImageIcon("../images/login.jpg");
        JLabel imageLabel = new JLabel(icon, JLabel.CENTER);
        this.add(imageLabel);        

        this.setVisible(true);
    }

    /**
     * This method set the features for the labels.
     * @param label is the label used on the frame.
     */
    public void setLabel(JLabel label) {
        label.setFont(new Font("Anton", Font.PLAIN, 18));
        label.setForeground(new Color(0,0,0));
        this.add(label);
    }
    
    /**
     * This method set the features for the button.
     * @param button is the button used on the frame.
     */
    public void setButton(JButton button) {
        button.setForeground(new Color(0, 0, 0));
        button.setFont(new Font("Arial", Font.BOLD, 25));   
        button.setBackground(new Color(255, 255, 255));
        button.addActionListener(this);
        this.add(button);
    }

    /**
     * This method it's to make the button perform an action.
     */

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == button) {
            this.dispose();
            new GameBoard();
            playerName = field.getText();
        }
    }

    @Override 
    public String toString() {
        return playerName;
    }

}
