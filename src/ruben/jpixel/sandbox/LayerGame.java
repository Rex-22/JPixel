package ruben.jpixel.sandbox;

import ruben.jpixel.engine.component.CameraFollowComponent;
import ruben.jpixel.engine.component.MoveComponent;
import ruben.jpixel.engine.entity.Entity;
import ruben.jpixel.engine.graphics.Bitmap;
import ruben.jpixel.engine.graphics.Layer;
import ruben.jpixel.engine.math.Vec2;

public class LayerGame extends Layer {

    Entity player;
    Entity player2;

    public LayerGame() {
        Bitmap player_sprite = new Bitmap("sprites/player.png");
        Bitmap player_sprite2 = new Bitmap("sprites/player.png");

        player = new Entity(new Vec2(), player_sprite);

        player2 = new Entity(new Vec2(), player_sprite2);

        player.add(new MoveComponent(3));
        player.add(new CameraFollowComponent(camera));

        add(player2);
        add(player);
    }

}
