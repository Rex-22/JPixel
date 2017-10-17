package ruben.jpixel.engine.level;

import ruben.jpixel.engine.core.IGameObject;
import ruben.jpixel.engine.graphics.Bitmap;
import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.math.Vec2;
import ruben.jpixel.engine.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class Level implements IGameObject{

    private String name;
    private Bitmap level_tile;
    private Bitmap level_data;

    private Tile[] tiles;

    private List<IGameObject> level_objects;

    public Level(String name){
        this.name = name;
        this.level_objects = new ArrayList<>();
        loadLevel();
    }

    private void loadLevel(){
        level_tile = new Bitmap("levels/"+name+"_tile");
        level_data = new Bitmap("levels/"+name+"_data");



        for (int y = 0; y < level_tile.getHeight(); y++) {
            for (int x = 0; x < level_tile.getWidth(); x++) {
                tiles[x + y * level_tile.getWidth()] = getTile(col);
            }
        }
    }

    private Tile getTile(int colour, Vec2 position){
        if (colour == 0x4CFF00) return new Tile(new Vec2(), );
    }

    @Override
    public void update() {
        for (int i = 0; i < level_objects.size(); i++) {
            level_objects.get(i).update();
        }
    }

    @Override
    public void render(Screen screen) {
        for (int i = 0; i < level_objects.size(); i++) {
            level_objects.get(i).render(screen);
        }
    }
}
