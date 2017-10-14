package sandbox.entity;

import engine.core.Entity;
import engine.core.Transform;
import engine.gfx.Sprite;
import sandbox.Textures;

public class EntityCoin extends Entity {

    public EntityCoin(Transform transform) {
        super(transform, Textures.COIN);
    }

}
