package engine.components;

import engine.core.entity.Entity;
import org.joml.AABBf;
import org.joml.Rectanglef;

public class CollisionComponent extends Component {

    public AABBf m_BoundingBox;

    public CollisionComponent(AABBf m_BoundingBox) {
        this.m_BoundingBox = m_BoundingBox;
    }

    public CollisionComponent(float minX, float minY, float width, float height) {
        this.m_BoundingBox = new AABBf(minX, 0, minY, width, 0,height);
    }

    public boolean Intersects(Entity entity) {
        if (entity.GetComponent(CollisionComponent.class) != null) {
            CollisionComponent comp = entity.GetComponent(CollisionComponent.class);
            return comp.m_BoundingBox.testAABB(m_BoundingBox);
        } else {
            System.out.println("The entity specified does not have a collision competent");
            return false;
        }
    }
}
