package engine.core;

import engine.core.event.Event;
import engine.core.event.types.*;
import engine.gfx.Window;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class CoreEngine implements Runnable {

    private Thread m_Thread;
    private Window m_Window;

    private boolean m_Running = false;

    private Scene m_Scene;

    public CoreEngine(Scene scene) {
    	this(800, 600, scene);
    }

    public CoreEngine(int width, int height, Scene scene) {
        this(width, height, "JEngine", scene);
    }

    public CoreEngine(int width, int height, String title, Scene scene) {
        this.m_Scene = scene;
        m_Window = new Window(title, width, height);
    }


    public CoreEngine(int width, int height, String title) {
        m_Window = new Window(title, width, height);
    }

    public CoreEngine(int width, int height) {
        this(width, height, "JEngine");
    }

    public CoreEngine() {
       this(800, 600, "JEngine");
    }

    public void Start() {
    	m_Thread = new Thread(this, "JEngine");
        m_Thread.start();
    }

    @Override
    public void run() {
        Init();

        while (m_Running) {
            Update();
            Render();
        }

    }

    private void Init() {
        m_Running = true;

        m_Window.GetHandler().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MousePressedEvent event = new MousePressedEvent(e.getButton(), e.getX(), e.getY());
                DispatchEvent(event);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                MouseReleasedEvent event = new MouseReleasedEvent(e.getButton(), e.getX(), e.getY());
                DispatchEvent(event);
            }
        });

        m_Window.GetHandler().addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                MouseMovedEvent event = new MouseMovedEvent(e.getX(), e.getY(), false);
                DispatchEvent(event);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                MouseMovedEvent event = new MouseMovedEvent(e.getX(), e.getY(), true);
                DispatchEvent(event);
            }
        });

        m_Window.GetHandler().addKeyListener(new KeyAdapter() {
             @Override
            public void keyPressed(KeyEvent e) {
                KeyPressedEvent event = new KeyPressedEvent(e.getKeyCode());
                DispatchEvent(event);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyReleasedEvent event = new KeyReleasedEvent(e.getKeyCode());
                DispatchEvent(event);
            }
        });

        if (m_Scene == null){
            System.err.println("There is no scene currently active!");
            System.exit(1);
        }
        m_Scene.Init();
    }

    private void Render() {

        if (m_Scene == null) {
            System.err.println("There is no scene currently active!");
            System.exit(1);
        }
        m_Scene.OnRender(m_Window.GetGraphics());

        m_Window.Render();
    }

    private void Update() {

        m_Window.Update();

        if (m_Scene == null){
            System.err.println("There is no m_Scene currently active!");
            System.exit(1);
        }

    	m_Scene.OnUpdate();
    }

    private void DispatchEvent(Event event){
        m_Scene.OnEvent(event);
    }


    public void SetScene(Scene scene) {
        this.m_Scene = scene;
    }
}
