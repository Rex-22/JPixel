package sandbox;

import engine.core.Scene;

public class Game extends Scene {

	@Override
	public void Init() {
		TestLayer layer1 = new TestLayer();

		Add(layer1);
	}

}
