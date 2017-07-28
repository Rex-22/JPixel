package game.pacman;

import game.pacman.gfx.Layer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class GameComponent {

    private List<Layer> m_LayerStack;

    public GameComponent(){
        m_LayerStack = new ArrayList<>();
    }

    public abstract void Init();

    public void Add(Layer layer){
        if (!m_LayerStack.contains(layer)) {
            m_LayerStack.add(layer);
            layer.Init();
        }
        else
            System.err.println("Layer is already registered: " + layer);

        Collections.sort(m_LayerStack);
    }

    public void Render(Graphics g){
        for (Layer layer : m_LayerStack) {
            layer.Draw(g);
        }
    }

    public void Update(){
        for (Layer layer : m_LayerStack) {
            layer.Update();
        }
    }

}
