package game.packman;

import game.packman.gfx.Sprite;

import java.awt.*;

public class Tile {

    private Sprite tile;
    private int x, y;

    /**
     * @param x The x coordinate, in tile size, where this tile will be located
     * @param y The y coordinate, in tile size, where this tile will be located
     * @param tile The sprite this till will use
     */
    public Tile(int x, int y, Sprite tile){
        this.tile = tile;
        this.x = x;
        this.y = y;
    }

    public Tile(Sprite tile){
        this.tile = tile;
        this.x = 0;
        this.y = 0;
    }

    public Tile(Tile tile){
        this.x = tile.x;
        this.y = tile.y;
        this.tile = tile.tile;
    }

    public void Draw(Graphics g){
        tile.Draw(x << (tile.getSize() >> 2), y << (tile.getSize() >> 2), g);
    }

    public Tile Set(int x, int y) {
        this.x = x;
        this.y = y;

        return this;
    }
}
