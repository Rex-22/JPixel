package ruben.jpixel.engine.graphics;

import ruben.jpixel.engine.entity.Entity;

public class Screen {

    private static int ALPHA_COL = 0xffff00ff;

    private int width;
    private int height;
    public int[] pixels;

    private Camera camera;

    public Screen(int width, int height, Camera camera) {
        this.width = width;
        this.height = height;

        this.pixels = new int[width * height];

        this.camera = camera;
    }

    public void draw(IDrawable drawable){
        int xp = drawable.getPosition().x - camera.getX();
        int yp = drawable.getPosition().y - camera.getY();
        for (int y = 0; y < drawable.getHeight(); y++) {
            int ya = y + yp;
            for (int x = 0; x < drawable.getWidth(); x++) {
                int xa = x + xp;
                if (xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
                int col = drawable.getPixel()[x + y * drawable.getWidth()];
                if (col != ALPHA_COL) pixels[xa + ya * width] = col;
            }
        }
    }

    public void draw(Entity entity){
        IDrawable drawable = entity.getSprite();

        int xp = drawable.getPosition().x - camera.getX();
        int yp = drawable.getPosition().y - camera.getY();
        for (int y = 0; y < drawable.getHeight(); y++) {
            int ya = y + yp;
            for (int x = 0; x < drawable.getWidth(); x++) {
                int xa = x + xp;
                if (xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
                int col = drawable.getPixel()[x + y * drawable.getWidth()];
                if (col != ALPHA_COL) pixels[xa + ya * width] = col;
            }
        }
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void clear() {
       clear(0x4c4c4c);
    }

    public void clear(int colour) {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = colour;
        }
    }
}
