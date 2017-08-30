package engine.gfx;

import engine.core.Camera;
import engine.core.Transform;

import java.awt.*;

public class Sprite {

    private SpriteSheet m_Sheet;

    private Transform m_Transform;

    private Bitmap m_Sprite;

    /**
     * This will get a sprite form a sprite sheet
     *
     * NOTE: Transparency is a problem with sprite sheets, so transparent sprites might not work
     *
     * @param sheet The m_Sprite sheet that will be used to load the sprites form
     * @param sheetX The x location on the m_Sprite sheet of the current m_Sprite
     * @param sheetY The y location on the m_Sprite sheet of the current m_Sprite
     */
    public Sprite(SpriteSheet sheet, int sheetX, int sheetY) {
        this.m_Sheet = sheet;
        m_Sprite = sheet.GetSprite(sheetX, sheetY);
    }

    /**
     * This will create a sprite with one solid colour with a specified width and height
     *
     * @param colour    The Colour the sprite will be
     * @param width     The Width of the sprite
     * @param height    the Height of the sprite
     */
    public Sprite(int colour, int width, int height) {
        m_Sprite = new Bitmap(height, width, colour);
    }


    /**
     * This will create a sprite for a given image
     *
     *
     * @param path The path to the image
     */
    public Sprite(String path){
        m_Sprite = new Bitmap(path);
    }

    /**
     * @param colour    The Colour the sprite will be
     */
    public Sprite(int colour) {
        this(colour, 16, 16);
    }


    public SpriteSheet GetSheet() {
        return m_Sheet;
    }

    public Transform GetTransform() {
        return m_Transform;
    }

    public Bitmap GetBitmap() {
        return m_Sprite;
    }

    public void OnRender(Graphics g, Camera camera) {
        m_Sprite.Render(m_Transform.GetX() - camera.GetX(), m_Transform.GetY() - camera.GetY(), g);
    }

    public void SetTransform(Transform transform) {
        this.m_Transform = transform;
        m_Sprite.Scale(transform.GetSize());
    }
}
