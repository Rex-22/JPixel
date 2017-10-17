package ruben.jpixel.engine.component;

import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.input.Input;
import ruben.jpixel.engine.math.MathUtils;
import ruben.jpixel.engine.math.Vec2;

import java.awt.event.KeyEvent;

public class MoveComponent extends Component {

    private int speed;
    private int sprint_speed;

    private boolean UP = false;
    private boolean DOWN = false;
    private boolean LEFT = false;
    private boolean RIGHT = false;
    private boolean SPRINT = false;

    public MoveComponent(int speed, int sprint_speed) {
        this.speed = MathUtils.clamp(speed, 1, 3);
        this.sprint_speed = MathUtils.clamp(speed, 3, 5);
    }

    public MoveComponent(int speed){
        this(speed, 2);
    }

    @Override
    public void update() {
        int xa = 0, ya = 0;

       UP = Input.isKeyDown(KeyEvent.VK_W) || Input.isKeyDown(KeyEvent.VK_UP);
       DOWN = Input.isKeyDown(KeyEvent.VK_S) || Input.isKeyDown(KeyEvent.VK_DOWN);
       LEFT = Input.isKeyDown(KeyEvent.VK_A) || Input.isKeyDown(KeyEvent.VK_LEFT);
       RIGHT = Input.isKeyDown(KeyEvent.VK_D) || Input.isKeyDown(KeyEvent.VK_RIGHT);

       SPRINT = Input.isKeyDown(KeyEvent.VK_SHIFT);

       if (UP) ya -= speed + (SPRINT ? sprint_speed : 0);
       if (DOWN) ya += speed + (SPRINT ? sprint_speed : 0);
       if (LEFT) xa -= speed + (SPRINT ? sprint_speed : 0);
       if (RIGHT) xa += speed + (SPRINT ? sprint_speed : 0);

       move(xa, ya);
    }

    private void move(int xa, int ya){
        parent.getPosition().addLocal(new Vec2(xa, ya));
    }
}
