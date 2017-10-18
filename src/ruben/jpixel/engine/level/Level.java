package ruben.jpixel.engine.level;

import org.dyn4j.collision.Bounds;
import org.dyn4j.collision.manifold.Manifold;
import org.dyn4j.collision.narrowphase.Penetration;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.dynamics.CollisionListener;
import org.dyn4j.dynamics.World;
import org.dyn4j.dynamics.contact.ContactConstraint;
import ruben.jpixel.engine.core.IGameObject;
import ruben.jpixel.engine.entity.Entity;
import ruben.jpixel.engine.graphics.Bitmap;
import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.graphics.Sprite;
import ruben.jpixel.engine.math.Vec2;
import ruben.jpixel.engine.tile.Tile;
import ruben.jpixel.engine.tile.TileLava;
import ruben.jpixel.engine.tile.TilePosition;
import ruben.jpixel.engine.tile.TileWater;
import ruben.jpixel.sandbox.EntityPlayer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level implements IGameObject {

    private String name;
    private Bitmap level_tile;
    private Bitmap level_data;

    private EntityPlayer player;

    private World world;

    private Tile[] tiles;
    private Tile[] tile_data;

    private List<IGameObject> level_objects;
    public Vec2 spawnLocation;
    public static int totalCoins = 0;

    public Level(String name, EntityPlayer player) {
        this.name = name;
        this.level_objects = new ArrayList<>();
        this.spawnLocation = new Vec2();
        this.player = player;
        loadLevel();
    }

    private void loadLevel() {
        level_tile = new Bitmap("levels/" + name + "_tile.png");
        level_data = new Bitmap("levels/" + name + "_data.png");

        tiles = new Tile[level_tile.getWidth() * level_tile.getHeight()];
        tile_data = new Tile[level_data.getWidth() * level_data.getHeight()];

        world = new World();
        for (int y = 0; y < level_tile.getHeight(); y++) {
            for (int x = 0; x < level_tile.getWidth(); x++) {
                int col = level_tile.getPixel()[x + y * level_tile.getWidth()];
                tiles[x + y * level_tile.getWidth()] = getTile(col, new Vec2(x, y));
            }
        }

        for (int y = 0; y < level_data.getHeight(); y++) {
            for (int x = 0; x < level_data.getWidth(); x++) {
                int col = level_data.getPixel()[x + y * level_data.getWidth()];
                if (col == 0xFFFF0000) spawnLocation.set(x * Tile.SIZE, y * Tile.SIZE);
                if (col == 0xFFFFD800) {
                    Tile coin = new Tile(new TilePosition(new Vec2(x, y)), Sprite.coin, "coin");
                    add(coin);
                    totalCoins++;
                    tile_data[x + y * level_data.getWidth()] = coin;
                }
            }
        }
    }

    private Tile getTile(int colour, Vec2 position) {
        if (colour == 0xFF00FF00) return new Tile(new TilePosition(position), Sprite.grass, "grass");
        if (colour == 0xFF808080) return new Tile(new TilePosition(position), Sprite.stone_1, "stone_1").setSolid(true);
        if (colour == 0xFF303030) return new Tile(new TilePosition(position), Sprite.stone_2, "stone_2").setSolid(true);
        if (colour == 0xFF724715) return new Tile(new TilePosition(position), Sprite.wood, "wood");

        if (colour == 0xFF0000FF) return new TileWater(new TilePosition(position));
        if (colour == 0xFFFF0000) return new TileLava(new TilePosition(position));

        return new Tile(new TilePosition(position), new Sprite(0xff00ff, Tile.SIZE, Tile.SIZE), "void");
    }

    @Override
    public void update(float delta) {
        world.update(delta);
        world.updatev(delta);

        for (int i = 0; i < tiles.length; i++) {
            tiles[i].update(delta);
        }

        for (int i = 0; i < level_objects.size(); i++) {
            level_objects.get(i).update(delta);
        }
    }

    @Override
    public void render(Screen screen) {
        for (int i = 0; i < tiles.length; i++) {
            tiles[i].render(screen);
        }

        for (int i = 0; i < level_objects.size(); i++) {
            level_objects.get(i).render(screen);
        }
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void setLevel(Level level) {
    }

    @Override
    public Vec2 getPosition() {
        return null;
    }

    @Override
    public TilePosition getTilePosition() {
        return null;
    }

    public void add(IGameObject object) {
        if (!(object instanceof Level)) {
            if (object instanceof Entity){
                world.addListener((Entity) object);
                world.addBody((Entity) object);
            }
            this.level_objects.add(object);
            object.setLevel(this);
        }
    }

    public Vec2 getSpawnLocation() {
        return spawnLocation;
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= level_tile.getWidth() || y >= level_tile.getHeight())
            return new Tile(new TilePosition(new Vec2(x, y)), new Sprite(0xffffff, 16, 16), "void").setSolid(true);

        return tiles[x + y * level_tile.getWidth()];
    }

    public Tile getDataTile(int x, int y){
        if (x < 0 || y < 0 || x >= level_data.getWidth() || y >= level_data.getHeight())
            return new Tile(new TilePosition(new Vec2(x, y)), new Sprite(0xffffff, 16, 16), "void").setSolid(true);

        return tile_data[x + y * level_data.getWidth()];
    }

    public int getTotalCoins() {
        return totalCoins;
    }
}
