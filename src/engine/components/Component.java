package engine.components;

import engine.core.Camera;
import engine.core.GameObject;
import engine.core.event.Event;
import engine.core.event.EventListener;
import engine.core.event.types.*;

import java.awt.*;

public abstract class Component implements EventListener {

    protected GameObject m_Parent;

    private boolean m_Enabled = true;

    public void Init(){}
    public void OnUpdate(float delta){}
    public void OnRender(Graphics g, Camera camera){}
    public void OnEvent(Event event) {}

    public void OnKeyPressedEvent(KeyPressedEvent event) {}
    public void OnKeyReleasedEvent(KeyReleasedEvent event) {}

    protected void OnMouseMovedEvent(int x, int y, int screenX, int screenY, boolean dragged) {}
    protected void OnMousePressedEvent(int x, int y, int screenX, int screenY, int button) {}
    protected void OnMouseReleasedEvent(int x, int y, int screenX, int screenY, int button) {}

    public void OnMouseMovedEvent(MouseMovedEvent event) {
        if(m_Parent.GetBoundingBox().contains(event.GetX(), event.GetY())){
            OnMouseMovedEvent(event.GetX(), event.GetY(), event.GetScreenX(), event.GetScreenY(), event.GetDragged());
        }
    }

    public void OnMousePressedEvent(MousePressedEvent event) {
        if(m_Parent.GetBoundingBox().contains(event.GetX(), event.GetY())){
            OnMousePressedEvent(event.GetX(), event.GetY(), event.GetScreenX(), event.GetScreenY(), event.GetButton());
        }
    }

    public void OnMouseReleasedEvent(MouseReleasedEvent event) {
        if(m_Parent.GetBoundingBox().contains(event.GetX(), event.GetY())){
            OnMouseReleasedEvent(event.GetX(), event.GetY(), event.GetScreenX(), event.GetScreenY(), event.GetButton());
        }
    }

    public void SetParent(GameObject object){
        this.m_Parent = object;
        Init();
    }

    public void SetEnabled(boolean enabled) {
        this.m_Enabled = enabled;
    }

    public boolean IsEnabled() {
        return m_Enabled;
    }

    public GameObject GetParent() {
        return m_Parent;
    }
}
