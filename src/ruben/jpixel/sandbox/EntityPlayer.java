package ruben.jpixel.sandbox;

import ruben.jpixel.engine.component.CameraFollowComponent;
import ruben.jpixel.engine.component.PlayerMoveComponent;
import ruben.jpixel.engine.entity.Entity;
import ruben.jpixel.engine.graphics.*;

public class EntityPlayer extends Entity{

    public AnimatedSprite down = new AnimatedSprite(SpriteSheet.player_down, 32, 32, 3);
    public AnimatedSprite up = new AnimatedSprite(SpriteSheet.player_up, 32, 32, 3);
    public AnimatedSprite left = new AnimatedSprite(SpriteSheet.player_left, 32, 32, 3);
    public AnimatedSprite right = new AnimatedSprite(SpriteSheet.player_right, 32, 32, 3);

   public AnimatedSprite animSprite = down;

    public EntityPlayer(String name) {
        super(name);
        add(new CameraFollowComponent(Layer.getCamera()));
        add(new PlayerMoveComponent(this));
    }

    @Override
    public void renderEntity(Screen screen) {
        Sprite sprite = animSprite.getSprite();
        screen.draw(getPosition().x, getPosition().y, sprite);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
    }

    public void setSprite(AnimatedSprite sprite) {
        this.animSprite = sprite;
    }
}
