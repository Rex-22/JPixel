package co.za.rex22.jpixel.engine.core;

import co.za.rex22.jpixel.engine.graphics.Screen;
import co.za.rex22.jpixel.engine.level.Level;
import co.za.rex22.jpixel.engine.math.Vec2;
import co.za.rex22.jpixel.engine.tile.TilePosition;

import java.awt.*;

public interface IGameObject {

    void update(float delta);
    void render(Screen screen);
    void render(Graphics g);

    void setLevel(Level level);

    Vec2 getPosition();
    TilePosition getTilePosition();
}
