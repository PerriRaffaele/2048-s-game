package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Write a description of class Winner here.
 *
 * @author perrir@usi.ch, caglif@usi.ch
 * @version (a version number or a date)
 */
public abstract class GameOver extends LayoutFrame implements ActionListener 
{
    protected JLabel playerName;
    protected ImageIcon background;
    protected JLabel backgroundLabel;
    protected JButton quitButton;
    protected JButton button;

    /**
     * Constructor for objects of class Winner.
     */
    public GameOver()
    {
        super();

        playerName = new JLabel();
        playerName.setText("OKOK");   // Different between subclasses 
        playerName.setBounds(0, 0, 0, 0);  // Different between subclasses 
        setLabel(playerName);
        this.add(playerName);

        button = new JButton();
        button.setText("New Game");
        button.setBounds(70, 480, 170, 70);
        setButton(button);

        quitButton = new JButton();
        quitButton.setText("Quit");
        quitButton.setBounds(460, 480, 130, 70);
        setButton(quitButton);

        // The background 
        background = new ImageIcon(getImageName());
        backgroundLabel = new JLabel(background, JLabel.CENTER);
        this.add(backgroundLabel);

        this.setVisible(true);
    }

    /**
     * This method set the features for the labels. 
     * @param label is the label used on the frame.
     */
    public void setLabel(JLabel label) {
        label.setFont(new Font("Anton", Font.PLAIN, 25));
        label.setForeground(new Color(0, 0, 0));
        label.setBackground(new Color(211, 211, 211));
        label.setOpaque(true);
        this.add(label);
    }

    /**
     * This method set the features for the button. 
     * @param button is the button used on the frame.
     */
    public void setButton(JButton button) {
        button.setForeground(new Color(0, 0, 0));
        button.setFont(new Font("Arial", Font.BOLD, 20));
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
            new FrameStart();
        } else if (event.getSource() == quitButton) {
            this.dispose();
        }
    }

    /**
     * This method takes the Name of the image for the subclasses.
     * @return the image.
     */
    public abstract String getImageName();   
}
