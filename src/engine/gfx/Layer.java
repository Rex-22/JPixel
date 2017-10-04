package engine.gfx;

import engine.core.Camera;
import engine.core.event.Event;
import engine.core.event.IEventListener;

import java.awt.*;

public abstract class Layer implements Comparable<Layer>, IEventListener {

    private int m_RenderOrder;
    private Camera m_Camera;

    private static int s_layerCount = 0;

    private String m_Name;

    protected Layer(int renderOrder){
       this(new Camera(0, 0), renderOrder);
    }

    protected Layer(Camera camera, int renderOrder){
        this.m_RenderOrder = renderOrder;
        this.m_Camera = camera;
        s_layerCount++;

        this.m_Name = "Layer " + s_layerCount;
    }

    protected Layer(){
        this(0);
    }

    public void OnInit() {}
    public void OnRender(Graphics g) {}
    public void OnUpdate(float delta) {}
    public void OnEvent(Event event) {}

    public void SetRenderOrder(int renderOrder){
        this.m_RenderOrder = renderOrder;
    }

    public int GetRenderOrder() {
        return m_RenderOrder;
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
