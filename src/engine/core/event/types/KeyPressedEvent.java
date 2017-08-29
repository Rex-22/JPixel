package engine.core.event.types;

public class KeyPressedEvent extends KeyEvent {

    public KeyPressedEvent(int key) {
        super(key, Type.KEY_PRESSED);
    }

}
