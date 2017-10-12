package sandbox;

import engine.components.CameraFollowComponent;
import engine.components.EntityRenderComponent;
import engine.components.SimpleMoveComponent;
import engine.core.Entity;
import engine.core.Transform;
import engine.gfx.GameLayer;
import engine.gfx.Sprite;
import engine.gfx.SpriteSheet;

public class TestLayer extends GameLayer {

    private Entity player;

    @Override
	public void OnInit() {
        //Texture Atlas
	    SpriteSheet sheet = new SpriteSheet("spritesheet/spritesheet.png", 16);

	    //Texture form arlas
		Sprite sprite = new Sprite(("player/player.png"));  //Player texture
        Sprite sprite1 = new Sprite(sheet, 3, 0);           //Tile Texture

        //Generate world
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                Add(new TestTile(new Transform(x, y), sprite1));
            }
        }

        //Create controllable player
        player = new TestEntity(new Transform(), sprite);
        player.AddComponent(new SimpleMoveComponent());
        player.AddComponent(new CameraFollowComponent(GetCamera()));
        player.GetComponent(EntityRenderComponent.class).SetRenderBoundingBox(false);

        //add the player to the world
		Add(player);
    }

}
