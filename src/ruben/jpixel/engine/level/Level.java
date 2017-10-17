package ruben.jpixel.engine.level;

import ruben.jpixel.engine.core.IGameObject;
import ruben.jpixel.engine.graphics.Bitmap;
import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.graphics.Sprite;
import ruben.jpixel.engine.math.Vec2;
import ruben.jpixel.engine.tile.Tile;
import ruben.jpixel.engine.tile.TilePosition;

import java.util.ArrayList;
import java.util.List;

public class Level implements IGameObject {

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
        level_tile = new Bitmap("levels/"+name+"_tile.png");
        level_data = new Bitmap("levels/"+name+"_data.png");

        tiles = new Tile[level_tile.getWidth() * level_tile.getHeight()];

        for (int y = 0; y < level_tile.getHeight(); y++) {
            for (int x = 0; x < level_tile.getWidth(); x++) {
                int col = level_tile.getPixel()[x + y * level_tile.getWidth()];
                tiles[x + y * level_tile.getWidth()] = getTile(col, new Vec2(x, y));
            }
        }
    }

    private Tile getTile(int colour, Vec2 position){
        if (colour == 0xFF4CFF00) return new Tile(new TilePosition(position), Sprite.grass);
        if (colour == 0xFF7F3300) return new Tile(new TilePosition(position), Sprite.stone);
        if (colour == 0xFFFF6A00) return new Tile(new TilePosition(position), Sprite.wood);

        return new Tile(new TilePosition(position), new Sprite(0xff00ff, 32, 32));
    }

    @Override
    public void update() {
        for (int i = 0; i < tiles.length; i++) {
            tiles[i].update();
        }

        for (int i = 0; i < level_objects.size(); i++) {
            level_objects.get(i).update();
        }
    }

    @Override
    public void render(Screen screen) {
        for (int i = 0; i < tiles.length; i++) {
            screen.draw(tiles[i]);
        }

        for (int i = 0; i < level_objects.size(); i++) {
            level_objects.get(i).render(screen);
        }
    }

    @Override
    public void setLevel(Level level) {}

    public void add(IGameObject object){
        if (!(object instanceof Level)) {
            this.level_objects.add(object);
            object.setLevel(this);
        }
    }
}
