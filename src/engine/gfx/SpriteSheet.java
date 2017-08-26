package engine.gfx;

public class SpriteSheet {

    private String path;
    private int width;
    private int height;
    private int size;
    private Bitmap sheet;

    public SpriteSheet(String path, int size) {
        this.path = path;
        sheet = LoadSheet();
        width = sheet.GetWidth();
        height = sheet.GetHeight();
        this.size = size;
    }

    private Bitmap LoadSheet() {
       return new Bitmap(path);
    }

    public Bitmap GetSprite(int x, int y, int scaleSize){
        Bitmap sprite = new Bitmap(size, size);

        x = x * size;
        y = y * size;

        for (int yp = 0; yp < size; yp++) {
            for (int xp = 0; xp < size; xp++) {
                sprite.SetPixel(xp, yp, sheet.GetPixel((x + xp), (y + yp)));
            }
        }

        if (scaleSize != 0)
            sprite.scale(scaleSize);

        return sprite;
    }

    public Bitmap GetSprite(int x, int y) {
        return GetSprite(x, y, 50);
    }
    
    public int getWidth() {
		return width;
	}
    
    public int getHeight() {
		return height;
	}
    
}
