package co.za.rex22.jpixel.sandbox;

import co.za.rex22.jpixel.engine.core.BasicGame;

public class Game extends BasicGame {


    public Game() {
        super("Bobs adventure");
    }

    @Override
    public void init() {
        LayerGame game = new LayerGame();

        add(game);
    }

    public static void main(String[] args) {
        new Game();
    }
}
