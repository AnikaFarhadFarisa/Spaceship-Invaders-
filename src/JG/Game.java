package src.JG;
import javax.swing.JFrame;

public class Game {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PlayArea gamePanel = new PlayArea();
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);

        gamePanel.startGame();
    }

}