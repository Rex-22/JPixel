package game.pacman.gfx;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;

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
        image = new BufferedImage(width, height, type);

        pixels =  ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        for (int i = 0; i < width * height; i++) {
            pixels[i] = 0xff00ff;
        }
    }

    public void Draw(int x, int y, Graphics g) {
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
