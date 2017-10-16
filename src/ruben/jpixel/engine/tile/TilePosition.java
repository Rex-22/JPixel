package ruben.jpixel.engine.tile;

import ruben.jpixel.engine.math.Vec2;

public class TilePosition {

    private Vec2 position;

    public TilePosition(Vec2 position) {
        this.position = position.mulLocal(Tile.SIZE);
    }

    public Vec2 getPosition() {
        return position;
    }

    public void setPosition(Vec2 position) {
        this.position = position.mulLocal(Tile.SIZE);
    }

}
