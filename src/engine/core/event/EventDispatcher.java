package engine.core.event;

public class EventDispatcher {

	private Event m_Event;
	
	public EventDispatcher(Event event) {
		this.m_Event = event;
	}
	
	public void Dispatch(Event.Type type, EventHandler handler) {
		if (m_Event.m_Handled)
			return;
		
		if (m_Event.GetType() == type)
			m_Event.m_Handled = handler.OnEvent(m_Event);
	}
	
}
