package src.JG;

import javax.swing.ImageIcon;

public class Player {
    public final int boxWid = 50;
    public final int boxHei = 50;
    public int xpos = 400;
    public int ypos = 400;
    public boolean dead = false;
    public PlayerShots newSht;
    public boolean fireAgain = true;
    public boolean fire = true;
    public ImageIcon im;

    public Player() {
    }

    public void shotsFired() {
        if (dead != true) {
            PlayerShots shot = new PlayerShots(xpos + 10, ypos);
            shot.fired = true;
            newSht = shot;
        }
    }

    public void shootFire() {
        if (newSht != null) {
            newSht.yPos -= 100;
        }
    }

    public ImageIcon draw() {
        if (dead != true) {
            im = new ImageIcon("C:/Users/anika/Desktop/JG/images/spaceship.png");
            return im;
        } else {
            return null;
        }

    }

}
