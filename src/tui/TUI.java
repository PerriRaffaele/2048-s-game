package tui;

import model.Game;
import model.Grid;
import model.Motion;
import model.Spawn;

import java.util.Scanner;

/**
 * Write a description of class TUI here.
 *
 * @author perrir@usi.ch, caglif@usi.ch
 * @version (05.11.2022)
 */
public class TUI 
{
    // instance variables - replace the example below with your own
    private Grid grid;
    private Spawn sp;
    private Motion mt;
    private Boolean running;
    private Game game;


    /**
     * Constructor for objects of class TUI.
     */
    public TUI()
    {
        grid = new Grid();
        sp = new Spawn(grid);
        game = new Game(grid);
        mt = new Motion(grid,game);
        this.running = true;
    }
    
    /**
     * Method that run the game.
     */
    public void run() 
    {
        enterPlayer();
        System.out.println("");
        sp.spawn();
        sp.spawn();
        print();
        motion();
        youWon();
    }

    /**
     * Checks the command given and executes it.
     */
    public void motion()
    {
        while (this.running) {
            System.out.println("");
            System.out.println("What move would you like to make? ");
            Scanner scanner = new Scanner(System.in);
            String word = scanner.next();
            word = word.toLowerCase();
            if ("right".equalsIgnoreCase(word)) {
                mt.rightMove();
            }
            if ("left".equalsIgnoreCase(word)) {
                mt.leftMove();
            }          
            if ("up".equalsIgnoreCase(word)) {
                mt.upMove();
            }           
            if ("down".equalsIgnoreCase(word)) {
                mt.downMove();
            }            
            if ("quit".equalsIgnoreCase(word) || game.youWon() || game.isGameOver()) {
                System.out.println("");
                System.out.println("See you next game ;)");
                this.running = false;
                break;
            }
            sp.spawn();
            System.out.print('\u000C');
            print();
            scanner.close();
            game.youWon();
            game.isGameOver();
        }  
    }

    /**
     * This method prints the grid after making it.
     */
    public void print() { 
        for (int row = 0 ; row < grid.getGrid().length; row++) {
            System.out.println();
            for (int col = 0; col < grid.getGrid().length; col++) {
                System.out.print("(");
                System.out.print(grid.getGrid()[row][col]);
                System.out.print(")");
            }
        }
    }
    
    /**
     * This method let you enter the player name before the game starts.
     */
    public void enterPlayer() 
    {
        System.out.println("Please enter player name: ");
        Scanner scanner = new Scanner(System.in);
        String sc = scanner.next();
        System.out.print("Welcome " + sc);
    }
    
    /**
     * Print if you won the game.
     */
    public void youWon() 
    {
        if (game.youWon()) {
            System.out.println();
            System.out.println("Compliments you won :) ");
        }
    }
    
}
