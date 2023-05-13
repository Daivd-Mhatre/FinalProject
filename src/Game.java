
// David Mhatre
// Snake Game 5/12/23

// Game class is the overarching class that controls the game and all of it's variables the engine of the train
public class Game{
    // declares all instance variables
    // Tracks when the game is over
    private boolean isGameOver;
    // Allows us to access the snake, apple, board, and front end variables and methods
    private Snake snake;
    private Apple apple;
    private Board board;

    private GameView window;

    public Game(){
        // Initializes all instance variables
        isGameOver = false;
        board = new Board();
        snake = new Snake( 3, 8, 2, board);
        apple = new Apple(8,8, board);
        window = new GameView(this);
    }

    public void runGame(){
        // Waits to allow the user to get to the window
        wait(2000);
        // Until the game is over just keep running the game loop
        while (!isGameOver){
            // Repaints the window
            window.repaint();
            // Calls the move method
            snake.moveSnake(board.getBoard(), this);
            // If the snake is touching the apple then grow or if it's touching the wall end game
            if (apple.isTouchingSnake(snake, board.getBoard())) {
                snake.GrowSnake(board.getBoard());
            }
            if (snake.isTouchingWall()) {
                isGameOver = true;
            }
            // Wait a little to allow the user to repsond
            wait(200);
        }
    }

    public Tile[][] getBoard(){
        return board.getBoard();
    }

    public Snake getSnake(){
        return snake;
    }

    public static void main(String[] args){
        // Creates a new instance of the game then runs it
        Game game = new Game();
        game.runGame();
    }

    // Wait method to allow the user to respond
    public static void wait(int ms)
    {
        // Use the sleep method but to avoid error catch the InterruptedException
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }


    public void setisGameOver(Boolean b){
        isGameOver = b;
    }

}
