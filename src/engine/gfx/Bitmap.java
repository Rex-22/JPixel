package engine.gfx;

import org.joml.Vector2f;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

public class Bitmap {

    private int m_Width;
    private int m_Height;

    private int m_Type;
    private BufferedImage m_Image;

    /**
     * Create a bitmap from a m_Image file
     * 
     * @param filepath The file to load to this bitmap
     */
    public Bitmap(String filepath){
        m_Image = LoadImage(filepath);
    }
    
    /**
     * Create a bitmap with one uniform colour
     * 
     * @param width 	The m_Width of the bitmap
     * @param height	The m_Height of the bitmap
     * @param colour	The colour of the bitmap
     */
    public Bitmap(int width, int height, int colour) {
    	this.m_Width = width;
        this.m_Height = height;
        this.m_Type = BufferedImage.TYPE_INT_RGB;
        m_Image = new BufferedImage(width, height, m_Type);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                m_Image.setRGB(x, y, colour);
            }
        }
    }

    public Bitmap(int width, int height) {
        this(width, height, 0xff00ff);
    }

    public void Scale(int width, int height){
        BufferedImage resized = new BufferedImage(width, height, m_Type);
        Graphics2D g2d = resized.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g2d.drawImage(m_Image, 0, 0, width, height,
                0, 0, this.m_Width, this.m_Height, null);
        g2d.dispose();

        m_Image = resized;
        this.m_Width = width;
        this.m_Height = height;
    }

    public void Scale(Vector2f amount) {
        Scale((int)amount.x, (int)amount.y);
    }

    public void Render(float x, float y, Graphics g3d) {
        Graphics2D g = (Graphics2D) g3d;
        g.drawImage(m_Image, AffineTransform.getTranslateInstance(x, y), null);
    }

    private BufferedImage LoadImage(String filepath) {
        BufferedImage img = null;

        try{
            img = ImageIO.read(new File("res/assets/"+filepath));

            m_Width = img.getWidth();
            m_Height = img.getHeight();
            m_Type = img.getType();

        }catch (Exception e){
            e.printStackTrace();
        }

        return img;
    }

    public int GetHeight() {
        return m_Height;
    }

    public int GetWidth() {
        return m_Width;
    }

    public BufferedImage GetImage() {
        return m_Image;
    }

    protected void SetImage(BufferedImage image) {
        this.m_Image = image;
    }
}
