package ruben.jpixel.sandbox;

import ruben.jpixel.engine.core.BasicGame;

public class Game extends BasicGame {


    public Game() {
        super("Bobs adventure");
    }

    @Override
    public void init() {
        LayerGame layerGame = new LayerGame();
        add(layerGame);
    }

    public static void main(String[] args) {
        new Game();
    }
}
