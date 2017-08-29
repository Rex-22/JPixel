package sandbox;

import engine.core.Scene;
import engine.core.SceneManager;
import engine.core.event.Event;
import engine.core.event.types.KeyEvent;
import engine.core.event.types.KeyPressedEvent;

public class TestScene extends Scene {

    @Override
    public void OnInit() {
        System.out.println("Hi There");
    }

    @Override
    public void OnEvent(Event event) {
        if(event.GetType() == Event.Type.KEY_PRESSED) {
            if(((KeyPressedEvent) event).GetKey() == KeyEvent.KEY_T) GetEngine().SetScene(SceneManager.GAME);
        }
        super.OnEvent(event);
    }
}
