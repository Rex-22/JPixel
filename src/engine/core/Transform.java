package engine.core;

public class Transform {

    private int x, y, size;

    public Transform(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public Transform(int x, int y){
        this(x, y, 50);
    }

    public Transform(int size){
        this(0,0, size);
    }

    public Transform(){
        this(0,0);
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }
}
