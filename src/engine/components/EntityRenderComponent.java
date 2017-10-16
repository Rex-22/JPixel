package engine.components;

import engine.core.Camera;
import engine.core.Transform;
import engine.core.entity.Entity;
import engine.gfx.Sprite;
import org.joml.Vector2f;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class EntityRenderComponent extends Component {

    private Sprite m_Texture;
    private Entity m_ParentEntity;

    public EntityRenderComponent(Entity entity) {
        m_Texture = entity.GetSprite();
        this.m_ParentEntity = entity;
    }

    @Override
    public void Init() {
        if (m_ParentEntity.GetTransform().GetSize().equals(new Vector2f())) {
            if (m_Texture.GetSheet() != null)
                m_Parent.GetTransform().SetSize(m_Texture.GetSheet().GetSize());
            else
                m_Parent.GetTransform().SetSize(m_Texture.GetBitmap().GetSize());
        }

        m_Texture.SetTransform(m_Parent.GetTransform());
    }

    @Override
    public void OnUpdate(float delta) {
        if (m_Parent.HasMoved()) {
            m_Texture.SetTransform(m_Parent.GetTransform());
        }
    }

    @Override
    public void OnRender(Graphics g, Camera camera) {
        if (m_ParentEntity.IsGridAligned()) {
            Transform parentTrans = m_Parent.GetTransform();
            Graphics2D g2 = (Graphics2D) g;

            m_ParentEntity.GetSprite().GetBitmap().Scale(new Vector2f(32, 32));

            g2.drawImage(m_Texture.GetBitmap().GetImage(),
                    AffineTransform.getTranslateInstance(
                            (parentTrans.GetX() * parentTrans.GetSize().x * 2) - camera.GetX(),
                            (parentTrans.GetY() * parentTrans.GetSize().y * 2) - camera.GetY()), null);

        } else {
            m_Texture.OnRender(g, camera, new Vector2f(32, 32));
        }
    }

    public Sprite GetTexture() {
        return m_Texture;
    }

    /**
     * @return The entity the renderer is attached to
     */
    public Entity GetParent() {
        return m_ParentEntity;
    }
}
