package sandbox;

import engine.components.CameraFollowComponent;
import engine.components.SimpleMoveComponent;
import engine.core.Entity;
import engine.core.Transform;
import engine.gfx.GameLayer;
import engine.gfx.Sprite;
import engine.gfx.SpriteSheet;

public class TestLayer extends GameLayer {

    private Entity entity;

    @Override
	public void OnInit() {
	    SpriteSheet sheet = new SpriteSheet("spritesheet/spritesheet.png", 16);
		Sprite sprite = new Sprite(("player/player.png"));
        Sprite sprite1 = new Sprite(sheet, 3, 0);

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
