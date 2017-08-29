package engine.core;

public class Transform {

    private float x;
    private float y;
    private int size;

    public Transform(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public Transform(int x, int y){
        this(x, y, 50);
    }

    public Transform(int size){
        this(0, 0, size);
    }

    public Transform(){
        this(0,0);
    }

    public void SetPosition(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float GetX() {
        return x;
    }

    public float GetY() {
        return y;
    }

    public int GetSize() {
        return size;
    }

    public void SetSize(int size) {
        this.size = size;
    }
}
