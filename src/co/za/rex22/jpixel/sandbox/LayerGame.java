package co.za.rex22.jpixel.sandbox;

import co.za.rex22.jpixel.engine.graphics.Layer;
import co.za.rex22.jpixel.engine.level.Level;

public class LayerGame extends Layer {

    public LayerGame() {

        EntityPlayer player = new EntityPlayer("player");
        Level level = new Level("level", player);

        player.getPosition().set(level.getSpawnLocation());

        level.add(player);
        add(level);
    }

}
