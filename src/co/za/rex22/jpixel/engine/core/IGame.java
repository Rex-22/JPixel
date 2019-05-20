package co.za.rex22.jpixel.engine.core;

import co.za.rex22.jpixel.engine.graphics.Camera;
import co.za.rex22.jpixel.engine.graphics.Layer;
import co.za.rex22.jpixel.engine.graphics.Screen;

import java.awt.*;

public interface IGame {

    void init();
    void update(float delta);
    void render(Screen screen);
    void render(Graphics g);
    Camera getCamera();

    void add(Layer layer);

}
