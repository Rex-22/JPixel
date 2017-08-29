package sandbox;

import engine.core.CoreEngine;
import engine.core.SceneManager;

public class Sandbox {
	
	public Sandbox() {
		CoreEngine engine = new CoreEngine();

		engine.SetScene(SceneManager.GAME);

		engine.Start();
	}
	
    /**
     * MAIN METHOD
     */
    public static void main(String args[]) {
        new Sandbox();
    }
}
