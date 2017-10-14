package sandbox.tile;

import engine.core.Tile.Tile;
import sandbox.Textures;

public class Tiles {

    public static Tile STONE = new StoneTile();
    public static Tile GRASS = new SimpleTile(Textures.GRASS, "grass");
    public static Tile GRASS_FLOWER = new SimpleTile(Textures.GRASS_FLOWER, "grass_flower");
    public static Tile DIRT = new SimpleTile(Textures.DIRT, "dirt");

    public static Tile GetByName(String tileName) {
        if (STONE.GetName().equals(tileName)) return STONE;
        if (GRASS.GetName().equals(tileName)) return GRASS;
        if (GRASS_FLOWER.GetName().equals(tileName)) return GRASS_FLOWER;
        if (DIRT.GetName().equals(tileName)) return DIRT;

        return STONE;
    }

}
