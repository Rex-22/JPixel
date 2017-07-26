package game.packman;

import game.packman.gfx.Layer;

import java.awt.*;

public class OtherLayer extends Layer {

    @Override
    public void Render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(5, 5, 40, 40);
    }
}
