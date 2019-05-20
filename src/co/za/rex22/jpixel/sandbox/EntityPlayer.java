package co.za.rex22.jpixel.sandbox;

import co.za.rex22.jpixel.engine.component.CameraFollowComponent;
import co.za.rex22.jpixel.engine.component.PlayerMoveComponent;
import co.za.rex22.jpixel.engine.core.CoreEngine;
import co.za.rex22.jpixel.engine.entity.Entity;
import co.za.rex22.jpixel.engine.graphics.*;
import co.za.rex22.jpixel.engine.level.Level;
import co.za.rex22.jpixel.engine.math.Vec2;

import java.awt.*;

public class EntityPlayer extends Entity {

    public AnimatedSprite down = new AnimatedSprite(SpriteSheet.player_down, 32, 32, 3);
    public AnimatedSprite up = new AnimatedSprite(SpriteSheet.player_up, 32, 32, 3);
    public AnimatedSprite left = new AnimatedSprite(SpriteSheet.player_left, 32, 32, 3);
    public AnimatedSprite right = new AnimatedSprite(SpriteSheet.player_right, 32, 32, 3);

    public AnimatedSprite animSprite = down;
    public static int lives = 3;

    private int time = 0;

    private boolean shouldTakeDamage = false;
    private String dieText;

    public EntityPlayer(String name) {
        super(name, new AnimatedSprite(SpriteSheet.player_down, 32, 32, 3));
        add(new CameraFollowComponent(Layer.getCamera()));
        add(new PlayerMoveComponent(this));
    }

    @Override
    public void updateEntity() {
        time++;
        if (time % 60 == 0) {
            if (lives <= 0){
                setEnabled(false);
                die();
                return;
            }
            if (shouldTakeDamage) {
                shouldTakeDamage = false;
                lives--;
                System.out.println(lives);
                if (lives <= 0) {
                    die();
                    return;
                }
            }
        }
    }

    private void die() {
        System.out.println("You lose");
        CoreEngine.LOSS = true;
        dieText = "YOU DIED!";
        this.setEnabled(false);
    }

    @Override
    public void renderEntity(Screen screen) {
        if (isEnabled()) {
            sprite = animSprite.getSprite();
        }else {
            sprite = new Sprite("sprites/player_dead.png");
        }
        screen.draw(getPosition().x, getPosition().y, sprite);

    }

    public void renderEntity(Graphics g) {
        Screen.drawString(new Vec2(10, 10), dieText, g);
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


    public void incScore() {
        Level.totalCoins--;
        if (Level.totalCoins == 0) {
            System.out.println("You Win");
            win();
        }
    }

    private void win() {
        CoreEngine.WIN = true;
    }
}
