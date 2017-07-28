package game.packman;

import game.packman.gfx.Bitmap;
import game.packman.gfx.Layer;
import game.packman.gfx.Sprite;
import game.packman.gfx.SpriteSheet;

import java.awt.*;
import java.util.HashMap;

public class TestLayer extends Layer {

    Level level;
    Bitmap levelMap;

    @Override
    public void Init() {
        levelMap = new Bitmap("level/level.png");
        SpriteSheet spriteSheet = new SpriteSheet("spritesheet/spritesheet.png");
        HashMap<Integer, Tile> tileindex = new HashMap<>();

        tileindex.put(0xFF000000, new Tile(new Sprite(spriteSheet, 1, 0, 16)));
        tileindex.put(0xFFFFFFFF, new Tile(new Sprite(spriteSheet, 0, 0, 16)));

//        //Wall
//        tileindex.put(0xFF000000, new Tile(new Sprite(spriteSheet, 1, 0, 16)));
//
//        //Floor
//        tileindex.put(0xFF8C8C8C, new Tile(new Sprite(spriteSheet, 0, 0, 16)));
//        tileindex.put(0xFF00FFFF, new Tile(new Sprite(spriteSheet, 0, 0, 16)));
//        tileindex.put(0xFF8282FF, new Tile(new Sprite(spriteSheet, 0, 0, 16)));
//        tileindex.put(0xFF8CFF8C, new Tile(new Sprite(spriteSheet, 0, 0, 16)));
//        tileindex.put(0xFF1100FF, new Tile(new Sprite(spriteSheet, 0, 0, 16)));
//
//        //Barrier
//        tileindex.put(0xFF82FFFF, new Tile(new Sprite(spriteSheet, 0, 1, 16)));

        level = new BitmapLevel(levelMap, tileindex);
    }

    @Override
    public void Draw(Graphics g) {
        level.Draw(g);
    }

}
