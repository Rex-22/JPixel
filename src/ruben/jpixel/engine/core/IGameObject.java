package ruben.jpixel.engine.core;

import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.level.Level;
import ruben.jpixel.engine.math.Vec2;
import ruben.jpixel.engine.tile.TilePosition;

import java.awt.*;

public interface IGameObject {

    void update(float delta);
    void render(Screen screen);
    void render(Graphics g);

    void setLevel(Level level);

    Vec2 getPosition();
    TilePosition getTilePosition();
}
