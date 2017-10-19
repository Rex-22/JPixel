package ruben.jpixel.engine.core;

import ruben.jpixel.engine.graphics.Screen;
import ruben.jpixel.engine.input.Input;
import ruben.jpixel.engine.level.Level;
import ruben.jpixel.sandbox.EntityPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class CoreEngine extends Canvas{

    public static int WIDTH = 300;
    public static int HEIGHT = WIDTH / 16 * 9;
    public static int SCALE = 3;
    public static boolean WIN = false;
    public static boolean LOSS = false;

    private boolean isRunning = false;
    private IGame game;
    private Input input;

    private JFrame frame;
    private String title;

    private int timer = 60 * 121;

    private double frameTime;

    private Screen screen;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    private boolean LOSS_TIME = false;

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

        frameTime = 1.0/60;
    }

    public void start(){
        int frames = 0;
        double frameCounter = 0;

        init();

        double lastTime = Time.getTime();
        double unprocessedTime = 0;

        requestFocus();

        while (isRunning) {
            if (!WIN && !LOSS) {
                boolean render = false;

                double startTime = Time.getTime();
                double passedTime = startTime - lastTime;
                lastTime = startTime;

                unprocessedTime += passedTime;
                frameCounter += passedTime;

                while (unprocessedTime > frameTime) {
                    render = true;
                    unprocessedTime -= frameTime;

                    update((float) frameTime);
                    if (frameCounter >= 1.0) {
                        System.out.println(frames);
                        frames = 0;
                        frameCounter = 0;
                    }
                }
                if (render) {
                    render();
                    frames++;
                } else {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                render();
            }
        }
    }

    private void init(){
        isRunning = true;
        screen = new Screen(WIDTH, HEIGHT, game.getCamera());

        game.init();
    }

    private void update(float delta){
        game.update(delta);
    }

    private void render(){
        timer--;
        if (timer <= 0) {
            timer = 0;
            LOSS_TIME = true;
        }
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(new Color(0x4c4c4c));
        g.fillRect(0, 0, getWidth(), getHeight());

        if (LOSS != true && WIN != true && LOSS_TIME != true) {
            screen.clear();
            game.render(screen);

            for (int i = 0; i < pixels.length; i++) {
                pixels[i] = screen.pixels[i];
            }

            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

            {
                Font font = new Font("Verdan", Font.BOLD, 40);
                g.setColor(Color.GREEN);
                g.setFont(font);
                g.drawString("Timer: " + timer / 60, 0, 50);
                g.drawString("Coins remaining: " + Level.totalCoins, 0, 100);
                g.drawString("Lives: " + EntityPlayer.lives, 0, 150);
            }
        }else{
            for (int i = 0; i < pixels.length; i++) {
                pixels[i] = screen.pixels[i];
            }

            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

            {
                Font font = new Font("Verdan", Font.BOLD, 40);
                g.setColor(Color.GREEN);
                g.setFont(font);
                g.drawString("Timer: " + timer / 60, 0, 50);
                g.drawString("Coins remaining: " + Level.totalCoins, 0, 100);
                g.drawString("Lives: " + EntityPlayer.lives, 0, 150);
            }

            if (WIN){
                timer = timer + 1;

                screen.clear();
                game.render(screen);

                for (int i = 0; i < pixels.length; i++) {
                    pixels[i] = screen.pixels[i];
                }

                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);


                {
                    Font font = new Font("Verdan", Font.BOLD, 40);
                    g.setColor(Color.GREEN);
                    g.setFont(font);
                    g.drawString("Timer: " + timer / 60, 0, 50);
                    g.drawString("Coins remaining: " + Level.totalCoins, 0, 100);
                    g.drawString("Lives: " + EntityPlayer.lives, 0, 150);
                }

                Font font = new Font("Verdan", Font.BOLD, 40);
                g.setColor(Color.BLUE);
                g.setFont(font);
                g.drawString("YOU WIN!", (getWidth() / 2) - 50, getHeight()/ 2);
            }

            if (LOSS_TIME){
                Font font = new Font("Verdan", Font.BOLD, 40);
                g.setColor(Color.RED);
                g.setFont(font);
                g.drawString("TIME RAN OUT!", (getWidth() / 2) - 100, getHeight()/ 2);
            }

            if (LOSS){
                timer = timer + 1;
                Font font = new Font("Verdan", Font.BOLD, 40);
                g.setColor(Color.RED);
                g.setFont(font);
                g.drawString("YOU DIED!", (getWidth() / 2) - 100, getHeight()/ 2);
            }

        }
        game.render(g);

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
