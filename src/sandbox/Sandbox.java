package sandbox;

import engine.core.CoreEngine;

public class Sandbox {
	
	public Sandbox() {
		CoreEngine engine = new CoreEngine();

		engine.setScene(new Game());

		engine.start();
	}
	
    /**
     * MAIN METHOD
     */
    public static void main(String args[]) {
        new Sandbox();
    }
}
