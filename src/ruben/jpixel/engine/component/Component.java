package ruben.jpixel.engine.component;

import ruben.jpixel.engine.entity.Entity;
import ruben.jpixel.engine.graphics.Screen;

public class Component {

    protected Entity parent;

    public void update(){}
    public void render(Screen screen){}

    public void setParent(Entity parent){
        this.parent = parent;
    }

}
