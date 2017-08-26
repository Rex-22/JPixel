package engine;

import engine.core.Entity;
import java.awt.*;

public class Component {

    public Entity parent;

    public void Update(){}
    public void Render(Graphics g){}

    public void setParent(Entity entity){
        this.parent = entity;
    }

    public Entity getParent() {
        return parent;
    }
}
