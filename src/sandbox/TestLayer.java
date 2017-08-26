package sandbox;

import engine.core.Entity;
import engine.core.Transform;
import engine.gfx.Layer;
import engine.gfx.Sprite;
import engine.gfx.SpriteSheet;

public class TestLayer extends Layer {

	@Override
	public void Init() {
	    SpriteSheet sheet = new SpriteSheet("spritesheet/spritesheet.png", 16);
		Sprite sprite = new Sprite(sheet, 0, 0);

		Entity entity = new TestEntity(new Transform(), sprite);

		Add(entity);
    }
	
}
