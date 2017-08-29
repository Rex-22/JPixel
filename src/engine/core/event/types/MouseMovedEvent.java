package engine.core.event.types;


import engine.core.event.Event;

public class MouseMovedEvent extends Event {

	private int x, y;
	private boolean m_Dragged;
	
	public MouseMovedEvent(int x, int y, boolean dragged) {
		super(Event.Type.MOUSE_MOVED);
		this.x = x;
		this.y = y;
		this.m_Dragged = dragged;
	}

	public int GetX() {
		return x;
	}

	public int GetY() {
		return y;
	}

	public boolean GetDragged() {
		return m_Dragged;
	}
	
}
