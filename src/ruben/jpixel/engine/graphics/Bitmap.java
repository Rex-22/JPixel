package ruben.jpixel.engine.graphics;

import ruben.jpixel.engine.math.Vec2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Bitmap implements IDrawable, IImageLoader {

    private int width;
    private int height;
    private int[] pixels;

    private Vec2 position;

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
        pixels = LoadImage(imagePath);

        position = new Vec2();
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

    @Override
    public int[] LoadImage(String path) {
        int[] pixels = null;
        try{
            BufferedImage image = ImageIO.read(new File(Bitmap.class.getClassLoader().getResource("assets/"+path).getFile()));

            width = image.getWidth();
            height = image.getHeight();

            pixels = new int[width * height];
            image.getRGB(0, 0, width, height, pixels, 0, width);
        }catch (Exception e){
            e.printStackTrace();
        }

        return pixels;
    }

    public void setPosition(Vec2 position) {
        this.position = position;
    }
}
