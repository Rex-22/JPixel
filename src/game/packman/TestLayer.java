package game.packman;

import game.packman.gfx.Bitmap;
import game.packman.gfx.Layer;
import game.packman.gfx.SpriteSheet;

import java.awt.*;

public class TestLayer extends Layer {

    SpriteSheet sheet;

    Bitmap tile;

    @Override
    public void Init() {
        sheet = new SpriteSheet("spritesheet/spritesheet.png");

        tile = new Bitmap(16, 16);
    }

    @Override
    public void Render(Graphics g) {
        tile.Draw(g, 50, 50);

//        sheet.GetSprite(0, 1, 16).Draw(g, 50, 50);
    }

}
