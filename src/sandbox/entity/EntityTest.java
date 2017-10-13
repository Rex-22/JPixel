package sandbox.entity;

import engine.core.Entity;
import engine.core.Transform;
import engine.gfx.Sprite;
import org.joml.Vector2f;
import org.joml.Vector2i;

//Create a entity from a template class called entity
public class EntityTest extends Entity {

    public EntityTest(Transform transform, Sprite sprite) {
        super(transform, sprite);
    }

}
