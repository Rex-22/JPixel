package sandbox;

import engine.core.CoreEngine;

public class Sandbox {
	
	public Sandbox() {
		CoreEngine engine = new CoreEngine();

		engine.SetScene(new Game());

		engine.Start();
	}
	
    /**
     * MAIN METHOD
     */
    public static void main(String args[]) {
        new Sandbox();
    }
}
