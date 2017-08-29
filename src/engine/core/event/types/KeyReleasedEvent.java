package engine.core.event.types;

public class KeyReleasedEvent extends KeyEvent {

    public KeyReleasedEvent(int key) {
        super(key, Type.KEY_RELEASED);
    }

}
