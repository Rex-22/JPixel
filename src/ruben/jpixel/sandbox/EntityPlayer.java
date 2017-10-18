package ruben.jpixel.sandbox;

import ruben.jpixel.engine.component.CameraFollowComponent;
import ruben.jpixel.engine.component.PlayerMoveComponent;
import ruben.jpixel.engine.entity.Entity;
import ruben.jpixel.engine.graphics.*;

public class EntityPlayer extends Entity {

    public AnimatedSprite down = new AnimatedSprite(SpriteSheet.player_down, 32, 32, 3);
    public AnimatedSprite up = new AnimatedSprite(SpriteSheet.player_up, 32, 32, 3);
    public AnimatedSprite left = new AnimatedSprite(SpriteSheet.player_left, 32, 32, 3);
    public AnimatedSprite right = new AnimatedSprite(SpriteSheet.player_right, 32, 32, 3);

    public AnimatedSprite animSprite = down;
    private int lives = 3;

    private int time = 0;

    private boolean shouldTakeDamage = false;

    public EntityPlayer(String name) {
        super(name, new AnimatedSprite(SpriteSheet.player_down, 32, 32, 3));
        add(new CameraFollowComponent(Layer.getCamera()));
        add(new PlayerMoveComponent(this));
    }

    @Override
    public void updateEntity() {
        time++;
        if (time % 60 == 0) {
            if (shouldTakeDamage) {
                shouldTakeDamage = false;
                lives--;
                System.out.println(lives);
                if (lives <= 0) {
                    System.out.println("You lose");
                    this.setEnabled(false);
                }
            }
        }
    }

    @Override
    public void renderEntity(Screen screen) {
        if (isEnabled()) {
            sprite = animSprite.getSprite();
        }else{
            sprite = new Sprite("sprites/player_dead.png");
        }
        screen.draw(getPosition().x, getPosition().y, sprite);
    }

    public void setSprite(AnimatedSprite sprite) {
        this.animSprite = sprite;
    }

    public void takeDamage() {
        shouldTakeDamage = true;
    }

    public void negateDamage() {
        shouldTakeDamage = false;
    }
}
