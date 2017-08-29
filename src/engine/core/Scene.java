package engine.core;

import engine.core.event.Event;
import engine.core.event.EventListener;
import engine.gfx.Layer;

import java.awt.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Scene implements EventListener {

    private List<Layer> m_LayerStack;
    private CoreEngine m_Engine;
    private boolean m_Enabled = true;

    private boolean m_Initialize = false;

    public Scene() {
        m_LayerStack = new CopyOnWriteArrayList<>();
    }

    public abstract void OnInit();

    public void Add(Layer layer) {
        if (!m_LayerStack.contains(layer)) {
            m_LayerStack.add(layer);
            layer.Init();
        } else
            System.err.println("Layer is already registered: " + layer);

        Collections.sort(m_LayerStack);
    }

    public void Add(Layer... layers) {
        for (Layer l : layers) {
            Add(l);
        }
    }

    public void OnEvent(Event event) {
        for (Iterator<Layer> iterator = m_LayerStack.iterator(); iterator.hasNext(); ) {
            Layer layer = iterator.next();
            layer.OnEvent(event);
        }
    }

    public void OnRender(Graphics g) {
//        if (IsEnabled())
        for (Iterator<Layer> iterator = m_LayerStack.iterator(); iterator.hasNext(); ) {
            Layer layer = iterator.next();
            layer.OnRender(g);
        }
    }

    public void OnUpdate(float delta) {
        if (IsEnabled())
            for (Iterator<Layer> iterator = m_LayerStack.iterator(); iterator.hasNext(); ) {
                Layer layer = iterator.next();
                layer.OnUpdate(delta);
            }
    }

    public boolean IsEnabled() {
        return m_Enabled;
    }

    public void Enabled(boolean enabled) {
        this.m_Enabled = enabled;
    }

    public void SetEngine(CoreEngine m_Engine) {
        this.m_Engine = m_Engine;

        if (!m_Initialize){
            OnInit();
            m_Initialize = true;
        }
    }

    public CoreEngine GetEngine() {
        return m_Engine;
    }

    public void OnExit(){}
}
