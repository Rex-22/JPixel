package sandbox.entity;

import engine.core.Entity;
import engine.core.Transform;
import engine.gfx.Sprite;

public class EntityCoin extends Entity {

    public EntityCoin(Transform transform) {
        super(transform, new Sprite("items/coin.png"));
    }

}
