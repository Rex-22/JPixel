package engine.core;

import engine.components.Component;
import engine.core.event.Event;
import org.joml.Vector2f;

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

    public void OnEvent(Event event){
        for (Component comp : m_Components)
            if (comp.IsEnabled())
                comp.OnEvent(event);
    }

    public void MasterUpdate(float delta) {
        if (HasMoved()) {
            m_OldTransform = m_Transform;
        }

        for (Component comp : m_Components)
            if (comp.IsEnabled())
                comp.OnUpdate(delta);

        OnUpdate(delta);
    }

    public void MasterRender(Graphics g, Camera camera) {
        for (Component comp : m_Components)
            if (comp.IsEnabled())
                comp.OnRender(g, camera);

        OnRender(g);
    }

    public void OnUpdate(float delta) {
    }

    public void OnRender(Graphics g) {
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



    public void SetPosition(Vector2f position) {
        m_Transform.SetPosition(position);
    }
}
