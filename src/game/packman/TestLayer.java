package game.packman;

import game.packman.gfx.Layer;

import java.awt.*;

public class TestLayer extends Layer {

    @Override
    public void Render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 40, 40);
    }

}
