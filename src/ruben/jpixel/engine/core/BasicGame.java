package ruben.jpixel.engine.core;

import ruben.jpixel.engine.graphics.Camera;
import ruben.jpixel.engine.graphics.Layer;
import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.input.Input;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class BasicGame implements IGame {

    protected Camera camera;
    private List<Layer> layerStack;

    public BasicGame(String title){
        CoreEngine engine = new CoreEngine(title, this);
        layerStack = new ArrayList<>();
        camera = new Camera(0, 0);
        Layer.setCamera(camera);

        engine.start();
    }

    @Override
    public void init() {
        
    }

    @Override
    public void update(float delta) {
        for (int i = 0; i < layerStack.size(); i++) {
            layerStack.get(i).updateEntity(delta);
        }
    }

    @Override
    public void render(Screen screen) {
        for (int i = 0; i < layerStack.size(); i++) {
            layerStack.get(i).renderEntity(screen);
        }
    }

    @Override
    public void render(Graphics g) {
        for (int i = 0; i < layerStack.size(); i++) {
            layerStack.get(i).renderEntity(g);
        }
    }

    @Override
    public Camera getCamera() {
        return camera;
    }

    @Override
    public void add(Layer layer) {
        layerStack.add(layer);
    }
}
