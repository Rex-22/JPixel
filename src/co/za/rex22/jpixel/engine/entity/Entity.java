package co.za.rex22.jpixel.engine.entity;

import co.za.rex22.jpixel.engine.component.Component;
import co.za.rex22.jpixel.engine.core.IGameObject;
import co.za.rex22.jpixel.engine.graphics.Screen;
import co.za.rex22.jpixel.engine.graphics.Sprite;
import co.za.rex22.jpixel.engine.level.Level;
import co.za.rex22.jpixel.engine.math.Vec2;
import co.za.rex22.jpixel.engine.tile.Tile;
import co.za.rex22.jpixel.engine.tile.TilePosition;
import org.dyn4j.collision.manifold.Manifold;
import org.dyn4j.collision.narrowphase.Penetration;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.dynamics.CollisionListener;
import org.dyn4j.dynamics.contact.ContactConstraint;
import org.dyn4j.geometry.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Entity extends Body implements IGameObject, CollisionListener {

    private Vec2 position;
    private Level level;
    protected Sprite sprite;

    private List<co.za.rex22.jpixel.engine.component.Component> componentStack;
    private String name;

    private boolean enabled = true;

    public Entity(Vec2 position, String name, Sprite sprite) {
        addFixture(new BodyFixture(new Rectangle(sprite.getWidth(), sprite.getHeight())));
        this.position = position;
        this.name = name;
        componentStack = new ArrayList<>();
        this.sprite = sprite;
    }

    public Entity(String name, Sprite sprite) {
        this(new Vec2(0, 0), name, sprite);
    }

    public void updateEntity() {

    }

    public void renderEntity(Screen screen) {
        screen.draw(this);
    }

    public void renderEntity(Graphics g) {}

    @Override
    public void update(float delta) {
        if (this.isEnabled()) {
            this.translate(position.x, position.y);
            for (int i = 0; i < componentStack.size(); i++) {
                componentStack.get(i).update(delta);
            }
            updateEntity();
        }
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

    public void render(Graphics g){
        for (int i = 0; i < componentStack.size(); i++) {
            componentStack.get(i).render(g);
        }

        renderEntity(g);
    }

    public void add(Component component) {
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

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public boolean collision(Body body1, BodyFixture fixture1, Body body2, BodyFixture fixture2) {
        return true;
    }

    @Override
    public boolean collision(Body body1, BodyFixture fixture1, Body body2, BodyFixture fixture2, Penetration penetration) {
        return true;
    }

    @Override
    public boolean collision(Body body1, BodyFixture fixture1, Body body2, BodyFixture fixture2, Manifold manifold) {
        return true;
    }

    @Override
    public boolean collision(ContactConstraint contactConstraint) {
        return true;
    }
}
