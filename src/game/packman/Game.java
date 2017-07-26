package game.packman;

public class Game extends GameComponent {

    @Override
    public void Init() {
        TestLayer layer = new TestLayer();
        OtherLayer layer2 = new OtherLayer();
        layer2.SetRenderOrder(1);

        Add(layer2);
        Add(layer);
    }

}
