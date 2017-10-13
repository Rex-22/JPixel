package engine.core;

import engine.components.Component;
import engine.core.event.Event;
import org.joml.Vector2f;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A {@class GameObject} is the most simple form a object in the engine.
 * Every component in the engine is derived from this class and can not use the engine if it
 * does not extend this class
 *
 * GameObjects have a list of components that control the way it will behave and act,
 * this inclued things rendering and moving the object
 *
 * It should be noted that you should not be modifying a object directly since it could lead to errors with
 * the use of components and any changes made to the object should occur from one of its components
 * */
public class GameObject {

    /** The location of the object */
    protected Transform m_Transform;
    /** The previous location of the object before it moved */
    private Transform m_OldTransform; //This is deprecated for now since it causes some issues

    /**A list of components to control the object*/
    protected List<Component> m_Components;

    /**The bounding box for the GameObject,
     * NOTE: This is temporary and will be moved to a type of
     * physics engine later on*/
    //TODO: Extrapolate this to a physics system
    //Note: The GameObject class is meant to be very bare boned and minimalistic, all functionality
    //      should be added from a derivative class or added by a component
    private Rectangle m_BoundingBox;

    /**Initialise the GameObject with no parameters
     *
     * This will create a empty component list and a new transform object at 0, 0*/
    public GameObject() {
        this(new Transform());
    }


    /**
     * This will initialise the component to a set location,
     *
     * @param transform The origin of the object
     */
    public GameObject(Transform transform) {
        this.m_Transform = transform;
        this.m_OldTransform = transform;
        this.m_BoundingBox = new Rectangle((int)transform.GetX(), (int)transform.GetY(), (int)transform.GetSize().x, (int)transform.GetSize().y);

        m_Components = new ArrayList<>();
    }


    public void MasterUpdate(float delta) {
//        if (HasMoved()) {
//            m_OldTransform = m_Transform;

            m_BoundingBox.setBounds((int)m_Transform.GetX(), (int)m_Transform.GetY(), (int)m_Transform.GetSize().x, (int)m_Transform.GetSize().y);
//        }

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

    public void SetTransform(Transform transform) {
        this.m_Transform = transform;
    }

    public Transform GetTransform() {
        return m_Transform;
    }

    @Deprecated
    public boolean HasMoved() {
        return false/* !(m_OldTransform.equals(m_Transform))*/;
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
