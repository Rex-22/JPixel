package game.packman.gfx;

import java.awt.*;

public class Sprite {

    private SpriteSheet sheet;

    private int x, y;
    private int posX, posY;
    private int size;

    private Bitmap sprite;


    /**
     * @param sheet The sprite sheet that will be used to load the sprites form
     * @param x The X coordinate the sprite is located on in the sprite sheet
     * @param y The Y coordinate the sprite is located on in the sprite sheet
     * @param size The size in pixels of the sprite, this will be used to offset
     *             the x and y coordinates
     */
    public Sprite(SpriteSheet sheet, int x, int y, int size) {
        this.sheet = sheet;
        this.x = x;
        this.y = y;
        this.size = size;

        sprite = sheet.GetSprite(x, y, size);

        posX = 0;
        posY = 0;
    }

    public SpriteSheet getSheet() {
        return sheet;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public int getSize() {
        return size;
    }

    public Bitmap getSprite() {
        return sprite;
    }

    public void Draw(int x, int y, Graphics g) {
        sprite.Draw(x, y, g);
    }
}
