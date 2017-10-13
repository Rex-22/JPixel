package sandbox.layer;

import engine.components.CameraFollowComponent;
import engine.components.EntityRenderComponent;
import engine.components.SimpleMoveComponent;
import engine.core.Entity;
import engine.core.Transform;
import engine.gfx.GameLayer;
import engine.gfx.Sprite;
import engine.gfx.SpriteSheet;
import sandbox.entity.EntityCoin;
import sandbox.entity.EntityTest;
import sandbox.tile.TileTest;

public class LayerTest extends GameLayer {

    private Entity player;

    @Override
	public void OnInit() {
        //Texture Atlas
	    SpriteSheet sheet = new SpriteSheet("spritesheet/spritesheet.png", 16);

	    //Texture form arlas
		Sprite sprite = new Sprite(("player/player.png"));      //Player texture
        Sprite sprite1 = new Sprite(sheet, 3, 0);   //Tile Texture

        //Generate world
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                Add(new TileTest(new Transform(x, y), sprite1));
            }
        }

        //Create controllable player
        player = new EntityTest(new Transform(), sprite);
        player.AddComponent(new SimpleMoveComponent());
        player.AddComponent(new CameraFollowComponent(GetCamera()));
        player.GetComponent(EntityRenderComponent.class).SetRenderBoundingBox(true);

        EntityCoin coin = new EntityCoin(new Transform());
        coin.GetComponent(EntityRenderComponent.class).SetEnabled(true);

        //Add the player to the world
		Add(player);

		Add(coin);
    }

}
