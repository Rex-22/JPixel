package engine.ui;

import engine.core.GameObject;
import engine.core.Transform;
import engine.core.event.EventListener;
import org.joml.Vector2f;
import org.joml.Vector2i;

import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class UIComponent extends GameObject implements EventListener {

    private Rectangle m_BoundingBox;

    private boolean m_Visible = true;

    private List<UIComponent> m_Children;

    public UIComponent(Vector2i position, Vector2i size) {
        super(new Transform(new Vector2f(position.x, position.y), new Vector2f(size.x, size.y)));
        this.m_Children = new CopyOnWriteArrayList<>();
        m_BoundingBox = new Rectangle(position.x, position.y, size.y, size.x);
    }

    public UIComponent(Vector2i position) {
        this(position, new Vector2i(10, 50));
    }


    public void OnRender(Graphics2D g) {
        g.fillRect(GetPosition().x, GetPosition().y, GetSize().x, GetSize().y);
    }

    public void OnUpdate(float delta) {
        if (m_BoundingBox.getLocation() != new Point(GetPosition().x, GetPosition().y)){
            m_BoundingBox.setLocation(GetPosition().x, GetPosition().y);
        }
    }


    public Vector2i GetPosition() {
        return new Vector2i((int)GetTransform().GetPosition().x, (int)GetTransform().GetPosition().y);
    }

    public Vector2i GetSize() {
        return new Vector2i((int)GetTransform().GetSize().x, (int)GetTransform().GetSize().y);
    }

    public void SetPosition(Vector2i position) {
        this.GetTransform().GetPosition().set(position.x, position.y);
    }

    public void SetSize(Vector2i size) {
        this.GetTransform().GetPosition().set(size.x, size.y);
    }

    public boolean IsVisible() {
        return m_Visible;
    }

    public void SetVisible(boolean visible) {
        this.m_Visible = visible;
    }

    public Rectangle GetBoundingBox() {
        return m_BoundingBox;
    }
}
