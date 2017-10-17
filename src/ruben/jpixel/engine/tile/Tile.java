package ruben.jpixel.engine.tile;

import ruben.jpixel.engine.core.IGameObject;
import ruben.jpixel.engine.graphics.Bitmap;
import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.graphics.Sprite;

public class Tile implements IGameObject {

    /** This is the tile size for the game, it is not meant to change*/
    public static final int SIZE = 32;

    private TilePosition position;
    private Sprite sprite;

    public Tile(TilePosition position, Sprite sprite) {
        this.position = position;
        this.sprite = sprite;
    }

    @Override
    public void update() {
        sprite.setPosition(position.getPosition());
    }

    @Override
    public void render(Screen screen) {
        screen.draw(this);
    }

    public Bitmap getSprite() {
        return sprite;
    }

    public TilePosition getPosition() {
        return position;
    }
}
