// The apple class keeps track of all the apple data like location and if it hits the snake
public class Apple {
    // Declares all instance variables
    // Tracks apples location
    private int xloc;
    private int yloc;
    // Instance variable of the board to allow us to use the methods
    private Board b;

    public Apple(int x, int y, Board b){
        // Initializes all instance variables
        xloc = x;
        yloc = y;
        this.b = b;
    }

    // Checks if the snake is touching the apple then moves it to a new location
    public boolean isTouchingSnake(Snake s, Tile[][] board){
        if (xloc == s.getxHeadloc() && yloc == s.getyHeadloc()){
            // Moves the apple to a new location by randomizing the x and y value
            xloc = (int)(Math.random() * 15);
            yloc = (int)(Math.random() * 15);
            // Makes sure it can't move to place where the snake currently is
            while(board[xloc][yloc].getVisual().equals("snakeBody") || board[xloc][yloc].getVisual().equals("snakeHead")){
                xloc = (int)(Math.random() * 15);
                yloc = (int)(Math.random() * 15);
            }
            // Sets that location to an apple and returns true
            board[xloc][yloc].setVisual("apple");
            return true;
        }
        // Else returns false
        return false;
    }
}
