package engine.components;

import engine.core.Camera;
import engine.core.GameObject;
import engine.core.event.Event;
import engine.core.event.EventListener;

import java.awt.*;

public abstract class Component implements EventListener {

    protected GameObject m_Parent;

    private boolean m_Enabled = true;

    public void Init(){}
    public void OnUpdate(){}
    public void OnRender(Graphics g, Camera camera){}
    public void OnEvent(Event event) {

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
