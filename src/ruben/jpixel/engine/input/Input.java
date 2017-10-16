package ruben.jpixel.engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    private static boolean[] keys = new boolean[65536];

    @Override
    public void keyTyped(KeyEvent e) {
//        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public static boolean isKeyDown(int key){
        return keys[key];
    }
}
