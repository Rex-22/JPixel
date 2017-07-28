package game.packman.gfx;

import java.awt.*;

public abstract class Layer implements Comparable<Layer>{

    private int m_RenderOrder;

    protected Layer(int renderOrder){
        m_RenderOrder = renderOrder;
    }

    protected Layer(){ m_RenderOrder = 0; }

    public void Init(){}

    public void Draw(Graphics g){}

    public void Update(){}

    public void SetRenderOrder(int renderorder){
        this.m_RenderOrder = renderorder;
    }

    public int GetRenderOrder() {
        return m_RenderOrder;
    }

    @Override
    public int compareTo(Layer o) {
       int renderOrder = ((Layer) o).GetRenderOrder();

        return m_RenderOrder - renderOrder;
    }
}
