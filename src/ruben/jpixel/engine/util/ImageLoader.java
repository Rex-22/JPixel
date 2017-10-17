package ruben.jpixel.engine.util;

import ruben.jpixel.engine.graphics.Bitmap;
import ruben.jpixel.engine.graphics.IImageLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageLoader implements IImageLoader {

    private int width;
    private int height;

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
