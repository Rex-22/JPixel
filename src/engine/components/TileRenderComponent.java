package engine.components;

import engine.core.Camera;
import engine.core.Transform;
import engine.gfx.Sprite;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class TileRenderComponent extends Component {

    private Sprite m_Texture;

    public TileRenderComponent(Sprite texture) {
        this.m_Texture = texture;
    }

    @Override
    public void Init() {
        m_Texture.SetTransform(m_Parent.GetTransform());
    }

    @Override
    public void OnRender(Graphics g3, Camera camera) {
        Transform parentTrans = m_Parent.GetTransform();
        Graphics2D g = (Graphics2D) g3;

        g.drawImage(m_Texture.GetBitmap().GetImage(),
                AffineTransform.getTranslateInstance((parentTrans.GetX() * parentTrans.GetSize()) - camera.GetX(),
                (parentTrans.GetY() * parentTrans.GetSize()) - camera.GetY()), null);
    }

    public Sprite GetTexture() {
        return m_Texture;
    }
}
