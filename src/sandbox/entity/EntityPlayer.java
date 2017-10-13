package sandbox.entity;

import engine.core.Entity;
import engine.core.Transform;
import engine.gfx.Sprite;

//Create a entity from a template class called entity
public class EntityPlayer extends Entity {

    public EntityPlayer(Transform transform, Sprite sprite) {
        super(transform, sprite);
    }

}
