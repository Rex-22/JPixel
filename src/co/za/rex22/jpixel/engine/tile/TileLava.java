package co.za.rex22.jpixel.engine.tile;

import co.za.rex22.jpixel.engine.graphics.AnimatedSprite;
import co.za.rex22.jpixel.engine.graphics.Screen;
import co.za.rex22.jpixel.engine.graphics.Sprite;
import co.za.rex22.jpixel.engine.graphics.SpriteSheet;

public class TileLava extends Tile {

    private AnimatedSprite lava = new AnimatedSprite(SpriteSheet.lava_anim, 16, 16, 4);

    public TileLava(TilePosition position) {
        super(position, null, "lava");
    }

    @Override
    public void update(float delta) {
        lava.update(delta);
    }

    @Override
    public void render(Screen screen) {
        Sprite sprite = lava.getSprite();
        screen.draw(getPosition().x, getPosition().y, sprite);
    }
}
