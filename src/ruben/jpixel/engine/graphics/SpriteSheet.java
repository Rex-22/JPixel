package ruben.jpixel.engine.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteSheet {

    public static SpriteSheet tiles = new SpriteSheet("spritesheets/tilesheet.png", 512);

    private String path;
    public final int SIZE;
    public final int SPRITE_WIDTH, SPRITE_HEIGHT;
    private int width, height;
    public int[] pixels;

    private Bitmap[] sprites;

    public SpriteSheet(SpriteSheet sheet, int x, int y, int width, int height, int spriteSize) {
        int xx = x * spriteSize;
        int yy = y * spriteSize;
        int w = width * spriteSize;
        int h = height * spriteSize;
        if (width == height) SIZE = width;
        else SIZE = -1;
        SPRITE_WIDTH = w;
        SPRITE_HEIGHT = h;
        pixels = new int[w * h];
        for (int y0 = 0; y0 < h; y0++) {
            int yp = yy + y0;
            for (int x0 = 0; x0 < w; x0++) {
                int xp = xx + x0;
                pixels[x0 + y0 * w] = sheet.pixels[xp + yp * sheet.SPRITE_WIDTH];
            }
        }
        int frame = 0;
        sprites = new Bitmap[width * height];
        for (int ya = 0; ya < height; ya++) {
            for (int xa = 0; xa < width; xa++) {
                int[] spritePixels = new int[spriteSize * spriteSize];
                for (int y0 = 0; y0 < spriteSize; y0++) {
                    for (int x0 = 0; x0 < spriteSize; x0++) {
                        spritePixels[x0 + y0 * spriteSize] = pixels[(x0 + xa * spriteSize) + (y0 + ya * spriteSize) * SPRITE_WIDTH];
                    }
                }
                Bitmap sprite = new Bitmap(spritePixels, spriteSize, spriteSize);
                sprites[frame++] = sprite;
            }
        }
    }

    public SpriteSheet(String path, int size) {
        this.path = path;
        SIZE = size;
        SPRITE_WIDTH = size;
        SPRITE_HEIGHT = size;
        load();
    }

    public SpriteSheet(String path, int width, int height) {
        this.path = path;
        SIZE = -1;
        SPRITE_WIDTH = width;
        SPRITE_HEIGHT = height;
        pixels = new int[SPRITE_WIDTH * SPRITE_HEIGHT];
        load();
    }

    public Bitmap[] getSprites() {
        return sprites;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[] getPixels() {
        return pixels;
    }

    private void load() {
        try {
            System.out.print("Trying to load: " + path + "...");
            BufferedImage image = ImageIO.read(new File(Bitmap.class.getClassLoader().getResource("assets/"+path).getFile()));
            System.out.println(" succeeded!");
            width = image.getWidth();
            height = image.getHeight();
            pixels = new int[width * height];
            image.getRGB(0, 0, width, height, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(" failed!");
        }

    }

}
