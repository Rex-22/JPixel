package engine.core;

import org.joml.Vector2f;

public class Camera {

    private Vector2f m_Position;

    public Camera(int x, int y){
        this(new Vector2f(x, y));
    }

    public Camera(Vector2f position) {
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

    public void SetPosition(float x, float y){
        this.m_Position.set(x, y);
    }

    public void SetPosition(Vector2f position) {
        this.m_Position = position;
    }
}
