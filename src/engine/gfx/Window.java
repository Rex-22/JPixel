package engine.gfx;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window {

    private JFrame m_Window;
    private int m_Width;
    private int m_Height;

    private Canvas m_Canvas;
    private Graphics g;
    private BufferStrategy bs;

    private String m_Title;

    public Window(String title, int width, int height){
        this.m_Width = width;
        this.m_Height = height;
        this.m_Title = title;

        m_Window = new JFrame(title);
        m_Canvas = new Canvas();

        CreateWindow();
    }

    private void CreateWindow(){
        m_Window.setSize(m_Width, m_Height);
        m_Window.setLocationRelativeTo(null);
        m_Window.setResizable(false);
        m_Window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        m_Window.add(m_Canvas);

        m_Window.setVisible(true);

        m_Canvas.createBufferStrategy(3);
    }

    public void Render(){
        g.dispose();
        bs.show();
    }

    public void Update(){}

    public Graphics GetGraphics() {
        bs = m_Canvas.getBufferStrategy();
        g = bs.getDrawGraphics();

        g.fillRect(0, 0, m_Width, m_Height);

        return g;
    }

    public Canvas GetHandler() {
        return m_Canvas;
    }
}
