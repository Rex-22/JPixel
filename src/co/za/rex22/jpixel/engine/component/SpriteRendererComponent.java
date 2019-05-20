package co.za.rex22.jpixel.engine.component;

import co.za.rex22.jpixel.engine.graphics.Bitmap;
import co.za.rex22.jpixel.engine.graphics.Screen;

public class SpriteRendererComponent extends Component{

    private Bitmap sprite;

    public SpriteRendererComponent(Bitmap sprite) {
        this.sprite = sprite;
    }


    @Override
    public void render(Screen screen) {
        screen.draw(parent.getPosition().x, parent.getPosition().y, sprite);
    }
}
