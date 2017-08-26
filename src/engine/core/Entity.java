package engine.core;

import engine.gfx.Sprite;

import java.awt.*;

public abstract class Entity {

    private Transform old_transform;

    private Transform transform;
    private Sprite sprite;

    public Entity(Transform transform, Sprite sprite){
        this.transform = transform;
        this.sprite = sprite;

        old_transform = transform;
        sprite.setTransform(transform);
    }

    public void MasterRender(Graphics g) {
        sprite.Draw(g);
        Render(g);
    }

    public void MasterUpdate() {
        if(transform != old_transform){
            sprite.setTransform(transform);
            old_transform = transform;
        }
        Update();
    }

    public void Update(){}
    public void Render(Graphics g){}

    public void setTransform(Transform transform) {
        this.transform = transform;
        sprite.setTransform(transform);

    }

    public Transform getTransform() {
        return transform;
    }

    public Sprite getSprite() {
        return sprite;
    }
}
