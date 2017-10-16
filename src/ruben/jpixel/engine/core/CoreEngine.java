package ruben.jpixel.engine.core;

import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.input.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class CoreEngine extends Canvas{

    public static int WIDTH = 300;
    public static int HEIGHT = WIDTH / 16 * 9;
    public static int SCALE = 3;

    private boolean isRunning = false;
    private IGame game;
    private Input input;

    private JFrame frame;
    private String title;

    private Screen screen;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

    public CoreEngine(String title, IGame game){
        this.title = title;
        Dimension d = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        frame = new JFrame(title);
        frame.setSize(d);
        frame.setResizable(false);
        frame.setMinimumSize(d);
        frame.setMaximumSize(d);
        frame.setPreferredSize(d);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        input = new Input();

        addKeyListener(input);

        frame.add(this);

        this.game = game;
    }

    public void start(){
        init();

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        requestFocus();

        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " ups, " + frames + " fps");
                frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
                updates = 0;
                frames = 0;
            }
        }

    }

    private void init(){
        isRunning = true;
        screen = new Screen(WIDTH, HEIGHT, game.getCamera());

        game.init();
    }

    private void update(){
        game.update();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(new Color(0x4c4c4c));
        g.fillRect(0, 0, getWidth(), getHeight());

        screen.clear();
        game.render(screen);

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        g.dispose();
        bs.show();
    }

    public int getWidth() {
        return WIDTH * SCALE;
    }

    public int getHeight() {
        return HEIGHT * SCALE;
    }
}
