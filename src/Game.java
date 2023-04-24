

public class Game{
    private boolean isGameOver;
    private Snake snake;
    private Apple apple;
    private Board board;

    private GameView window;

    public Game(){
        isGameOver = false;
        snake = new Snake(5 ,2, 2);
        apple = new Apple(5,5);
        board = new Board();
        window = new GameView(this);
    }

    public void runGame(){
        return;
    }
}
