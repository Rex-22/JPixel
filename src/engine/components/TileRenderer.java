package engine.components;

import engine.core.Camera;
import engine.core.Transform;
import engine.gfx.Sprite;

import java.awt.*;

public class TileRenderer extends Component {

    private Sprite m_Texture;

    public TileRenderer(Sprite texture) {
        this.m_Texture = texture;
    }

    @Override
    public void Init() {
        m_Texture.SetTransform(m_Parent.GetTransform());
    }

    @Override
    public void Render(Graphics g, Camera camera) {
        Transform parentTrans = m_Parent.GetTransform();
        g.drawImage(m_Texture.GetBitmap().GetImage(),
                (parentTrans.GetX() * parentTrans.GetSize()) - camera.GetX(),
                (parentTrans.GetY() * parentTrans.GetSize()) - camera.GetY(), null);
    }

    public Sprite GetTexture() {
        return m_Texture;
    }
}
