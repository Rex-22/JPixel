package engine.components;

import engine.core.Camera;
import engine.core.GameObject;
import engine.core.event.Event;
import engine.core.event.IEventListener;
import engine.core.event.IMouseEvent;
import engine.core.event.types.*;

import java.awt.*;

public abstract class Component implements IEventListener, IMouseEvent {

    protected GameObject m_Parent;

    private boolean m_Enabled = true;

    public void Init(){}
    public void OnUpdate(float delta){}
    public void OnRender(Graphics g, Camera camera){}
    public void OnEvent(Event event) {}

    @Override
    public void OnMouseMovedEvent(MouseMovedEvent event) {}
    @Override
    public void OnMousePressedEvent(MousePressedEvent event) {}
    @Override
    public void OnMouseReleasedEvent(MouseReleasedEvent event) {}

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
