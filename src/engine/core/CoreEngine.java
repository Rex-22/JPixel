package engine.core;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class CoreEngine extends Canvas implements Runnable {

    private Thread m_Thread;
    private JFrame m_Window;
    private Graphics g;
    private BufferStrategy bs;
    private boolean m_Running = false;
    public static int m_Width;
    public static int m_Height;

    private Scene m_Scene;

    public CoreEngine(Scene scene) {
    	this.m_Scene = scene;
    }

    public CoreEngine(){}

    public void Start() {
    	m_Thread = new Thread(this, "Packman");
        m_Thread.start();
    }

    @Override
    public void run() {
        m_Width = 800;
        m_Height = 630;
        m_Window = new JFrame("Packman");
        m_Window.setSize(m_Width, m_Height);
        m_Window.setLocationRelativeTo(null);
        m_Window.setResizable(false);
        m_Window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        m_Window.add(this);

        m_Window.setVisible(true);

        Loop();
    }

    private void Loop() {

        Init();

        while (m_Running) {
            Update();
            Render();
        }

    }

    private void Init() {
        m_Running = true;

        createBufferStrategy(3);

        if (m_Scene == null){
            System.err.println("There is no m_Scene currently active!");
            System.exit(1);
        }
        m_Scene.Init();
    }

    private void Render() {
        bs = getBufferStrategy();
        g = bs.getDrawGraphics();

        ClearScreen();


        if (m_Scene == null){
            System.err.println("There is no m_Scene currently active!");
            System.exit(1);
        }
        m_Scene.Render(g);

        g.dispose();
        bs.show();
    }

    private void ClearScreen() {
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void Update() {

        if (m_Scene == null){
            System.err.println("There is no m_Scene currently active!");
            System.exit(1);
        }

    	m_Scene.Update();
    }


    public void SetScene(Scene scene) {
        this.m_Scene = scene;
    }
}
