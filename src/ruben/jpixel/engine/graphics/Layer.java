package ruben.jpixel.engine.graphics;

import ruben.jpixel.engine.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Layer {

    private List<Entity> entityStack;
    protected static Camera camera;

    public Layer() {
        entityStack = new ArrayList<>();
    }

    public void updateEntity() {
        for (int i = 0; i < entityStack.size(); i++) {
            entityStack.get(i).updateComponent();
        }

        update();
    }

    public void renderEntity(Screen screen) {
        for (int i = 0; i < entityStack.size(); i++) {
            entityStack.get(i).renderComponent(screen);
        }

        render(screen);
    }

    public void update(){}

    public void render(Screen screen){}

    public void add(Entity entity){
        entityStack.add(entity);
    }

    public static void setCamera(Camera camera) {
        Layer.camera = camera;
    }
}
