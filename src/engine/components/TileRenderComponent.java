package engine.components;

import engine.core.Camera;
import engine.core.tile.Tile;
import engine.core.Transform;
import engine.gfx.Sprite;
import org.joml.Vector2f;

import javax.rmi.CORBA.Tie;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class TileRenderComponent extends Component {

    private Tile m_Tile;

    public TileRenderComponent(Tile tile) {
        this.m_Tile = tile;
    }

    @Override
    public void Init() {
        m_Tile.GetTexture().SetTransform(m_Parent.GetTransform());
    }

    @Override
    public void OnRender(Graphics g3, Camera camera) {
        Transform parentTrans = m_Parent.GetTransform();
        Graphics2D g = (Graphics2D) g3;

        m_Tile.GetTexture().GetBitmap().Scale(new Vector2f(32, 32));

        g.drawImage(m_Tile.GetTexture().GetBitmap().GetImage(),
                AffineTransform.getTranslateInstance(
                        ((parentTrans.GetX() * parentTrans.GetSize().x) * 2) - camera.GetX(),
                        ((parentTrans.GetY() * parentTrans.GetSize().y) * 2) - camera.GetY()), null);
    }

    public Sprite GetTexture() {
        return m_Tile.GetTexture();
    }

    public Tile GetTile() {
        return m_Tile;
    }
}
