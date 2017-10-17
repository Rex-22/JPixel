package ruben.jpixel.sandbox;

import ruben.jpixel.engine.graphics.Sprite;
import ruben.jpixel.engine.math.Vec2;
import ruben.jpixel.engine.tile.Tile;
import ruben.jpixel.engine.tile.TilePosition;

public class LayerLevel extends LayerGame{

    public LayerLevel() {

        Tile grass_1 = new Tile(new TilePosition(new Vec2(0, 0)), Sprite.grass_top_left);
        Tile grass_2 = new Tile(new TilePosition(new Vec2(1, 0)), Sprite.grass_top_center);
        Tile grass_3 = new Tile(new TilePosition(new Vec2(2, 0)), Sprite.grass_top_right);

        Tile grass_4 = new Tile(new TilePosition(new Vec2(0, 1)), Sprite.grass_middle_left);
        Tile grass_5 = new Tile(new TilePosition(new Vec2(1, 1)), Sprite.grass_middle_center);
        Tile grass_6 = new Tile(new TilePosition(new Vec2(2, 1)), Sprite.grass_middle_right);

        Tile grass_7 = new Tile(new TilePosition(new Vec2(0, 2)), Sprite.grass_bottom_left);
        Tile grass_8 = new Tile(new TilePosition(new Vec2(1, 2)), Sprite.grass_bottom_center);
        Tile grass_9 = new Tile(new TilePosition(new Vec2(2, 2)), Sprite.grass_bottom_right);

        add(grass_1);
        add(grass_2);
        add(grass_3);
        add(grass_4);
        add(grass_5);
        add(grass_6);
        add(grass_7);
        add(grass_8);
        add(grass_9);

    }
}
