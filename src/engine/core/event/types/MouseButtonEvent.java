package engine.core.event.types;

import engine.core.event.Event;

public class MouseButtonEvent extends MouseEvent {

	protected int m_Button;
	protected int screenX, screenY;
	
	public MouseButtonEvent(int button, int x, int y, int screenX, int screenY, Event.Type type) {
		super(x, y, type);
		this.m_Button = button;
		this.x = x;
		this.y = y;
		this.screenX = screenX;
		this.screenY = screenY;
	}

	public int GetButton() {
		return m_Button;
	}

	public int GetX() {
		return x;
	}

	public int GetY() {
		return y;
	}

    public int GetScreenX() {
        return screenX;
    }

    public int GetScreenY() {
        return screenY;
    }
}
