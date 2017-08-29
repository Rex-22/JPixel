package engine.gfx;

import engine.core.Camera;
import engine.core.GameObject;
import engine.core.event.Event;
import engine.core.event.EventListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Layer implements Comparable<Layer>, EventListener {

    private int m_RenderOrder;
    private Camera m_Camera;

    private List<GameObject> m_GameObjects;

    private static int s_layerCount = 0;

    private String m_Name;

    protected Layer(int renderOrder){
       this(new Camera(0, 0), renderOrder);
    }

    protected Layer(Camera camera, int renderOrder){
        this.m_RenderOrder = renderOrder;
        this.m_Camera = camera;
        this.m_GameObjects = new ArrayList<>();
        s_layerCount++;

        this.m_Name = "Layer " + s_layerCount;
    }

    protected Layer(){
        this(0);
    }

    public abstract void Init();

    public void OnRender(Graphics g) {
    	for (GameObject object: m_GameObjects) {
            object.MasterRender(g, m_Camera);
		}
    }

    public void OnUpdate(float delta) {
        for (GameObject object: m_GameObjects) {
            object.MasterUpdate(delta);
        }
    }

    @Override
    public void OnEvent(Event event) {
        for (GameObject object: m_GameObjects) {
            object.OnEvent(event);
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

    public Camera GetCamera() {
        return m_Camera;
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
