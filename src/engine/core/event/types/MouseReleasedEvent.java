package engine.core.event.types;

import engine.core.event.Event;

public class MouseReleasedEvent extends MouseButtonEvent {

	public MouseReleasedEvent(int button, int x, int y, int screenX, int screenY) {
		super(button, x, y, screenX, screenY, Event.Type.MOUSE_RELEASED);
	}
	
}
