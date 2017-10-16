package ruben.jpixel.engine.graphics;

import ruben.jpixel.engine.math.Vec2;

public interface IDrawable {

    int[] getPixel();
    int getWidth();
    int getHeight();

    void setPixel(int location, int colour);
}
