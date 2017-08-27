package engine.gfx;

import engine.core.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Layer implements Comparable<Layer>{

    private int m_RenderOrder;
    
    private List<GameObject> m_GameObjects;

    private static int s_layerCount = 0;

    private String m_Name;

    protected Layer(int renderOrder){
        m_RenderOrder = renderOrder;
        m_GameObjects = new ArrayList<>();
        s_layerCount++;

        m_Name = "Layer " + s_layerCount;
    }

    protected Layer(){ this(0); }

    public abstract void Init();

    public void Render(Graphics g) {
    	for (GameObject object: m_GameObjects) {
            object.MasterRender(g);
		}
    }

    public void Update() {
        for (GameObject object: m_GameObjects) {
            object.MasterUpdate();
        }
    }

    public void SetRenderOrder(int renderOrder){
        this.m_RenderOrder = renderOrder;
    }

    public int GetRenderOrder() {
        return m_RenderOrder;
    }
    
    public void Add(GameObject object) {
    	m_GameObjects.add(object);
    }

    public void Add(GameObject... objects){
        for (GameObject object: objects) {
            Add(object);
        }
    }

    @Override
    public int compareTo(Layer o) {
       int renderOrder = o.GetRenderOrder();

        return m_RenderOrder - renderOrder;
    }

    @Override
    public String toString() {
        return m_Name;
    }
}
