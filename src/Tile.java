// The tile class keeps track of each tile or grid spot within the board holding the actual data of location and
// And the value or visual stored there
public class Tile {
    // Declares all instance variables
    // Tracks the visual of the tile
    private String visual;
    // Tracks tiles location
    private int x;
    private int y;

    public Tile(String visual, int x, int y){
        // Initializes all instance variables
        this.visual = visual;
        this.x = x;
        this.y = y;
    }

    // Getters and setters
    public String getVisual(){
        return visual;
    }
    public void setVisual(String x){
        visual = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
