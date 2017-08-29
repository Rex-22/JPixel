package engine.core.event;

public class Event {
	
	public enum Type {
		MOUSE_PRESSED,
		MOUSE_RELEASED,
		MOUSE_MOVED,

		KEY_PRESSED,
        KEY_RELEASED,
	}
	
	private Type m_Type;
	boolean m_Handled;
	
	protected Event(Type type) {
		this.m_Type = type;
	}
	
	public Type GetType() {
		return m_Type;
	}

}
