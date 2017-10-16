package ruben.jpixel.engine.entity;

import ruben.jpixel.engine.component.Component;
import ruben.jpixel.engine.graphics.Bitmap;
import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.math.Vec2;

import java.util.ArrayList;
import java.util.List;

public class Entity {

    private Vec2 position;
    private Bitmap sprite;

    private List<Component> componentStack;

    public Entity(Vec2 position, Bitmap sprite){
        this.position = position;
        this.sprite = sprite;

        componentStack = new ArrayList<>();
    }

    public Entity(Vec2 position){
        this(position, new Bitmap(16, 16));
    }

    public Entity(){
        this(new Vec2(0, 0), new Bitmap(16, 16));
    }

    public void updateComponent() {
        for (int i = 0; i < componentStack.size(); i++) {
            componentStack.get(i).update();
        }
        sprite.setPosition(position);

        update();
    }

    public void renderComponent(Screen screen) {
        for (int i = 0; i < componentStack.size(); i++) {
            componentStack.get(i).render(screen);
        }

        render(screen);
    }

    private void update(){}

    private void render(Screen screen) {
        screen.draw(this);
    }

    public void add(Component component){
        componentStack.add(component);
        component.setParent(this);
    }

    public Vec2 getPosition() {
        return position;
    }

    public Bitmap getSprite() {
        return sprite;
    }
}
