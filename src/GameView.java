import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

// The Front end or game view class extends JFrame and implements Key listeners to take in wasd from the use
// It houses the apints method and makes the screen run smoothly
public class GameView extends JFrame implements KeyListener {
    // Declares all instance variables
    // Declares screen size
    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 800;
    // Instance variable of the game to allow us to use the methods
    Game game;
    // Declares our images to display on the front end
    private Image apple;
    private Image snakeBody;

    public GameView(Game g){
        // Initializes all instance variables
        game = g;
        apple = new ImageIcon("Resources/Apple.png").getImage();
        snakeBody = new ImageIcon("Resources/snakeBody.png").getImage();
        // Sets all variables for the window and also adds keylistener
        this.addKeyListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Snake Game");
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setVisible(true);
    }

    // Paint methods draws the front end
    public void paint(Graphics g){
        // Gets the board from game
        Tile[][] board = game.getBoard();
        // Loops through each tile on the board display it on the front end
        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 15; j++){
                // If the tile is even then sets it to a light green if else sets it to a dark green
                // To create a checker board type grid
                if ((i + j) % 2 == 0){
                    g.setColor(new Color(116, 194, 132, 255));
                }
                else{
                    g.setColor(new Color(2, 63, 18, 255));
                }
                // Fills that rect with the color set
                g.fillRect(i * 67,j * 52 + 22, 67,52);

                // Displays the image if there is one on top so and apple or snake
                if (board[i][j].getVisual().equals("apple")){
                    // Draws the image at the specific point
                    g.drawImage(apple, i * 67,j * 52 + 22, 67,52,this);
                }

                if (board[i][j].getVisual().equals("snakeBody")){
                    g.drawImage(snakeBody, i * 67,j * 52 + 22, 67,52,this);
                }
            }
        }
        // Sets the color back to black and prints out the length on top
        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(44f));
        g.drawString(String.valueOf(game.getSnake().getLength()), 100,100);
    }

    public void keyTyped(KeyEvent e)                // #5 Required for KeyListener
    {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyReleased(KeyEvent e)             // #6 Required for KeyListener
    {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyPressed(KeyEvent e)              // #7 Required for KeyListener
    {
        // The keyCode lets you know which key was pressed
        int keyCode = e.getKeyCode();

        // Depedning on what keycode was pressed changes the direction of the snake
        if(keyCode == KeyEvent.VK_A)
        {
            game.getSnake().turnSnake(-1,0);
        }
        else if(keyCode == KeyEvent.VK_D)
        {
            game.getSnake().turnSnake(1,0);
        }
        else if(keyCode == KeyEvent.VK_W)
        {
            game.getSnake().turnSnake(0,-1);
        }
        else if(keyCode == KeyEvent.VK_S)
        {
            game.getSnake().turnSnake(0,1);
        }
    }

}
