package engine.core;

import engine.gfx.Window;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

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
        m_Scene.Render(m_Window.GetGraphics());

        m_Window.Render();
    }

    private void Update() {

        m_Window.Update();

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
