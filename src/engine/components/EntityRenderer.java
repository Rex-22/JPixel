package engine.components;

import engine.core.Camera;
import engine.gfx.Sprite;

import java.awt.*;

public class EntityRenderer extends Component {

    private Sprite m_Texture;

    public EntityRenderer(Sprite texture){
        m_Texture = texture;
    }

    @Override
    public void Init() {
        m_Texture.SetTransform(m_Parent.GetTransform());
    }

    @Override
    public void Update() {
        if (m_Parent.HasMoved()){
            m_Texture.SetTransform(m_Parent.GetTransform());
        }
    }

    @Override
    public void Render(Graphics g, Camera camera) {
        m_Texture.Render(g, camera);
    }

    public Sprite GetTexture() {
        return m_Texture;
    }

}
