package sandbox.entity;

import engine.components.CollisionComponent;
import engine.core.entity.Entity;
import engine.core.Transform;
import engine.core.entity.SimpleEntity;
import sandbox.Textures;

public class EntityCoin extends SimpleEntity {

    public EntityCoin(Transform transform) {
        super(transform, Textures.COIN, "coin");
        AddComponent(new CollisionComponent(
                m_Transform.GetX(),
                m_Transform.GetY(),
                m_Transform.GetX() * m_Transform.GetSize().x,
                m_Transform.GetY() * m_Transform.GetSize().y));
    }

}
