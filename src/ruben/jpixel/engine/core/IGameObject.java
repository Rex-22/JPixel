package ruben.jpixel.engine.core;

import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.level.Level;

public interface IGameObject {

    void update();
    void render(Screen screen);

    void setLevel(Level level);
}
