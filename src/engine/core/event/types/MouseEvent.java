package engine.core.event.types;

import engine.core.event.Event;

public class MouseEvent extends Event {

    protected int x, y;

    public MouseEvent(int x, int y, Type type) {
        super(type);
        this.x = x;
        this.y = y;
    }

    public int GetY() {
        return y;
    }

    public int GetX() {
        return x;
    }
}
