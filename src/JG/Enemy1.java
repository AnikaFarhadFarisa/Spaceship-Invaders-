package src.JG;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Enemy1 {
    public int frameCount = 0;
    public int xPos = 0;
    public int x_Pos = 0;
    public int offSet = 30;
    public int size = 0;
    public int yPos = 0;
    Shots newSht;
    public boolean fireAgain = true;
    public boolean fire = true;
    public boolean alive = true;
    public boolean checked = false;
    public ImageIcon im;

    public Enemy1() {
    };

    public Enemy1(int xPos, int yPos, int size, int x_Pos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.size = size;
        this.x_Pos = x_Pos;
    };

    public ImageIcon draw(Graphics2D g2) {
        if (alive == true) {
            im = new ImageIcon("C:/Users/anika/Desktop/JG/images/alien.png");
            return im;
        }
        return null;
    }

    public void shotsFired() {
        Shots shot = new Shots(xPos + 11, 20);
        shot.fired = true;
        updateShot(shot);
    }

    public void updateShot(Shots val) {
        newSht = val;
    }

    public void checkShotsSpawn() {
        if (newSht != null) {
            if (newSht.yPos >= 800) {
                fireAgain = true;
            }
        }
    }

    public void updateShotPos() {
        if (newSht != null) {
            newSht.yPos += 5;
        }
    }

    public void setXpos(int val) {
        xPos = val;
    }

    public int getPosX() {
        return xPos;
    }

    public int getPosY() {
        return yPos;
    }

    public void update() {
        updateShotPos();

        if (alive) {
            if (frameCount >= 60) {
                int val = (int) Math.floor(Math.random() * (10 - (-10) + 1) + (-10));
                int xpos1 = xPos + val;
                if (xpos1 >= 0 && xpos1 <= 800 && xpos1 >= x_Pos && xpos1 <= offSet) {
                    setXpos(xPos + val);
                }

                checkShotsSpawn();
                int val1 = (int) Math.floor(Math.random() * (1 - 0 + 1) + 0);
                if (val1 == 1 && fire == true) {
                    shotsFired();
                    fire = false;
                }
                if (val1 == 1 && fireAgain == true) {
                    shotsFired();
                    fireAgain = false;

                }
                frameCount = 0;
            }
            frameCount++;
        }

    }
}
