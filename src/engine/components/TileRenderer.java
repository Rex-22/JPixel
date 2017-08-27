package engine.components;

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
    public void Render(Graphics g) {
        Transform parentTrans = m_Parent.GetTransform();
        g.drawImage(m_Texture.GetBitmap().GetImage(),
                parentTrans.GetX() * parentTrans.GetSize(),
                parentTrans.GetY() * parentTrans.GetSize(), null);
    }

    public Sprite GetTexture() {
        return m_Texture;
    }
}
