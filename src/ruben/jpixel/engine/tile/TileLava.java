package ruben.jpixel.engine.tile;

import ruben.jpixel.engine.graphics.AnimatedSprite;
import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.graphics.Sprite;
import ruben.jpixel.engine.graphics.SpriteSheet;

public class TileLava extends Tile {

    private AnimatedSprite lava = new AnimatedSprite(SpriteSheet.lava_anim, 16, 16, 4);

    public TileLava(TilePosition position) {
        super(position, null, "lava");
    }

    @Override
    public void update() {
        lava.update();
    }

    @Override
    public void render(Screen screen) {
        Sprite sprite = lava.getSprite();
        screen.draw(getPosition().x, getPosition().y, sprite);
    }
}
