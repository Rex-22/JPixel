package ruben.jpixel.engine.core;

import ruben.jpixel.engine.graphics.Camera;
import ruben.jpixel.engine.graphics.Layer;
import ruben.jpixel.engine.graphics.Screen;

import java.awt.*;

public interface IGame {

    void init();
    void update(float delta);
    void render(Screen screen);
    void render(Graphics g);
    Camera getCamera();

    void add(Layer layer);

}
