package ruben.jpixel.engine.core;

import ruben.jpixel.engine.graphics.Camera;
import ruben.jpixel.engine.graphics.Layer;
import ruben.jpixel.engine.graphics.Screen;

public interface IGame {

    void init();
    void update();
    void render(Screen screen);
    Camera getCamera();

    void add(Layer layer);

}
