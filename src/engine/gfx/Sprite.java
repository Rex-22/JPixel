package engine.gfx;

import engine.core.Camera;
import engine.core.Transform;

import java.awt.*;

public class Sprite {

    private SpriteSheet m_Sheet;

    private Transform m_Transform;

    private Bitmap m_Sprite;

    /**
     * @param sheet The m_Sprite sheet that will be used to load the sprites form
     * @param sheetX The x location on the m_Sprite sheet of the current m_Sprite
     * @param sheetY The y location on the m_Sprite sheet of the current m_Sprite
     */
    public Sprite(SpriteSheet sheet, int sheetX, int sheetY) {
        this.m_Sheet = sheet;
        m_Sprite = sheet.GetSprite(sheetX, sheetY);
    }

    /**
     * @param colour    The Colour the m_Sprite will be
     * @param width     The Width of the m_Sprite
     * @param height    the Height of the m_Sprite
     */
    public Sprite(int colour, int width, int height) {
        m_Sprite = new Bitmap(height, width, colour);
    }

    /**
     * @param colour    The Colour the m_Sprite will be
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

    public void Render(Graphics g, Camera camera) {
        m_Sprite.Render(m_Transform.GetX() - camera.GetX(), m_Transform.GetY() - camera.GetY(), g);
    }

    public void SetTransform(Transform transform) {
        this.m_Transform = transform;
        m_Sprite.Scale(transform.GetSize());
    }
}
