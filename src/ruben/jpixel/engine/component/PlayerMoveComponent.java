package ruben.jpixel.engine.component;

import ruben.jpixel.engine.entity.Entity;
import ruben.jpixel.engine.input.Input;
import ruben.jpixel.engine.math.Vec2;
import ruben.jpixel.engine.tile.Tile;
import ruben.jpixel.engine.tile.TileLava;
import ruben.jpixel.sandbox.EntityPlayer;

import java.awt.event.KeyEvent;

public class PlayerMoveComponent extends Component {

    private int speed = 3;

    private boolean UP = false;
    private boolean DOWN = false;
    private boolean LEFT = false;
    private boolean RIGHT = false;
    private boolean SPRINT = false;

    private EntityPlayer player;
    private boolean walking = false;

    public PlayerMoveComponent(EntityPlayer player) {
        this.player = player;
    }

    @Override
    public void update() {
        int xa = 0, ya = 0;

        UP = Input.isKeyDown(KeyEvent.VK_W) || Input.isKeyDown(KeyEvent.VK_UP);
        DOWN = Input.isKeyDown(KeyEvent.VK_S) || Input.isKeyDown(KeyEvent.VK_DOWN);
        LEFT = Input.isKeyDown(KeyEvent.VK_A) || Input.isKeyDown(KeyEvent.VK_LEFT);
        RIGHT = Input.isKeyDown(KeyEvent.VK_D) || Input.isKeyDown(KeyEvent.VK_RIGHT);

        if (walking) player.animSprite.update();
        else player.animSprite.setFrame(0);

        if (UP) {
            ya -= speed;
            player.setSprite(player.up);
        }
        if (DOWN) {
            ya += speed;
            player.setSprite(player.down);
        }
        if (LEFT) {
            xa -= speed;
            player.setSprite(player.left);
        }
        if (RIGHT) {
            xa += speed;
            player.setSprite(player.right);
        }

        if (xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }

        collision(0, 0);
    }

    private void move(int xa, int ya) {
        if (xa != 0 && ya != 0) {
            move(xa, 0);
            move(0, ya);
            return;
        }

        if (!collision(xa, ya)) {
            parent.getPosition().addLocal(new Vec2(xa, ya));
        }

    }

    private boolean collision(int xa, int ya) {
        boolean solid = false;

        int x = parent.getPosition().x;
        int y = parent.getPosition().y;

        for (int c = 0; c < 4; c++) {
            int xt = ((x + xa) + c % 2 * 6 + 12) / Tile.SIZE;
            int yt = ((y + ya) + c / 2 * 16 + 14) / Tile.SIZE;
            onCollideWith(parent.getLevel().getTile(xt, yt));
            onCollideWith(parent.getLevel().getEntity(xt, yt));
            if (parent.getLevel().getTile(xt, yt).isSolid()) solid = true;
        }

        return solid;
    }

    private void onCollideWith(Tile tile) {
        if (tile instanceof TileLava) {
            player.takeDamage();
        } else {
            player.negateDamage();
        }
    }

    private void onCollideWith(Entity entity) {
        if (entity!= null) {
            if (entity.getName().equals("coin")) {
//                entity.setEnabled(false);
                System.out.println("got it!");
            }
        }
    }

}
