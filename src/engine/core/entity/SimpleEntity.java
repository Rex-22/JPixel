package engine.core.entity;

import engine.core.Transform;
import engine.gfx.Sprite;

public class SimpleEntity extends Entity {

    public SimpleEntity(Transform transform, Sprite texture, String name) {
        super(transform, texture, name);
    }

    public SimpleEntity(Entity entity) {
        super(entity);
    }
}
