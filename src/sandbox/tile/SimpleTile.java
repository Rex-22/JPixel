package sandbox.tile;

import engine.core.tile.Tile;
import engine.core.Transform;
import engine.gfx.Sprite;

public class SimpleTile extends Tile {

    public SimpleTile(Transform transform, Sprite texture, String name) {
        super(transform, name, texture);
    }

    public SimpleTile(Sprite texture, String name) {
        super(new Transform(), name, texture);
    }

    public SimpleTile(Tile tile) {
        super(tile);
    }
}
