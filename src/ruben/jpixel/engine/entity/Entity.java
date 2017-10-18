package ruben.jpixel.engine.entity;

import org.joml.Rectanglef;
import ruben.jpixel.engine.component.Component;
import ruben.jpixel.engine.component.SpriteRendererComponent;
import ruben.jpixel.engine.core.IGameObject;
import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.graphics.Sprite;
import ruben.jpixel.engine.level.Level;
import ruben.jpixel.engine.math.BoundingBox;
import ruben.jpixel.engine.math.Vec2;
import ruben.jpixel.engine.tile.Tile;
import ruben.jpixel.engine.tile.TilePosition;

import java.util.ArrayList;
import java.util.List;

public class Entity implements IGameObject {

    private Vec2 position;
    private Level level;

    private List<Component> componentStack;
    private String name;

    private BoundingBox boundingBox;

    private boolean enabled = true;
    public Sprite sprite;


    public Entity(Vec2 position, String name, Sprite sprite) {
        this.position = position;
        this.name = name;
        this.sprite = sprite;
        componentStack = new ArrayList<>();
        boundingBox = new BoundingBox(
                position.x, position.y,
                sprite.getWidth(), sprite.getHeight());
        if (!name.equals("player"))
        add(new SpriteRendererComponent(sprite));
    }

    public Entity(String name, Sprite sprite) {
        this(new Vec2(0, 0), name, sprite);
     }

    public void updateEntity() {

    }

    public void renderEntity(Screen screen) {

    }

    @Override
    public void update() {
        if (this.isEnabled()) {
            boundingBox.update(position, sprite.getWidth(), sprite.getHeight());
            for (int i = 0; i < componentStack.size(); i++) {
                componentStack.get(i).update();
            }

            updateEntity();
        }
    }

    @Override
    public void render(Screen screen) {
        if (isEnabled()) {
            for (int i = 0; i < componentStack.size(); i++) {
                componentStack.get(i).render(screen);
            }

            renderEntity(screen);
        } else if (name.equals("player")){
            renderEntity(screen);
        }
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

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }
}
