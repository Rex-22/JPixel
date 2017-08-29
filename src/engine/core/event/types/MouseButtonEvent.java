package engine.core.event.types;

import engine.core.event.Event;

public class MouseButtonEvent extends Event { 

	protected int m_Button;
	protected int x, y;
	
	public MouseButtonEvent(int button, int x, int y, Event.Type type) {
		super(type);
		this.m_Button = button;
		this.x = x;
		this.y = y;
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
	
}
