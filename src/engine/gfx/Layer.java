package engine.gfx;

import engine.core.Entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Layer implements Comparable<Layer>{

    private int m_RenderOrder;
    
    private List<Entity> m_Entity;

    private static int layerCount = 0;

    private String name;

    protected Layer(int renderOrder){
        m_RenderOrder = renderOrder;
        m_Entity = new ArrayList<>();
        layerCount++;

        name = "Layer " + layerCount;
    }

    protected Layer(){ this(0); }

    public abstract void Init();

    public void Draw(Graphics g) {
    	for (Entity entity: m_Entity) {
			entity.MasterRender(g);
		}
    }

    public void Update() {
        for (Entity entity: m_Entity) {
            entity.MasterUpdate();
        }
    }

    public void SetRenderOrder(int renderOrder){
        this.m_RenderOrder = renderOrder;
    }

    public int GetRenderOrder() {
        return m_RenderOrder;
    }
    
    public void Add(Entity entity) {
    	m_Entity.add(entity);
    }

    public void Add(Entity... entities){
        for (Entity entity: entities) {
            Add(entity);
        }
    }

    @Override
    public int compareTo(Layer o) {
       int renderOrder = ((Layer) o).GetRenderOrder();

        return m_RenderOrder - renderOrder;
    }

    @Override
    public String toString() {
        return name;
    }
}
