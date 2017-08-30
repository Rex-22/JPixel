package sandbox;

import engine.gfx.GuiLayer;
import engine.ui.UILabel;
import org.joml.Vector2i;

public class TestUI extends GuiLayer {

    @Override
    public void OnInit() {
        Add(new UILabel(new Vector2i(0, 0), "HELLO WORLD!"));
    }
}
