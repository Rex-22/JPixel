package ruben.jpixel.engine.tile;

import org.joml.AABBf;
import org.joml.Rectanglef;
import ruben.jpixel.engine.core.IGameObject;
import ruben.jpixel.engine.graphics.Bitmap;
import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.graphics.Sprite;
import ruben.jpixel.engine.level.Level;
import ruben.jpixel.engine.math.Vec2;

import java.awt.*;

public class Tile implements IGameObject {

    /** This is the tile size for the game, it is not meant to change*/
    public static final int SIZE = 16;

    private TilePosition position;
    private Sprite sprite;
    private Level level;

    private Rectanglef boundingBox;
    private boolean solid = false;
    private String name;

    public Tile(TilePosition position, Sprite sprite, String name) {
        this.position = position;
        this.sprite = sprite;
        this.name = name;
        this.boundingBox = new Rectanglef(
                position.getPosition().x,position.getPosition().y,
                sprite.getWidth(), sprite.getHeight());
    }

    @Override
    public void update() {
        sprite.setPosition(position.getPosition());

        boundingBox.minX = position.getPosition().x;
        boundingBox.minY = position.getPosition().y;
        boundingBox.maxX = position.getPosition().x + sprite.getWidth();
        boundingBox.maxY = position.getPosition().y + sprite.getHeight();

    }

    @Override
    public void render(Screen screen) {
        screen.draw(this);
    }

    @Override
    public void setLevel(Level level) {
        this.level = level;
    }

    public Bitmap getSprite() {
        return sprite;
    }

    public TilePosition getTilePosition() {
        return position;
    }
    public Vec2 getPosition(){ return position.getPosition(); }

    public Rectanglef getBoundingBox() {
        return boundingBox;
    }

    public boolean isSolid(){
        return solid;
    }

    public Tile setSolid(boolean solid){
        this.solid = solid;
        return this;
    }

    public String getName() {
        return name;
    }
}
