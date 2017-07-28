package game.packman;

import game.packman.gfx.Bitmap;
import game.packman.gfx.Layer;
import game.packman.gfx.Sprite;
import game.packman.gfx.SpriteSheet;

import java.awt.*;

public class TestLayer extends Layer {

    Level level;

    @Override
    public void Init() {
       level = new Level(16, 16);
    }

    @Override
    public void Render(Graphics g) {
      level.Render(g);
    }

}
