package ruben.jpixel.engine.tile;

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
    protected Sprite sprite;
    private Level level;
    private boolean solid = false;
    private String name;
    private boolean enabled = true;

    public Tile(TilePosition position, Sprite sprite, String name) {
        this.position = position;
        this.sprite = sprite;
        this.name = name;
    }

    @Override
    public void update(float delta) {
        if (enabled) sprite.setPosition(position.getPosition());
    }

    @Override
    public void render(Screen screen) {
        if (enabled) screen.draw(this);
    }

    @Override
    public void render(Graphics g) {
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

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
