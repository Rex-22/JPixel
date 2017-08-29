package engine.core;

public class Camera {

    private int x;
    private int y;

    public Camera(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int GetX() {
        return x;
    }

    public int GetY() {
        return y;
    }

    public void SetPostition(int x, int y){
        this.x = x;
        this.y = y;
    }

}
