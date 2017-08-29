package engine.core.event.types;

import engine.core.event.Event;

public class KeyEvent extends Event {

    private int m_Key;

    public KeyEvent(int key, Type type) {
        super(type);
        this.m_Key = key;
    }

    public int GetKey(){
        return m_Key;
    }

}
