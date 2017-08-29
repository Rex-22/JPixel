package engine.components;

import engine.core.event.Event;
import engine.core.event.types.KeyEvent;
import engine.core.event.types.KeyPressedEvent;
import engine.core.event.types.KeyReleasedEvent;
import org.joml.Vector2f;

public class SimpleMoveComponent extends Component {

    private float m_Speed;
    //A modifier for the normal speed
    private float m_SprintSpeed;

    private boolean FORWARD = false,
            BACK = false,
            LEFT = false,
            RIGHT = false,
            SPRINT = false;

    private final int KEYS[] = new int[]{
            KeyEvent.KEY_W,
            KeyEvent.KEY_S,
            KeyEvent.KEY_A,
            KeyEvent.KEY_D
    };

    public SimpleMoveComponent(float speed, float sprintSpeed) {
        this.m_Speed = speed;
        this.m_SprintSpeed = sprintSpeed;
    }


    public SimpleMoveComponent(float speed){
        this(speed, 2.5f);
    }

    public SimpleMoveComponent(){
        this(50.0f);
    }

    @Override
    public void OnEvent(Event event) {
        if (event.GetType() == Event.Type.KEY_PRESSED) {
            KeyEvent((KeyPressedEvent) event);
        } else if (event.GetType() == Event.Type.KEY_RELEASED)
            KeyEvent((KeyReleasedEvent) event);

    }

    private void KeyEvent(KeyPressedEvent event) {
        if (event.GetKey() == KEYS[0]) FORWARD = true;
        if (event.GetKey() == KEYS[1]) BACK = true;
        if (event.GetKey() == KEYS[2]) LEFT = true;
        if (event.GetKey() == KEYS[3]) RIGHT = true;

        if (event.GetKey() == KeyEvent.KEY_SHIFT) SPRINT = true;
    }

    private void KeyEvent(KeyReleasedEvent event) {
        if (event.GetKey() == KEYS[0]) FORWARD = false;
        if (event.GetKey() == KEYS[1]) BACK = false;
        if (event.GetKey() == KEYS[2]) LEFT = false;
        if (event.GetKey() == KEYS[3]) RIGHT = false;

        if (event.GetKey() == KeyEvent.KEY_SHIFT) SPRINT = false;
    }

    @Override
    public void OnUpdate(float delta) {
        Vector2f velocity = new Vector2f(0, 0);

        if (FORWARD) velocity.y -= 1;
        if (BACK) velocity.y += 1;
        if (LEFT) velocity.x -= 1;
        if (RIGHT) velocity.x += 1;

        if (SPRINT)
            Move(velocity.mul((m_Speed * m_SprintSpeed) * delta));
        else
            Move(velocity.mul(m_Speed * delta));
    }

    private void Move(Vector2f moveAmt) {
        m_Parent.GetTransform().GetPosition().add(moveAmt);
    }


    public boolean IsSprinting() {
        return SPRINT;
    }
}
