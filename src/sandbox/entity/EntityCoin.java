package sandbox.entity;

import engine.core.entity.Entity;
import engine.core.Transform;
import sandbox.Textures;

public class EntityCoin extends Entity {

    public EntityCoin(Transform transform) {
        super(transform, Textures.COIN);
    }

}
