package game.packman;

import game.packman.gfx.Bitmap;

import java.util.Map;

public class BitmapLevel extends Level{

    private Bitmap level;

    private Map<Integer, Tile> tileIndex;

    public BitmapLevel(Bitmap level, Map<Integer, Tile> tileIndex){
        super(level.GetWidth(), level.GetHeight());
    }

    @Override
    public void GenerateLevel() {

    }
}
