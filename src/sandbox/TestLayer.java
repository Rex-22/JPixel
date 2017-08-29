package sandbox;

import engine.components.CameraFollowComponent;
import engine.components.SimpleMoveComponent;
import engine.core.Entity;
import engine.core.Transform;
import engine.gfx.Layer;
import engine.gfx.Sprite;
import engine.gfx.SpriteSheet;

public class TestLayer extends Layer {

    private Entity entity;

    @Override
	public void Init() {
	    SpriteSheet sheet = new SpriteSheet("spritesheet/spritesheet.png", 16);
		Sprite sprite = new Sprite(sheet, 0, 0);
        Sprite sprite1 = new Sprite(0xff00ff);

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                Add(new TestTile(new Transform(x, y), sprite1));
            }
        }

        entity = new TestEntity(new Transform(), sprite);
        entity.AddComponent(new SimpleMoveComponent());
        entity.AddComponent(new CameraFollowComponent(GetCamera()));

		Add(entity);
    }

}
