package engine.gfx;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;

public class Bitmap {

    private int[] m_Pixels;
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
        m_Pixels = LoadImage(filepath);
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

        m_Pixels =  ((DataBufferInt) m_Image.getRaster().getDataBuffer()).getData();

        for (int i = 0; i < width * height; i++) {
            m_Pixels[i] = colour;
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

    public void Scale(int amount){
        Scale(amount, amount);
    }

    public void Render(int x, int y, Graphics g) {
        g.drawImage(m_Image, x, y, null);
    }

    private int[] LoadImage(String filepath) {
        int[] pixels = null;

        BufferedImage img;

        try{
            img = ImageIO.read(new File("res/assets/"+filepath));

            m_Width = img.getWidth();
            m_Height = img.getHeight();
            m_Type = img.getType();


            m_Image = img;

            pixels = new int[m_Width * m_Height];

            img.getRGB(0, 0, m_Width, m_Height, pixels, 0, m_Width);
        }catch (Exception e){
            e.printStackTrace();
        }

        return pixels;
    }

    public int GetHeight() {
        return m_Height;
    }

    public int GetWidth() {
        return m_Width;
    }

    public int GetPixel(int x, int y){
        return m_Pixels[x + y * m_Width];
    }

    public void SetPixel(int x, int y, int col) {
        m_Pixels[x + y * m_Width] = col;
    }
}
