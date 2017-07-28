package game.packman;

import game.packman.gfx.Bitmap;

import java.util.HashMap;
import java.util.Map;

public class BitmapLevel extends Level {

    private Bitmap level;

    private HashMap<Integer, Tile> tileIndex;

    /**
     * @param level     The bitmap that will be used to generate the level
     * @param tileIndex Used to map a color to a specific tile
     */
    public BitmapLevel(Bitmap level, HashMap<Integer, Tile> tileIndex) {
        super(level.GetWidth(), level.GetHeight());

        this.level = level;
        this.tileIndex = tileIndex;

        this.tiles = new Tile[level.GetWidth() * level.GetHeight()];

        GenerateLevel();
    }

    @Override
    public void GenerateLevel() {
        for (int y = 0; y < level.GetWidth(); y++) {
            for (int x = 0; x < level.GetHeight(); x++) {
                for (HashMap.Entry<Integer, Tile> tiles : tileIndex.entrySet()) {
                    //0xff000000 == 0xff000000
                    if (tiles.getKey() == level.GetPixels()[x + y * level.GetWidth()]) {
                        this.tiles[x + y * level.GetWidth()] = new Tile(tiles.getValue().Set(x, y));
                        break;
                    }
                }
            }
        }
    }
}
