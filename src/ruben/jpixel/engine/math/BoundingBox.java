package ruben.jpixel.engine.math;

import org.joml.Intersectionf;
import org.joml.Rectanglef;

import java.awt.*;

public class BoundingBox {

    private Rectangle collisionBox;

    public BoundingBox(int x, int y, int width, int height){
        collisionBox = new Rectangle(x, y,width, height);
    }

    public Rectangle getCollisionBox() {
        return collisionBox;
    }

    public void update(Vec2 position, int width, int height) {
        collisionBox.x = position.x;
        collisionBox.y = position.y;
        collisionBox.width = width;
        collisionBox.height = height;
    }

    public boolean collided(Rectangle a) {
        return (Math.abs(collisionBox.x - a.x) * 2 < (collisionBox.width + a.width)) &&
                (Math.abs(collisionBox.y - a.y) * 2 < (collisionBox.height + a.height));
    }
}
