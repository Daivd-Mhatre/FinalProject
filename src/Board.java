// The board class keeps track of the data behind the front keeping track of every tile and giving them there values
public class Board {
    // Creates a board of size 15 sqaure of tiles
    private Tile[][] b = new Tile[15][15];
    public Board(){
        // Loops through the entire board giving each tile a visual
        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 15; j++){
                // Sets the snake and the apple or else it's a board piece
                if ((i == 3 && j == 8) || (i == 2 && j == 8)){
                    b[i][j] = new Tile("snakeBody", j, i);
                }
                else if (i == 8 && j == 8){
                    b[i][j] = new Tile("apple", j, i);
                }
                else{
                    b[i][j] = new Tile("BoardPiece", j, i);
                }
            }
        }
    }

    // Getters and setters
    public Tile getSpot(int x, int y){
        return b[x][y];
    }
    public Tile[][] getBoard(){
        return b;
    }
}
