package engine.core;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import engine.gfx.Layer;

public abstract class Scene {

    private List<Layer> m_LayerStack;

    public Scene(){
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


    public void Add(Layer... layers){
        for (Layer l : layers) {
            Add(l);
        }
    }

    public void Render(Graphics g){
        for (Layer layer : m_LayerStack) {
            layer.Render(g);
        }
    }

    public void Update(){
        for (Layer layer : m_LayerStack) {
            layer.Update();
        }
    }

}
