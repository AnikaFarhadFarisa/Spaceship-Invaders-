package src.JG;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PlayArea extends JPanel implements Runnable {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public final int FPS = 60;
    public ActionHandler keyN = new ActionHandler();
    Player player1 = new Player();
    Thread gameThread;
    ListOfEnemies enGang = new ListOfEnemies();
    public Enemy1 enGang1[] = new Enemy1[12];
    ImageIcon im;
    ImageIcon eIm;
    ImageIcon sIm;
    ImageIcon sImP;
    public boolean gameOn = true;
    public int count = 0;
    public boolean win = false;

    public PlayArea() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLUE);
        this.addKeyListener(keyN);
        this.setFocusable(true);
        enGang1 = enGang.buildGang();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        if (win == true && gameOn == false) {
            g2.setColor(Color.RED);
            g2.setFont(g2.getFont().deriveFont(50f));
            g2.drawString("You Won!", 300, 400);
        } else if (win == false && gameOn == false) {
            g2.setColor(Color.RED);
            g2.setFont(g2.getFont().deriveFont(50f));
            g2.drawString("You Lost!", 300, 400);
        }

        for (int i = 0; i < enGang.len; i++) {
            eIm = enGang1[i].draw(g2);
            if (eIm != null) {

                g2.drawImage(eIm.getImage(), enGang1[i].xPos, enGang1[i].yPos, null);

            }
            if (enGang1[i].newSht != null) {
                sIm = enGang1[i].newSht.draw(g2);
                if (sIm != null) {
                    g2.drawImage(sIm.getImage(), enGang1[i].newSht.xPos, enGang1[i].newSht.yPos, null);
                }
            }
        }

        im = player1.draw();
        if (im != null) {

            g2.drawImage(im.getImage(), player1.xpos, player1.ypos, null);
        }
        if (player1.newSht != null) {
            sImP = player1.newSht.draw(g2);
            if (sImP != null) {
                g2.drawImage(sImP.getImage(), player1.newSht.xPos, player1.newSht.yPos, null);
            }
        }

        g2.dispose();
    }

    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void checkCollision(Enemy1 enem1) {
        int plX1 = player1.xpos;
        int plX2 = plX1 + 40;
        int plY1 = player1.ypos;
        int plY2 = plY1 + 40;
        int shotX = enem1.newSht.xPos;
        int shotY = enem1.newSht.yPos;
        if (shotX == plX1 && shotY > plY1 && shotY < plY2) {
            player1.dead = true;
        } else if (shotX == plX2 && shotY > plY1 && shotY < plY2) {
            player1.dead = true;
        } else if (shotY == plY1 && shotX > plX1 && shotX < plX2) {
            player1.dead = true;
        } else if (shotY == plY2 && shotX > plX1 && shotX < plX2) {
            player1.dead = true;
        }
    }

    public void checkKillEnemy(Enemy1 enemy1) {
        int enX1 = enemy1.xPos;
        int enX2 = enX1 + enemy1.size;
        int shotX1 = player1.newSht.xPos;
        int shotX2 = shotX1 + 10;
        if (shotX1 > enX1 && shotX1 < enX2) {
            enemy1.alive = false;
        } else if (shotX2 > enX1 && shotX2 < enX2) {
            enemy1.alive = false;
        }
    }

    public void checkGameState() {
        if (count >= 12) {
            gameOn = false;
            win = true;
        }
    }

    public void enemyClear(Enemy1 enm) {
        if (enm.alive != true && enm.checked != true) {
            count += 1;
            enm.checked = true;
            checkGameState();
        }
    }

    public void update() {

        if (gameOn == true) {

            for (int i = 0; i < enGang.len; i++) {
                enGang1[i].update();
                if (enGang1[i].newSht != null) {
                    checkCollision(enGang1[i]);

                }
                enemyClear(enGang1[i]);
            }

            player1.shootFire();

            if (player1.newSht != null) {
                for (int i = 0; i < enGang.len; i++) {
                    checkKillEnemy(enGang1[i]);

                }
            }

            if (keyN.up == true && player1.ypos > 0) {
                player1.ypos -= 10;
            } else if (keyN.down == true && player1.ypos + player1.boxHei < 800) {
                player1.ypos += 10;
            } else if (keyN.left == true && player1.xpos > 0) {
                player1.xpos -= 10;
            } else if (keyN.right == true && player1.xpos + player1.boxWid < 800) {
                player1.xpos += 10;
            } else if (keyN.shoot == true) {
                player1.shotsFired();
            }

            if (player1.dead == true) {
                gameOn = false;
            }
        }

    }

    @Override
    public void run() {
        double interVal = 1000000000 / FPS;
        double oldTime = System.nanoTime();
        double deltaTime = 0;
        double currentTime = 0;

        while (gameThread != null) {
            if (deltaTime >= 1) {
                update();
                repaint();
                deltaTime--;
            } else {
                currentTime = System.nanoTime();
                deltaTime += (currentTime - oldTime) / interVal;
                oldTime = currentTime;
            }

        }
    }
}
