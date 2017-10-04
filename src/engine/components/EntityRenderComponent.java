package engine.components;

import engine.core.Camera;
import engine.gfx.Sprite;

import java.awt.*;

public class EntityRenderComponent extends Component {

    private Sprite m_Texture;
    private boolean m_RenderBoundingBox = false;

    public EntityRenderComponent(Sprite texture){
        m_Texture = texture;
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
        m_Texture.OnRender(g, camera);

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
}
