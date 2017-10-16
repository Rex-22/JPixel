package ruben.jpixel.sandbox;

import ruben.jpixel.engine.graphics.Bitmap;
import ruben.jpixel.engine.math.Vec2;
import ruben.jpixel.engine.tile.Tile;
import ruben.jpixel.engine.tile.TilePosition;

public class LayerLevel extends LayerGame{

    Tile grass;
    Tile grass2;

    public LayerLevel() {
        Bitmap grass_sprite = new Bitmap("tiles/grass.png");
        grass = new Tile(new TilePosition(new Vec2(0, 0)), grass_sprite);
        grass2 = new Tile(new TilePosition(new Vec2(1, 0)), grass_sprite);
        add(grass);
        add(grass2);
    }
}
