package ruben.jpixel.engine.component;

import ruben.jpixel.engine.entity.Entity;
import ruben.jpixel.engine.graphics.Screen;

import java.awt.*;

public class Component {

    protected Entity parent;

    public void update(float delta){}
    public void render(Screen screen){}
    public void render(Graphics g){}

    public void setParent(Entity parent){
        this.parent = parent;
    }

}
