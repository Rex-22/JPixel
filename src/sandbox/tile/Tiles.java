package sandbox.tile;

import engine.core.Tile.Tile;
import sandbox.Textures;

public class Tiles {

    public static Tile STONE = new StoneTile();
    public static Tile GRASS = new SimpleTile(Textures.GRASS, "grass");
    public static Tile GRASS_FLOWER = new SimpleTile(Textures.GRASS_FLOWER, "grass_flower");
    public static Tile DIRT = new SimpleTile(Textures.DIRT, "dirt");

}
