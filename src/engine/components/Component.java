package engine.components;

import engine.core.Camera;
import engine.core.GameObject;

import java.awt.*;

public abstract class Component{

    protected GameObject m_Parent;

    private boolean m_Enabled = true;

    public abstract void Init();
    public void Update(){}
    public void Render(Graphics g, Camera camera){}

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
