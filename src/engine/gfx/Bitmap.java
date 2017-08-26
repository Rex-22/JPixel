package engine.gfx;

import com.sun.org.apache.regexp.internal.RE;

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

    /**
     * Create a bitmap from a image file
     * 
     * @param filepath The file to load to this bitmap
     */
    public Bitmap(String filepath){
        pixels = LoadImage(filepath);
    }
    
    /**
     * Create a bitmap with one uniform colour
     * 
     * @param width 	The width of the bitmap
     * @param height	The height of the bitmap
     * @param colour	The colour of the bitmap
     */
    public Bitmap(int width, int height, int colour) {
    	this.width = width;
        this.height = height;
        this.type = BufferedImage.TYPE_INT_RGB;
        image = new BufferedImage(width, height, type);

        pixels =  ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        for (int i = 0; i < width * height; i++) {
            pixels[i] = colour;
        }
    }

    public void scale(int width, int height){
        BufferedImage resized = new BufferedImage(width, height, type);
        Graphics2D g2d = resized.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g2d.drawImage(image, 0, 0, width, height,
                0, 0, this.width, this.height, null);
        g2d.dispose();

        image = resized;
        this.width = width;
        this.height = height;
    }

    public void scale(int amount){
        scale(amount, amount);
    }

    public Bitmap(int width, int height) {
    	this(width, height, 0xff00ff);
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

    public int GetPixel(int x, int y){
        return pixels[x + y * width];
    }

    public void SetPixel(int x, int y, int col) {
        pixels[x + y * width] = col;
    }
}
