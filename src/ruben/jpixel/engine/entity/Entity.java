package ruben.jpixel.engine.entity;

import ruben.jpixel.engine.component.Component;
import ruben.jpixel.engine.core.IGameObject;
import ruben.jpixel.engine.graphics.Bitmap;
import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.level.Level;
import ruben.jpixel.engine.math.Vec2;

import java.util.ArrayList;
import java.util.List;

public class Entity implements IGameObject {

    private Vec2 position;
    private Bitmap sprite;
    private Level level;

    private List<Component> componentStack;

    public Entity(Vec2 position, Bitmap sprite){
        this.position = position;
        this.sprite = sprite;

        componentStack = new ArrayList<>();
    }

    public Entity(Vec2 position) {
        this(position, new Bitmap(16, 16));
    }

    public Entity(){
        this(new Vec2(0, 0), new Bitmap(16, 16));
    }

    public void updateEntity() {

    }

    public void renderEntity(Screen screen) {

    }

    @Override
    public void update() {
        for (int i = 0; i < componentStack.size(); i++) {
            componentStack.get(i).update();
        }
        sprite.setPosition(position);

        updateEntity();
    }

    @Override
    public void render(Screen screen) {
        for (int i = 0; i < componentStack.size(); i++) {
            componentStack.get(i).render(screen);
        }

        screen.draw(this);

        renderEntity(screen);
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

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
}
