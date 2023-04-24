import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GameView extends JFrame implements KeyListener {
    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 800;
    Game game;

    public GameView(Game g){
        game = g;
    }

    public void paint(){
        return;
    }
}
