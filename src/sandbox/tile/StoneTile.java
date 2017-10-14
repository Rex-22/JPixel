package sandbox.tile;

import engine.core.Tile.Tile;
import engine.core.Transform;
import engine.gfx.Sprite;
import sandbox.Textures;

public class StoneTile extends Tile {

    public StoneTile() {
        super(new Transform(), "Stone",Textures.STONE);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
