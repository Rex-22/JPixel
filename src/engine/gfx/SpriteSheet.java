package engine.gfx;

public class SpriteSheet extends Bitmap {

    private int m_Width;
    private int m_Height;
    private int m_Size;

    /**
     * Create a sprite sheet that has sprites inside
     *
     * @param path The path to the sprite sheet
     * @param size The size of a sprite in the sheet
     */
    public SpriteSheet(String path, int size) {
        super(path);
        m_Width = this.GetWidth();
        m_Height = this.GetHeight();
        this.m_Size = size;
    }

    public Bitmap GetSprite(int x, int y) {
        Bitmap sprite = new Bitmap(m_Size, m_Size);

        x = x * m_Size;
        y = y * m_Size;

        sprite.SetImage(GetImage().getSubimage(x, y, m_Size, m_Size));

        return sprite;
    }
    
    public int GetWidth() {
		return m_Width;
	}
    
    public int GetHeight() {
		return m_Height;
	}
    
}
