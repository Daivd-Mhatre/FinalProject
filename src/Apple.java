public class Apple {
    private int xloc;
    private int yloc;

    public Apple(int x, int y){
        xloc = x;
        yloc =y;
    }

    public boolean isTouchingSnake(){
        return false;
    }
}
