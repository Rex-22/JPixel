package engine.core;

import engine.components.Component;
import engine.core.event.Event;
import engine.core.event.types.*;
import org.joml.Vector2f;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObject {

    protected Transform m_Transform;
    private Transform m_OldTransform;

    protected List<Component> m_Components;

    private Rectangle m_BoundingBox;

    public GameObject() { m_Components = new ArrayList<>(); }

    public GameObject(Transform transform) {
        this.m_Transform = transform;
        this.m_OldTransform = transform;
        this.m_BoundingBox = new Rectangle((int)transform.GetX(), (int)transform.GetY(), (int)transform.GetSize().x, (int)transform.GetSize().y);

        m_Components = new ArrayList<>();
    }

    public void MasterUpdate(float delta) {
        if (HasMoved()) {
            m_OldTransform = m_Transform;
            m_BoundingBox.setBounds((int)m_Transform.GetX(), (int)m_Transform.GetY(), (int)m_Transform.GetSize().x, (int)m_Transform.GetSize().y);
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
        OnRender((Graphics2D) g);
    }

    public void MasterEvent(Event event){
        for (Component comp : m_Components)
            if (comp.IsEnabled()){
                comp.OnEvent(event);
                switch (event.GetType()) {
                    case KEY_PRESSED:
                        comp.OnKeyPressedEvent((KeyPressedEvent) event);
                        break;
                    case KEY_RELEASED:
                        comp.OnKeyReleasedEvent((KeyReleasedEvent) event);
                        break;
                    case MOUSE_MOVED:
                        comp.OnMouseMovedEvent((MouseMovedEvent) event);
                        break;
                    case MOUSE_PRESSED:
                        comp.OnMousePressedEvent((MousePressedEvent) event);
                        break;
                    case MOUSE_RELEASED:
                        comp.OnMouseReleasedEvent((MouseReleasedEvent) event);
                        break;
                }
            }

        switch (event.GetType()) {
            case KEY_PRESSED:
                OnKeyPressedEvent((KeyPressedEvent) event);
                break;
            case KEY_RELEASED:
                OnKeyReleasedEvent((KeyReleasedEvent) event);
                break;
            case MOUSE_MOVED:
                OnMouseMovedEvent((MouseMovedEvent) event);
                break;
            case MOUSE_PRESSED:
                OnMousePressedEvent((MousePressedEvent) event);
                break;
            case MOUSE_RELEASED:
                OnMouseReleasedEvent((MouseReleasedEvent) event);
                break;
        }

        OnEvent(event);
    }

    public void OnUpdate(float delta) {
    }

    public void OnRender(Graphics g) {
    }

    public void OnRender(Graphics2D g) {
    }

    public void OnEvent(Event event){
    }


    public void AddComponent(Component component) {
        component.SetParent(this);
        m_Components.add(component);
    }

    public void OnKeyPressedEvent(KeyPressedEvent event) {}
    public void OnKeyReleasedEvent(KeyReleasedEvent event) {}

    public void OnMouseMovedEvent(int x, int y, int screenX, int screenY, boolean dragged) {}
    public void OnMousePressedEvent(int x, int y, int screenX, int screenY, int button) {}
    public void OnMouseReleasedEvent(int x, int y, int screenX, int screenY, int button) {}

    private void OnMouseMovedEvent(MouseMovedEvent event) {
        if(m_BoundingBox.contains(event.GetX(), event.GetY())){
            OnMouseMovedEvent(event.GetX(), event.GetY(), event.GetScreenX(), event.GetScreenY(), event.GetDragged());
        }
    }

    private void OnMousePressedEvent(MousePressedEvent event) {
        if(m_BoundingBox.contains(event.GetX(), event.GetY())){
            OnMousePressedEvent(event.GetX(), event.GetY(), event.GetScreenX(), event.GetScreenY(), event.GetButton());
        }
    }

    private void OnMouseReleasedEvent(MouseReleasedEvent event) {
        if(m_BoundingBox.contains(event.GetX(), event.GetY())){
            OnMouseReleasedEvent(event.GetX(), event.GetY(), event.GetScreenX(), event.GetScreenY(), event.GetButton());
        }
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

    public Rectangle GetBoundingBox() {
        return m_BoundingBox;
    }
}
