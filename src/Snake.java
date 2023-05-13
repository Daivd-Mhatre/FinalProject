import java.util.ArrayList;
// The snake class keeps track of things like watch direction and where the front is in charge of
// Determine when the game has ended or when the snake is moving
public class Snake {
    // Declares all instance variables
    // Tracks the location of the front
    private int xHeadloc;
    private int yHeadloc;
    // Tracks the length of the snake in terms of pixels
    private int length;
    // X an Y velo determine which direction the snake moves
    private int xVelo;
    private int yVelo;
    // Keeps track of each tile which makes us the snake
    private ArrayList<Tile> snake = new ArrayList<Tile>();
    // Instance variable of the game to allow us to use the methods
    private Game g;

    public Snake(int xh, int yh, int length, Board b){
        // Initializes all instance variables
        xHeadloc = xh;
        yHeadloc = yh;
        this.length = length;
        xVelo = 1;
        yVelo = 0;
        snake.add(b.getSpot(3,8));
        snake.add(b.getSpot(2,8));
    }


    // Turn snake updates the direction
    public void turnSnake(int x, int y){
        // The direction can be fully turned around like 180
        if (xVelo == 0 && x != 0 || xVelo != 0 && x == 0){
            // Updates directions
            xVelo = x;
            yVelo = y;
        }
    }

    // Move snake updates the location deleting the last item and adding one to the front
    public void moveSnake(Tile[][] board, Game g){
        // First update the visual of the last piece of the snake and then remove it
        snake.get(length - 1).setVisual("BoardPiece");
        snake.remove(length - 1);
        // If the place where the snake is trying to move is another part of the snake the game ends
        if (board[xHeadloc + xVelo][yHeadloc + yVelo].getVisual().equals("snakeBody")){
            g.setisGameOver(true);
        }
        // Sets the location in front of the snake and in the direction to a piece of the snake
        board[xHeadloc + xVelo][yHeadloc + yVelo].setVisual("snakeBody");
        // Adds that tile to the snake arraylist
        snake.add(0, board[xHeadloc + xVelo][yHeadloc + yVelo]);
        // Updates the location of the front of the snake
        xHeadloc += xVelo;
        yHeadloc += yVelo;
    }

    // Grow snake adds a tile to the end of the snake
    public void GrowSnake(Tile[][] board){
        // Puts a snake tile right at the end of the snake in the opposite direction of the snake movement
        board[snake.get(length - 1).getY() + -1 * yVelo][snake.get(length - 1).getX() + -1 * xVelo].setVisual("snakeBody");
        // Then adds that piece to the end of the arraylist
        snake.add(board[snake.get(length - 1).getY() + -1 * yVelo][snake.get(length - 1).getX() + -1 * xVelo]);
        // Adds one to length
        length += 1;
    }

    // Checks if the snake is touching the wall
    public boolean isTouchingWall(){
        // Checks each direction and if they are moving in the direction of the wall while at it
        // Then it returns true to set isGameOver to true
        if (xHeadloc == 0 && xVelo == -1){
            return true;
        }
        if (xHeadloc == 15 && xVelo == 1){
            return true;
        }
        if (yHeadloc == 0 && yVelo == 1){
            return true;
        }
        if (yHeadloc == 15 && xVelo == -1){
            return true;
        }
        // Else return false
        return false;
    }

    // Getters and setters
    public int getxHeadloc() {
        return xHeadloc;
    }

    public int getyHeadloc() {
        return yHeadloc;
    }

    public int getLength() {
        return length;
    }
}

