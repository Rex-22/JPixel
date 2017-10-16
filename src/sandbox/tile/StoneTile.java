package sandbox.tile;

import engine.core.Transform;
import sandbox.Textures;

public class StoneTile extends SimpleTile {

    public StoneTile() {
        super(new Transform(),Textures.STONE, "stone");
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
