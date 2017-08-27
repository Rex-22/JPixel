package engine.gfx;

public class SpriteSheet extends Bitmap{

    private int m_Width;
    private int m_Height;
    private int m_Size;

    public SpriteSheet(String path, int size) {
        super(path);
        m_Width = this.GetWidth();
        m_Height = this.GetHeight();
        this.m_Size = size;
    }


    public Bitmap GetSprite(int x, int y, int scaleSize){
        Bitmap sprite = new Bitmap(m_Size, m_Size);

        x = x * m_Size;
        y = y * m_Size;

        for (int yp = 0; yp < m_Size; yp++) {
            for (int xp = 0; xp < m_Size; xp++) {
                sprite.SetPixel(xp, yp, GetPixel((x + xp), (y + yp)));
            }
        }

        if (scaleSize != 0)
            sprite.Scale(scaleSize);

        return sprite;
    }

    public Bitmap GetSprite(int x, int y) {
        return GetSprite(x, y, 50);
    }
    
    public int GetWidth() {
		return m_Width;
	}
    
    public int GetHeight() {
		return m_Height;
	}
    
}
