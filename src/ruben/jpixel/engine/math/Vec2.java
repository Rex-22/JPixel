package ruben.jpixel.engine.math;

public class Vec2 {

    public int x, y;

    public Vec2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vec2(){
        this(0, 0);
    }

    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void set(Vec2 location) {
        this.x = location.x;
        this.y = location.y;
    }

    public Vec2 addLocal(int amt){
        this.x += amt;
        this.y += amt;
        return this;
    }

    public Vec2 add(int amt){
        Vec2 other = new Vec2(x, y);

        other.x += amt;
        other.y += amt;

        return other;
    }

    public Vec2 addLocal(Vec2 r){
        this.x += r.x;
        this.y += r.y;
        return this;
    }

    public Vec2 add(Vec2 r){
        Vec2 other = new Vec2(x, y);

        other.x += r.x;
        other.y += r.y;

        return other;
    }

    public Vec2 subLocal(int amt){
        this.x -= amt;
        this.y -= amt;
        return this;
    }

    public Vec2 sub(int amt){
        Vec2 other = new Vec2(x, y);

        other.x -= amt;
        other.y -= amt;

        return other;
    }

    public Vec2 subLocal(Vec2 r){
        this.x -= r.x;
        this.y -= r.y;
        return this;
    }

    public Vec2 sub(Vec2 r){
        Vec2 other = new Vec2(x, y);

        other.x -= r.x;
        other.y -= r.y;

        return other;
    }

    public Vec2 mulLocal(int amt) {
        this.x *= amt;
        this.y *= amt;
        return this;
    }

    public Vec2 divLocal(int amt) {
        this.x /= amt;
        this.y /= amt;
        return this;
    }

    public Vec2 div(int amt) {
        Vec2 other = new Vec2(x, y);

        other.x /= amt;
        other.y /= amt;

        return other;
    }
}
