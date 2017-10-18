package ruben.jpixel.engine.component;

import ruben.jpixel.engine.graphics.Bitmap;
import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.graphics.Sprite;

public class SpriteRendererComponent extends Component {

    private Sprite sprite;

    public SpriteRendererComponent(Sprite sprite) {
        this.sprite = sprite;
    }


    @Override
    public void render(Screen screen) {
        screen.draw(parent.getPosition().x, parent.getPosition().y, sprite);
    }
}
