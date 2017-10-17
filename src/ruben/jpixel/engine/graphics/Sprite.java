package ruben.jpixel.engine.graphics;

import ruben.jpixel.engine.math.Vec2;

public class Sprite extends Bitmap {

//    public static Sprite grass_top_left = new Sprite(32, 0, 0, SpriteSheet.tiles);
//    public static Sprite grass_top_center = new Sprite(32, 1, 0, SpriteSheet.tiles);
//    public static Sprite grass_top_right = new Sprite(32, 2, 0, SpriteSheet.tiles);
//
//    public static Sprite grass_middle_left = new Sprite(32, 0, 1, SpriteSheet.tiles);
//    public static Sprite grass_middle_center = new Sprite(32, 1, 1, SpriteSheet.tiles);
//    public static Sprite grass_middle_right = new Sprite(32, 2, 1, SpriteSheet.tiles);
//
//    public static Sprite grass_bottom_left = new Sprite(32, 0, 2, SpriteSheet.tiles);
//    public static Sprite grass_bottom_center = new Sprite(32, 1, 2, SpriteSheet.tiles);
//    public static Sprite grass_bottom_right = new Sprite(32, 2, 2, SpriteSheet.tiles);

    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
    public static Sprite stone = new Sprite(16, 1, 0, SpriteSheet.tiles);
    public static Sprite wood = new Sprite(16, 2, 0, SpriteSheet.tiles);
    public static Bitmap coin = new Bitmap("sprites/coin.png");

    private int SIZE;

    private SpriteSheet sheet;

    private Vec2 position;

    public Sprite(int colour, int width, int height){
        pixels = new int[width * height];
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = colour;
        }
    }

    public Sprite(int[] pixels, int width, int height) {
        this.pixels = pixels;
        this.width = width;
        this.height = height;
        this.position = new Vec2();
    }

    public Sprite(SpriteSheet sheet, int width, int height) {
        SIZE = (width == height) ? width : -1;
        this.width = width;
        this.height = height;
        this.sheet = sheet;
        this.position = new Vec2();
    }

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        this.width = size;
        this.height = size;
        this.pixels = new int[SIZE * SIZE];
        position = new Vec2(x * size, y * size);
        this.sheet = sheet;
        load();
    }

    public static Sprite[] split(SpriteSheet sheet) {
        int amount = (sheet.getWidth() * sheet.getHeight()) / (sheet.SPRITE_WIDTH * sheet.SPRITE_HEIGHT);
        Sprite[] sprites = new Sprite[amount];
        int current = 0;
        int[] pixels = new int[sheet.SPRITE_WIDTH * sheet.SPRITE_HEIGHT];
        for (int yp = 0; yp < sheet.getHeight() / sheet.SPRITE_HEIGHT; yp++) {
            for (int xp = 0; xp < sheet.getWidth() / sheet.SPRITE_WIDTH; xp++) {

                for (int y = 0; y < sheet.SPRITE_HEIGHT; y++) {
                    for (int x = 0; x < sheet.SPRITE_WIDTH; x++) {
                        int xo = x + xp * sheet.SPRITE_WIDTH;
                        int yo = y + yp * sheet.SPRITE_HEIGHT;
                        pixels[x + y * sheet.SPRITE_WIDTH] = sheet.getPixels()[xo + yo * sheet.getWidth()];
                    }
                }

                sprites[current++] = new Sprite(pixels, sheet.SPRITE_WIDTH, sheet.SPRITE_HEIGHT);
            }
        }

        return sprites;
    }

    private void load() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[x + y * width] = sheet.pixels[(x + position.x) + (y + position.y) * sheet.SPRITE_WIDTH];
            }
        }
    }

}
