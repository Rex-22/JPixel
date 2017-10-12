package engine.core.event;

import engine.core.event.types.KeyPressedEvent;
import engine.core.event.types.KeyReleasedEvent;

public interface IKeyEvent {

    void OnKeyPressedEvent(KeyPressedEvent event);
    void OnKeyReleasedEvent(KeyReleasedEvent event);

}
