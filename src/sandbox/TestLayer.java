package sandbox;

import engine.components.PixelRenderer;
import engine.core.Entity;
import engine.core.Tile;
import engine.core.Transform;
import engine.gfx.Layer;
import engine.gfx.Sprite;
import engine.gfx.SpriteSheet;

public class TestLayer extends Layer {

    private Entity entity;
    private Tile tile;


    @Override
	public void Init() {
	    SpriteSheet sheet = new SpriteSheet("spritesheet/spritesheet.png", 16);
		Sprite sprite = new Sprite(sheet, 0, 0);
        Sprite sprite1 = new Sprite(0xff00ff);

        tile = new TestTile(new Transform(), sprite1);
        entity = new TestEntity(new Transform(), sprite);


		Add(entity);
		Add(tile);
    }

    @Override
    public void Update() {
        tile.SetPosition(1, 1);
    }
}
