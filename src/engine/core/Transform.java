package engine.core;

import org.joml.Vector2f;

public class Transform {

    private Vector2f m_Position;
    private int size;

    public Transform(Vector2f position, int size) {
        this.m_Position = position;
        this.size = size;
    }

    public Transform(Vector2f position){
        this(position, 50);
    }

    public Transform(int size){
        this(new Vector2f(), size);
    }

    public Transform(){
        this(new Vector2f());
    }

    public void SetPosition(Vector2f position){
        this.m_Position = position;
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

    public int GetSize() {
        return size;
    }

    public void SetSize(int size) {
        this.size = size;
    }
}
