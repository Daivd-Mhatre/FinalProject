public class Board {
    private Tile[][] b;
    public Board(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if ((i + j) % 2 == 0){
                    b[i][j] = new Tile("dark");
                }
                else{
                    b[i][j] = new Tile("light");
                }
            }
        }
    }

    public String getSpot(int x, int y){
        return b[x][y].getVisual();
    }
}
