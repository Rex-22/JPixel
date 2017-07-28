package game.pacman.gfx;

public class SpriteSheet {

    private String path;
    private int width;
    private int height;
    private Bitmap sheet;

    public SpriteSheet(String path) {
        this.path = path;
        sheet = LoadSheet();
        width = sheet.GetWidth();
        height = sheet.GetHeight();
    }

    private Bitmap LoadSheet() {
       return new Bitmap(path);
    }

    public Bitmap GetSprite(int x, int y, int size){
        Bitmap sprite = new Bitmap(size, size);

        x = x * size;
        y = y * size;

        for (int yp = 0; yp < size; yp++) {
            for (int xp = 0; xp < size; xp++) {
                sprite.SetPixel(xp + yp * size, sheet.GetPixels()[(x + xp) + (y + yp) * sheet.GetWidth()]);
            }
        }

        return sprite;
    }
}
