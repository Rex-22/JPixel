package engine.core;

import engine.gfx.Sprite;
import engine.components.TileRenderer;

public abstract class Tile extends GameObject {

    private Sprite m_Texture;

    public Tile(Transform transform, Sprite texture) {
        super(transform);
        this.m_Texture = texture;
        AddComponent(new TileRenderer(m_Texture));
    }

}
