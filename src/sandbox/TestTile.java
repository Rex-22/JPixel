package sandbox;

import engine.core.Tile;
import engine.core.Transform;
import engine.gfx.Sprite;

import javax.rmi.CORBA.Tie;

public class TestTile extends Tile {

    public TestTile(Transform transform, Sprite texture) {
        super(transform, texture);
    }

}
