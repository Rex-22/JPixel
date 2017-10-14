package sandbox.scene;

import engine.core.Scene;
import engine.core.event.Event;
import engine.core.event.types.KeyEvent;
import engine.core.event.types.KeyPressedEvent;
import engine.core.level.Level;
import engine.gfx.PlayerLayer;
import engine.gfx.Window;
import sandbox.layer.LayerTest;

import java.awt.*;

public class SceneGame extends Scene {

	@Override
	public void OnInit() {
		PlayerLayer playerLayer = new LayerTest();
        Level level = new Level("level_1");

        Add(level);
		Add(playerLayer);
	}

	@Override
	public void OnEvent(Event event) {
        if(event.GetType() == Event.Type.KEY_PRESSED) {
            if(((KeyPressedEvent) event).GetKey() == KeyEvent.KEY_P) Enabled(!IsEnabled());
        }
		super.OnEvent(event);
	}

    @Override
    public void OnRender(Graphics g) {
	    super.OnRender(g);
        if (!IsEnabled()){
            g.setColor(Color.CYAN);
            g.setFont(new Font("Verdan", Font.BOLD, 50));
            String GamePaused = "GAME PAUSED";
            g.drawString(GamePaused,  (Window.GetWidth() / 2) - ((GamePaused.length() * g.getFont().getSize()) / 4), (Window.GetHeight() / 2));
        }
    }
}
