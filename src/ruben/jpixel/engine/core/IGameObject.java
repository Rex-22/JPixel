package ruben.jpixel.engine.core;

import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.level.Level;
import ruben.jpixel.engine.math.Vec2;
import ruben.jpixel.engine.tile.TilePosition;

public interface IGameObject {

    void update();
    void render(Screen screen);

    void setLevel(Level level);

    Vec2 getPosition();
    TilePosition getTilePosition();
}
