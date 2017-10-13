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
import sandbox.entity.EntityPlayer;
import sandbox.tile.TileTest;

public class LayerTest extends GameLayer {

    //This stores the player. The player can be anything but it must be a entity
    private Entity player;

    private EntityCoin coin;

    @Override
	public void OnInit() {
        //Texture Atlas
	    SpriteSheet sheet = new SpriteSheet("spritesheet/spritesheet.png", 16);

	    //Texture form atlas
		Sprite sprite = new Sprite(("player/player.png"));      //Player texture
        Sprite sprite1 = new Sprite(sheet, 3, 0);   //Tile Texture

        //Generate world
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                Add(new TileTest(new Transform(x, y), sprite1));
            }
        }

        //Create controllable player
        player = new EntityPlayer(new Transform(), sprite);
        player.AddComponent(new SimpleMoveComponent());
        player.AddComponent(new CameraFollowComponent(GetCamera()));
        player.GetComponent(EntityRenderComponent.class).SetRenderBoundingBox(true);

        coin = new EntityCoin(new Transform(4,4));
        coin.GetComponent(EntityRenderComponent.class).SetRenderBoundingBox(true);
        coin.SetGridAligned(true);

        //Add the player to the world
		Add(player);

		Add(coin);
    }

    @Override
    public void OnUpdate(float delta) {
        super.OnUpdate(delta);

        System.out.println("Player X: " + player.GetBoundingBox().x + "| Y: " + player.GetBoundingBox().y);
        System.out.println("Coin X: " + coin.GetBoundingBox().x + "| Y: " + coin.GetBoundingBox().y);

        if (player.GetBoundingBox().contains(coin.GetBoundingBox())){
            System.out.println("Pick up!");
        }
    }
}
