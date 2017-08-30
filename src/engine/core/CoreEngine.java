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
    private double m_FrameTime;

    private Scene m_Scene;

    public CoreEngine(Scene scene) {
    	this(800, 600, scene);
    }

    public CoreEngine(int width, int height, Scene scene) {
        this(width, height, "JEngine", 60, scene);
    }

    public CoreEngine(int width, int height, String title, int frameRate, Scene scene) {
        this.m_Scene = scene;
        m_Window = new Window(title, width, height);
        m_FrameTime = 1.0 / frameRate;
    }


    public CoreEngine(int width, int height, String title, int frameRate) {
        m_Window = new Window(title, width, height);
        m_FrameTime = 1.0 / frameRate;
    }

    public CoreEngine(int width, int height) {
        this(width, height, "JEngine", 60);
    }

    public CoreEngine() {
       this(800, 600);
    }

    public void Start() {
    	m_Thread = new Thread(this, "JEngine");
        m_Thread.start();
    }

    @Override
    public void run() {
        m_Running = true;

        int frames = 0;
        double frameCounter = 0;

        Init();

        double lastTime = Time.GetTime();
        double unprocessedTime = 0;

        while (m_Running) {
            boolean render = false;

            double startTime = Time.GetTime();
            double passedTime = startTime - lastTime;
            lastTime = startTime;

            unprocessedTime += passedTime;
            frameCounter += passedTime;

            while (unprocessedTime > m_FrameTime) {
                render = true;

                unprocessedTime -= m_FrameTime;

                Update((float) m_FrameTime);

                if (frameCounter >= 1.0) {
                    System.out.println(frames);
                    frames = 0;
                    frameCounter = 0;
                }
            }
            if (render) {
                Render();
                frames++;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void Init() {
        m_Window.GetRenderTarget().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MousePressedEvent event = new MousePressedEvent(e.getButton(), e.getX(), e.getY(), e.getXOnScreen(), e.getYOnScreen());
                DispatchEvent(event);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                MouseReleasedEvent event = new MouseReleasedEvent(e.getButton(), e.getX(), e.getY(), e.getXOnScreen(), e.getYOnScreen());
                DispatchEvent(event);
            }
        });

        m_Window.GetRenderTarget().addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                MouseMovedEvent event = new MouseMovedEvent(e.getX(), e.getY(), e.getXOnScreen(), e.getYOnScreen(), false);
                DispatchEvent(event);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                MouseMovedEvent event = new MouseMovedEvent(e.getX(), e.getY(), e.getXOnScreen(), e.getYOnScreen(), true);
                DispatchEvent(event);
            }
        });

        m_Window.GetRenderTarget().addKeyListener(new KeyAdapter() {
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

    }

    private void Render() {

        if (m_Scene == null) {
            System.err.println("There is no scene currently active!");
            System.exit(1);
        }
        m_Scene.OnRender(m_Window.GetGraphics());

        m_Window.Render();
    }

    private void Update(float delta) {

        m_Window.Update();

        if (m_Scene == null){
            System.err.println("There is no Scene currently active!");
            System.exit(1);
        }

    	m_Scene.OnUpdate(delta);
    }

    private void DispatchEvent(Event event){
        m_Scene.OnEvent(event);
    }


    public void SetScene(Scene scene) {
        if (m_Scene != null)
            m_Scene.OnExit();

        m_Scene = scene;
        m_Scene.SetEngine(this);
    }

}
