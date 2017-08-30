package engine.core.event.types;

import engine.core.event.Event;

public class MousePressedEvent extends MouseButtonEvent {

	public MousePressedEvent(int button, int x, int y, int screenX, int screenY) {
		super(button, x, y, screenX, screenY, Event.Type.MOUSE_PRESSED);
	}

}
