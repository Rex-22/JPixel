package engine.core;

import sandbox.Game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class CoreEngine extends Canvas implements Runnable {

    private Thread thread;
    private JFrame window;
    private Graphics g;
    private BufferStrategy bs;
    private boolean running = false;
    public static int width;
    public static int height;

    private Scene scene;

    public CoreEngine(Scene scene) {
    	this.scene = scene;
    }

    public CoreEngine(){}

    public void start() {
    	thread = new Thread(this, "Packman");
        thread.start();
    }

    @Override
    public void run() {
        width = 800;
        height = 630;
        window = new JFrame("Packman");
        window.setSize(width, height);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(this);

        window.setVisible(true);

        loop();
    }

    private void loop() {

        Init();

        while (running) {
            Update();
            Render();
        }

    }

    private void Init() {
        running = true;

        createBufferStrategy(3);

        if (scene == null){
            System.err.println("There is no scene currently active!");
            System.exit(1);
        }
        scene.Init();
    }

    private void Render() {
        bs = getBufferStrategy();
        g = bs.getDrawGraphics();

        ClearScreen();


        if (scene == null){
            System.err.println("There is no scene currently active!");
            System.exit(1);
        }
        scene.Render(g);

        g.dispose();
        bs.show();
    }

    private void ClearScreen() {
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void Update() {

        if (scene == null){
            System.err.println("There is no scene currently active!");
            System.exit(1);
        }

    	scene.Update();
    }


    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
