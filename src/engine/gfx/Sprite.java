package engine.gfx;

import engine.core.Transform;

import java.awt.*;

public class Sprite {

    private SpriteSheet sheet;

    private Transform transform;

    private Bitmap sprite;

    /**
     * @param sheet The sprite sheet that will be used to load the sprites form
     * @param sheetX The x location on the sprite sheet of the current sprite
     * @param sheetY The y location on the sprite sheet of the current sprite
     */
    public Sprite(SpriteSheet sheet, int sheetX, int sheetY) {
        this.sheet = sheet;
        sprite = sheet.GetSprite(sheetX, sheetY);
    }

    /**
     * @param colour    The Colour the sprite will be
     * @param width     The Width of the sprite
     * @param height    the Height of the sprite
     */
    public Sprite(int colour, int width, int height) {
        sprite = new Bitmap(height, width, colour);
    }

    public SpriteSheet getSheet() {
        return sheet;
    }

    public Transform getTransform() {
        return transform;
    }

    public Bitmap getBitmap() {
        return sprite;
    }

    public void Draw(Graphics g) {
        sprite.Draw(transform.getX(), transform.getY(), g);
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
        sprite.scale(transform.getSize());
    }
}
