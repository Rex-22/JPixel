package engine.core;

import engine.components.EntityRenderComponent;
import engine.gfx.Sprite;

public abstract class Entity extends GameObject {

    private Sprite m_Texture;

    /**This is a flag for rendering the entity in the tile grid
     *
     * The means that the transform position will not be treated as screen space coordinates, but as
     * tile grid coordinates
     * */
    private boolean m_IsGridAligned;

    public Entity(Transform transform, Sprite texture) {
        super(transform);
        this.m_Texture = texture;
        this.m_IsGridAligned = false;
        AddComponent(new EntityRenderComponent(this));
    }

    public Sprite GetSprite() {
        return m_Texture;
    }

    public boolean IsGridAligned(){
        return m_IsGridAligned;
    }

    public void SetGridAligned(boolean aligned){
        this.m_IsGridAligned = aligned;
    }
}
