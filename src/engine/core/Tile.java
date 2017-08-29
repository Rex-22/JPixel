package engine.core;

import engine.components.TileRenderComponent;
import engine.gfx.Sprite;

public abstract class Tile extends GameObject {

    private Sprite m_Texture;

    public Tile(Transform transform, Sprite texture) {
        super(transform);
        this.m_Texture = texture;
        AddComponent(new TileRenderComponent(m_Texture));
    }

}
