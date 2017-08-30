package sandbox;

import engine.core.Scene;
import engine.core.event.Event;
import engine.core.event.types.KeyEvent;
import engine.core.event.types.KeyPressedEvent;
import engine.gfx.GameLayer;
import engine.gfx.GuiLayer;
import engine.gfx.Window;

import java.awt.*;

public class Game extends Scene {

	@Override
	public void OnInit() {
        GuiLayer guiLayer = new TestUI();
		GameLayer gameLayer = new TestLayer();

		Add(guiLayer);
		Add(gameLayer);
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
