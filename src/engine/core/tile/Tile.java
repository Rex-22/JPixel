package engine.core.tile;

import engine.components.TileRenderComponent;
import engine.core.GameObject;
import engine.core.Transform;
import engine.gfx.Sprite;

import java.util.List;

public abstract class Tile extends GameObject {

    private Sprite m_Texture;
    private String m_Name;

    private NBT<String, String> m_Tags;

    public Tile(Transform transform, String name, Sprite texture) {
        super(transform);
        this.m_Texture = texture;
        this.m_Name = name;
        AddComponent(new TileRenderComponent(this));

        m_Tags = new NBT<String, String>() {
            List<String> tags;

            @Override
            public void AddTag(Object value) {
                tags.add((String) value);
            }

            @Override
            public String GetTagCompound(String name) {
                for (String t : tags) {
                    if (t.equals(name)) return t;
                }

                return null;
            }
        };

    }

    public Tile(Tile tile){
        this(tile.m_Transform, tile.m_Name, tile.m_Texture);
    }

   public boolean IsSolid(){
        return false;
    }

    public String GetName() {
        return m_Name;
    }

    public Sprite GetTexture(){ return m_Texture; }
}
