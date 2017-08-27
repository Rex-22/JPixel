package engine.components;

import engine.gfx.Sprite;

import java.awt.*;

public class PixelRenderer extends Component {

    private Sprite m_Sprite;

    public PixelRenderer(Sprite sprite){
        m_Sprite = sprite;
    }

    @Override
    public void Init() {
        m_Sprite.SetTransform(m_Parent.GetTransform());
    }

    @Override
    public void Update() {
        if (m_Parent.HasMoved()){
            m_Sprite.SetTransform(m_Parent.GetTransform());
        }
    }

    @Override
    public void Render(Graphics g) {
        m_Sprite.Render(g);
    }

    public Sprite GetSprite() {
        return m_Sprite;
    }

}
