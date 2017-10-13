package engine.components;

import engine.core.Camera;
import engine.core.Entity;
import engine.core.Transform;
import engine.gfx.Sprite;
import org.joml.Vector2f;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class EntityRenderComponent extends Component {

    private Sprite m_Texture;
    private boolean m_RenderBoundingBox = false;
    private Entity m_ParentEntity;

    public EntityRenderComponent(Entity entity){
        m_Texture = entity.GetSprite();
        this.m_ParentEntity = entity;
    }

    @Override
    public void Init() {
        m_Texture.SetTransform(m_Parent.GetTransform());
    }

    @Override
    public void OnUpdate(float delta) {
        if (m_Parent.HasMoved()){
            m_Texture.SetTransform(m_Parent.GetTransform());
        }
    }

    @Override
    public void OnRender(Graphics g, Camera camera) {
       if (m_ParentEntity.IsGridAligned()){
           Transform parentTrans = m_Parent.GetTransform();
           Graphics2D g2 = (Graphics2D) g;

           m_ParentEntity.GetTransform().SetPosition(new Vector2f(
                   parentTrans.GetX() * parentTrans.GetSize().x - camera.GetX(),
                   parentTrans.GetY() * parentTrans.GetSize().y - camera.GetY()));

           g2.drawImage(m_Texture.GetBitmap().GetImage(),
                   AffineTransform.getTranslateInstance(m_ParentEntity.GetTransform().GetX(), m_ParentEntity.GetTransform().GetY()), null);
       }else{
           m_Texture.OnRender(g, camera);

       }

        if(m_RenderBoundingBox){
            g.setColor(Color.PINK);
            GetParent().GetBoundingBox().x = -(int)camera.GetX() + (int)GetParent().GetTransform().GetPosition().x;
            GetParent().GetBoundingBox().y = -(int)camera.GetY() + (int)GetParent().GetTransform().GetPosition().y;

            ((Graphics2D)g).draw(GetParent().GetBoundingBox());
        }

    }

    public Sprite GetTexture() {
        return m_Texture;
    }

    public void SetRenderBoundingBox(boolean shouldRender) {
        this.m_RenderBoundingBox = shouldRender;
    }


    /**
     * @return The entity the renderer is attached to
     */
    public Entity GetParent() {
        return m_ParentEntity;
    }
}
