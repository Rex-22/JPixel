package co.za.rex22.jpixel.engine.graphics;

import co.za.rex22.jpixel.engine.math.Vec2;

public class Camera {

    private Vec2 position;

    public Camera(Vec2 position) {
        this.position = position;
    }

    public Camera(int x, int y){
        this.position = new Vec2(x, y);
    }

    public Vec2 getPosition() {
        return position;
    }

    public int getX(){
        return this.position.x;
    }

    public int getY(){
        return this.position.y;
    }

    public void setPosition(Vec2 position){
       this.position.set(position);
    }

    public void setPosition(int x, int y){
        this.position.set(x, y);
    }
}
