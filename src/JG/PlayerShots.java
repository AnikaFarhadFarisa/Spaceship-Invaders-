package src.JG;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class PlayerShots {
    public int xPos = 0;
    public int size = 10;
    public int yPos = 0;
    public boolean fired;
    public ImageIcon im;

    public PlayerShots() {
    };

    public PlayerShots(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    };

    public ImageIcon draw(Graphics2D g2) {
        if (fired == true) {
            im = new ImageIcon("C:/Users/anika/Desktop/JG/images/bullet.png");
            return im;
        }
        return null;
    }
}
