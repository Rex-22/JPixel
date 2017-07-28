package game.packman;

import game.packman.gfx.Bitmap;
import game.packman.gfx.Sprite;
import game.packman.gfx.SpriteSheet;

import java.awt.*;

public class Level {

    protected Tile[] tiles;

    private int width, height;

    public Level(){
        width = 0;
        height = 0;
        tiles = new Tile[width * height];
    }

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[width * height];
    }

    public void GenerateLevel() {
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {
                tiles[x + y * width] = new Tile(x, y, new Sprite(new SpriteSheet("spritesheet/spritesheet.png"), 0, 1, 16));
            }
        }
    }

    public void Draw(Graphics g) {
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i] != null)
                tiles[i].Draw(g);
        }
    }

}
