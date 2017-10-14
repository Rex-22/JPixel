package sandbox.tile;

import engine.core.Tile.Tile;
import engine.core.Transform;
import engine.gfx.Sprite;
import sandbox.Textures;

public class StoneTile extends SimpleTile {

    public StoneTile() {
        super(new Transform(),Textures.STONE, "Stone");
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
