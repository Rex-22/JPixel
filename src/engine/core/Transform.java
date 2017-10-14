package engine.core;

import org.joml.Vector2f;

public class Transform {

    private Vector2f m_Position;
    private Vector2f m_Size;

    public Transform(Vector2f position, Vector2f size) {
        this.m_Position = position;
        this.m_Size = size;
    }

    public Transform(Vector2f position) {
        this(position, new Vector2f(50, 50));
    }

    public Transform(float x, float y){
        this(new Vector2f(x, y));
    }

    public Transform(){
        this(new Vector2f());
    }

    public void SetPosition(Vector2f position){
        this.m_Position = position;
    }

    public void SetPosition(float x, float y){
        SetPosition(new Vector2f(x, y));
    }

    public void SetPosition(int x, int y){
        SetPosition(new Vector2f(x, y));
    }

    public void SetPosition(int x, int y, boolean snap){
        if (snap)
            SetPosition(new Vector2f(x * m_Size.x, y * m_Size.y));
        else
            SetPosition(new Vector2f(x, y));
    }

    public float GetX() {
        return m_Position.x;
    }

    public float GetY() {
        return m_Position.y;
    }

    public Vector2f GetPosition() {
        return m_Position;
    }

    public Vector2f GetSize() {
        return m_Size;
    }

    public void SetSize(Vector2f size) {
        this.m_Size = size;
    }
}
