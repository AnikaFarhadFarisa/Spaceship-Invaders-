package src.JG;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ActionHandler implements KeyListener {
    public boolean up, down, left, right, shoot;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int val = e.getKeyCode();
        if (val == KeyEvent.VK_W) {
            up = true;
        } else if (val == KeyEvent.VK_S) {
            down = true;
        } else if (val == KeyEvent.VK_A) {
            left = true;
        } else if (val == KeyEvent.VK_D) {
            right = true;
        } else if (val == KeyEvent.VK_SPACE) {
            shoot = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int val = e.getKeyCode();
        if (val == KeyEvent.VK_W) {
            up = false;
        } else if (val == KeyEvent.VK_S) {
            down = false;
        } else if (val == KeyEvent.VK_A) {
            left = false;
        } else if (val == KeyEvent.VK_D) {
            right = false;
        } else if (val == KeyEvent.VK_SPACE) {
            shoot = false;
        }
    }

}