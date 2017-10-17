package ruben.jpixel.engine.entity;

import org.joml.AABBf;
import org.joml.Rectanglef;
import ruben.jpixel.engine.component.Component;
import ruben.jpixel.engine.core.IGameObject;
import ruben.jpixel.engine.graphics.Bitmap;
import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.level.Level;
import ruben.jpixel.engine.math.Vec2;
import ruben.jpixel.engine.tile.Tile;
import ruben.jpixel.engine.tile.TilePosition;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Entity implements IGameObject {

    private Vec2 position;
    private Bitmap sprite;
    private Level level;

    private List<Component> componentStack;
    private String name;

    private Rectanglef boundingBox;
    private boolean enabled = true;

    public Entity(Vec2 position, Bitmap sprite, String name){
        this.position = position;
        this.sprite = sprite;
        this.name = name;

        boundingBox = new Rectanglef(position.x,position.y, sprite.getWidth(),sprite.getHeight());

        componentStack = new ArrayList<>();
    }

    public Entity(Vec2 position, String name) {
        this(position, new Bitmap(16, 16), name);
    }

    public Entity(String name){
        this(new Vec2(0, 0), new Bitmap(16, 16), name);
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

        boundingBox.minX = position.x;
        boundingBox.minY = position.y;
        boundingBox.maxX = position.x + sprite.getWidth();
        boundingBox.maxY = position.y + sprite.getHeight();

        updateEntity();
    }

    @Override
    public void render(Screen screen) {
        for (int i = 0; i < componentStack.size(); i++) {
            componentStack.get(i).render(screen);
        }
        if (isEnabled()) {
            screen.draw(this);
        }

        renderEntity(screen);
    }

    public void add(Component component){
        componentStack.add(component);
        component.setParent(this);
    }

    public Vec2 getPosition() {
        return position;
    }

    @Override
    public TilePosition getTilePosition() {
        return new TilePosition(position.div(Tile.SIZE));
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

    public String getName() {
        return name;
    }

    public Rectanglef getBoundingBox() {
        return boundingBox;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
