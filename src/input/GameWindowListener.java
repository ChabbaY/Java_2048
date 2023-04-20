package input;

import gui.GameWindow;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindowListener implements KeyListener {
    private final GameWindow window;
    public GameWindowListener(GameWindow window) {
        this.window = window;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP, KeyEvent.VK_KP_UP, KeyEvent.VK_W -> window.up();
            case KeyEvent.VK_DOWN, KeyEvent.VK_KP_DOWN, KeyEvent.VK_S -> window.down();
            case KeyEvent.VK_LEFT, KeyEvent.VK_KP_LEFT, KeyEvent.VK_A -> window.left();
            case KeyEvent.VK_RIGHT, KeyEvent.VK_KP_RIGHT, KeyEvent.VK_D -> window.right();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}