package engine.core.event.types;


import engine.core.event.Event;

public class MouseMovedEvent extends Event {

	private int x, y;
	private int screenX, screenY;
	private boolean m_Dragged;
	
	public MouseMovedEvent(int x, int y, int screenX, int screenY, boolean dragged) {
		super(Event.Type.MOUSE_MOVED);
		this.x = x;
		this.y = y;
		this.screenX = screenX;
		this.screenY = screenY;
		this.m_Dragged = dragged;
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

	public boolean GetDragged() {
		return m_Dragged;
	}
	
}
