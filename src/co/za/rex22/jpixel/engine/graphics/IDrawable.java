package co.za.rex22.jpixel.engine.graphics;

public interface IDrawable {

    int[] getPixel();
    int getWidth();
    int getHeight();

    void setPixel(int location, int colour);
}
