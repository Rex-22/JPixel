package ruben.jpixel.engine.graphics;

import org.joml.Rectanglef;
import ruben.jpixel.engine.entity.Entity;
import ruben.jpixel.engine.math.Vec2;
import ruben.jpixel.engine.tile.Tile;

import java.awt.*;

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

    public void draw(int xpos, int ypos, IDrawable drawable){
        int xp = xpos - camera.getX();
        int yp = ypos - camera.getY();
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

        int xp = entity.getPosition().x - camera.getX();
        int yp = entity.getPosition().y - camera.getY();
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

    public void draw(Tile tile) {
        IDrawable drawable = tile.getSprite();

        int xp = tile.getPosition().x - camera.getX();
        int yp = tile.getPosition().y - camera.getY();
        for (int y = 0; y < Tile.SIZE; y++) {
            int ya = y + yp;
            for (int x = 0; x < Tile.SIZE; x++) {
                int xa = x + xp;
                if (xa < -Tile.SIZE || xa >= width || ya < 0 || ya >= height) break;
                if (xa < 0) xa = 0;
                pixels[xa + ya * width] = drawable.getPixel()[x + y * Tile.SIZE];
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

    public void drawRect(Rectangle rectangle) {
        for (int x = rectangle.x; x < rectangle.width; x++) {
            for (int y = rectangle.y; y < rectangle.height; y++) {
                pixels[x + y * width] = 0xff00ff;
            }
        }
    }

    public void drawRect(int minxa, int minya, int maxxa, int maxya) {
        for (int x = minxa; x < maxxa; x++) {
            for (int y = minya; y < maxya; y++) {
                pixels[(x - camera.getX()) + (y - camera.getY()) * width] = 0xff00ff;
            }
        }
    }

    public void drawRect(Rectanglef rect) {
        drawRect((int)rect.minX, (int)rect.minY, (int)rect.maxX, (int)rect.maxY);
    }
}
