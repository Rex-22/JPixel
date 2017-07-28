package game.pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Pacman extends Canvas implements Runnable {

    private Thread thread;
    private JFrame window;
    private Graphics g;
    private BufferStrategy bs;
    private boolean running = false;
    public static int width;
    public static int height;

    private GameComponent game;

    public Pacman() {
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

        game = new Game();

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

        game.Init();
    }

    private void Render() {
        bs = getBufferStrategy();
        g = bs.getDrawGraphics();

        ClearScreen();

        game.Render(g);

        g.dispose();
        bs.show();
    }

    private void ClearScreen() {
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void Update() {
        game.Update();
    }

    /**
     * MAIN METHOD
     */
    public static void main(String args[]) {
        new Pacman();
    }
}
