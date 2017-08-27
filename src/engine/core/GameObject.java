package engine.core;

import engine.components.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObject {

    protected Transform m_Transform;
    private Transform m_OldTransform;

    protected List<Component> m_Components;

    public GameObject(Transform transform) {
        this.m_Transform = transform;
        this.m_OldTransform = transform;

        m_Components = new ArrayList<>();
    }

    public void MasterUpdate() {
        if (HasMoved()) {
            m_OldTransform = m_Transform;
        }

        for (Component comp : m_Components)
            if (comp.IsEnabled())
                comp.Update();

        Update();
    }

    public void MasterRender(Graphics g) {
        for (Component comp : m_Components)
            if (comp.IsEnabled())
                comp.Render(g);

        Render(g);
    }

    public void Update() {
    }

    public void Render(Graphics g) {
    }

    public void AddComponent(Component component) {
        component.SetParent(this);
        m_Components.add(component);
    }


    public void SetTransform(Transform transform) {
        this.m_Transform = transform;
    }

    public Transform GetTransform() {
        return m_Transform;
    }

    public boolean HasMoved() {
        return m_Transform != m_OldTransform;
    }

    public <T extends Component> T GetComponent(Class<T> component) {
        for (Component com : m_Components) {
            if (component.isAssignableFrom(com.getClass()))
                return (T) com;
        }

        return null;
    }

    public void SetPosition(int x, int y) {
        m_Transform.SetPosition(x, y);
    }
}
