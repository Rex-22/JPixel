package engine.core;

import engine.core.event.Event;
import engine.core.event.EventListener;
import engine.gfx.Layer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Scene implements EventListener{

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

    public void OnEvent(Event event){
        for (Layer layer : m_LayerStack) {
            layer.OnEvent(event);
        }
    }

    public void Add(Layer... layers){
        for (Layer l : layers) {
            Add(l);
        }
    }

    public void OnRender(Graphics g){
        for (Layer layer : m_LayerStack) {
            layer.OnRender(g);
        }
    }

    public void OnUpdate(float delta){
        for (Layer layer : m_LayerStack) {
            layer.OnUpdate(delta);
        }
    }

}
