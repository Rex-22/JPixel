package game.pacman;

public class Game extends GameComponent {

    @Override
    public void Init() {
        TestLayer layer = new TestLayer();

        Add(layer);
    }

}
