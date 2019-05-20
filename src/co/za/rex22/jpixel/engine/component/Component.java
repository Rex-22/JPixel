package co.za.rex22.jpixel.engine.component;

import co.za.rex22.jpixel.engine.entity.Entity;
import co.za.rex22.jpixel.engine.graphics.Screen;

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
