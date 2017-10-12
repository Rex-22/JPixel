package engine.core.event;

import engine.core.event.types.MouseMovedEvent;
import engine.core.event.types.MousePressedEvent;
import engine.core.event.types.MouseReleasedEvent;

public interface IMouseEvent {

  void OnMouseMovedEvent(MouseMovedEvent event);
  void OnMousePressedEvent(MousePressedEvent event);
  void OnMouseReleasedEvent(MouseReleasedEvent event);

}
