package game.packman.gfx;

import game.packman.Packman;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;

import static java.awt.Image.SCALE_AREA_AVERAGING;

public class Bitmap {

    private int[] pixels;
    private int width;
    private int height;
    private int type;

    private BufferedImage image;

    public Bitmap(String filepath){
        pixels = LoadImage(filepath);
    }

    public Bitmap(int width, int height) {
        this.width = width;
        this.height = height;
        this.type = BufferedImage.TYPE_INT_RGB;

        pixels = new int[width * height];

        image = new BufferedImage(width, height, type);
        image.setRGB(0, 0, 0xff00ff);
    }

    public void Draw(Graphics g, int x, int y){
        g.drawImage(image, x, y, null);
    }

    private int[] LoadImage(String filepath) {
        int[] pixels = null;

        BufferedImage img;

        try{
            img = ImageIO.read(new File("res/"+filepath));

            width = img.getWidth();
            height = img.getHeight();
            type = img.getType();


            image = img;

            pixels = new int[width * height];

            img.getRGB(0, 0, width, height, pixels, 0, width);
        }catch (Exception e){
            e.printStackTrace();
        }

        return pixels;
    }

    public int GetHeight() {
        return height;
    }

    public int GetWidth() {
        return width;
    }

    public int[] GetPixels() {
        return pixels;
    }

    public void SetPixel(int pos, int col) {
        pixels[pos] = col;
    }
}
