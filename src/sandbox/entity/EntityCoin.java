package sandbox.entity;

import engine.core.entity.Entity;
import engine.core.Transform;
import engine.core.entity.SimpleEntity;
import sandbox.Textures;

public class EntityCoin extends SimpleEntity {

    public EntityCoin(Transform transform) {
        super(transform, Textures.COIN, "coin");
    }

}
