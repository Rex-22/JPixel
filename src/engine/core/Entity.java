package engine.core;

import engine.components.PixelRenderer;
import engine.gfx.Sprite;

public abstract class Entity extends GameObject {

    private Sprite m_Sprite;

    public Entity(Transform transform, Sprite sprite) {
        super(transform);
        AddComponent(new PixelRenderer(sprite));
    }

    public Sprite GetSprite() {
        return m_Sprite;
    }
}
