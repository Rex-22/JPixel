package ruben.jpixel.sandbox;

import ruben.jpixel.engine.component.CameraFollowComponent;
import ruben.jpixel.engine.component.MoveComponent;
import ruben.jpixel.engine.entity.Entity;
import ruben.jpixel.engine.graphics.Bitmap;
import ruben.jpixel.engine.graphics.Layer;
import ruben.jpixel.engine.math.Vec2;
import ruben.jpixel.engine.tile.Tile;

public class LayerGame extends Layer {

    Entity player;

    public LayerGame() {
        Bitmap player_sprite = new Bitmap("sprites/player.png");
        player = new Entity(new Vec2(), player_sprite);

        player.add(new MoveComponent(3));
        player.add(new CameraFollowComponent(camera));

        add(player);
    }

}
