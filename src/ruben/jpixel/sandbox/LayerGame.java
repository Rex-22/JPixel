package ruben.jpixel.sandbox;

import ruben.jpixel.engine.graphics.Layer;
import ruben.jpixel.engine.level.Level;

public class LayerGame extends Layer {

    public LayerGame() {

        EntityPlayer player = new EntityPlayer("player");
        Level level = new Level("level", player);

        player.getPosition().set(level.getSpawnLocation());

        level.add(player);
        add(level);
    }

}
