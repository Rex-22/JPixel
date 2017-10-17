package ruben.jpixel.engine.graphics;

import ruben.jpixel.engine.math.Vec2;
import ruben.jpixel.engine.util.ImageLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Bitmap implements IDrawable {

    protected int width;
    protected int height;
    protected int[] pixels;
    private int SIZE;

    private Vec2 position;

    public Bitmap(){}

    public Bitmap(int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width * height];

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0xff00ff;
        }

        position = new Vec2();
    }

    public Bitmap(String imagePath){
        ImageLoader loader = new ImageLoader();
        pixels = loader.LoadImage(imagePath);

        this.width = loader.getWidth();
        this.height = loader.getHeight();

        position = new Vec2();
    }

    public Bitmap(int[] pixels, int width, int height) {
        this.pixels = pixels;
        this.width = width;
        this.height = height;
    }

    public static Bitmap rotate(Sprite sprite, double angle) {
        return new Bitmap(rotate(sprite.pixels, sprite.width, sprite.height, angle), sprite.width, sprite.height);
    }

    private static int[] rotate(int[] pixels, int width, int height, double angle) {
        int[] result = new int[width * height];

        double nx_x = rot_x(-angle, 1.0, 0.0);
        double nx_y = rot_y(-angle, 1.0, 0.0);
        double ny_x = rot_x(-angle, 0.0, 1.0);
        double ny_y = rot_y(-angle, 0.0, 1.0);

        double x0 = rot_x(-angle, -width / 2.0, -height / 2.0) + width / 2.0;
        double y0 = rot_y(-angle, -width / 2.0, -height / 2.0) + height / 2.0;

        for (int y = 0; y < height; y++) {
            double x1 = x0;
            double y1 = y0;
            for (int x = 0; x < width; x++) {
                int xx = (int) x1;
                int yy = (int) y1;
                int col = 0;
                if (xx < 0 || xx >= width || yy < 0 || yy >= height) col = 0xffff00ff;
                else col = pixels[xx + yy * width];
                result[x + y * width] = col;
                x1 += nx_x;
                y1 += nx_y;
            }
            x0 += ny_x;
            y0 += ny_y;
        }

        return result;
    }

    private static double rot_x(double angle, double x, double y) {
        double cos = Math.cos(angle - Math.PI / 2);
        double sin = Math.sin(angle - Math.PI / 2);
        return x * cos + y * -sin;
    }

    private static double rot_y(double angle, double x, double y) {
        double cos = Math.cos(angle - Math.PI / 2);
        double sin = Math.sin(angle - Math.PI / 2);
        return x * sin + y * cos;
    }

    @Override
    public int[] getPixel() {
        return pixels;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public Vec2 getPosition() {
        return position;
    }

    @Override
    public void setPixel(int location, int colour) {
        pixels[location] = colour;
    }

    public void setPosition(Vec2 position) {
        this.position = position;
    }
}
