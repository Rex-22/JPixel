package ruben.jpixel.engine.tile;

import ruben.jpixel.engine.graphics.AnimatedSprite;
import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.graphics.Sprite;
import ruben.jpixel.engine.graphics.SpriteSheet;

public class TileWater extends Tile {

    private AnimatedSprite water = new AnimatedSprite(SpriteSheet.water_anim, 16, 16, 4);

    public TileWater(TilePosition position) {
        super(position, null, "water");
    }

    @Override
    public void update(float delta) {
        water.update(delta);
    }

    @Override
    public void render(Screen screen) {
        Sprite sprite = water.getSprite();
        screen.draw(getPosition().x, getPosition().y, sprite);
    }
}
