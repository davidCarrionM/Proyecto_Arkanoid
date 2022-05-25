package arkanoid;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Save extends JPanel {
    JLabel letra;
    Principal a;
    JLabel highScore;
    JLabel score;
    JLabel nameRegis;

    public Save(Principal a) {
        this.setLayout(null);
        this.setBackground(Color.black);
        this.a=a;

        ImageIcon imagen0 = new ImageIcon(HighScore.class.getResource("/arkanoid/img/highscore.png"));
    Image conversion0 = imagen0.getImage();
    Image tamaño0 = conversion0.getScaledInstance(270, 100, Image.SCALE_SMOOTH);
    ImageIcon imgPre0 = new ImageIcon(tamaño0);
    highScore = new JLabel();
    highScore.setSize(270, 100);
    highScore.setLocation(480, 30);
    highScore.setIcon(imgPre0);
    add(highScore);
    ImageIcon imagen = new ImageIcon(Score.class.getResource("/arkanoid/img/score.png"));
    Image conversion = imagen.getImage();
    Image tamaño = conversion.getScaledInstance(200, 70, Image.SCALE_SMOOTH);
    ImageIcon imgPre = new ImageIcon(tamaño);
    score = new JLabel();
    score.setSize(200, 70);
    score.setLocation(250, 40);
    score.setIcon(imgPre);
    add(score);
    ImageIcon imagen3 = new ImageIcon(Score.class.getResource("/arkanoid/img/nameRegis.png"));
    Image conversion3 = imagen3.getImage();
    Image tamaño3 = conversion3.getScaledInstance(600, 80, Image.SCALE_SMOOTH);
    ImageIcon imgPre3 = new ImageIcon(tamaño3);
    nameRegis = new JLabel();
    nameRegis.setSize(600, 80);
    nameRegis.setLocation(200, 200);
    nameRegis.setIcon(imgPre3);
    add(nameRegis);

        int x = 220;
        int y = 600;
        for (int i = 0; i < 32; i++) {
            ImageIcon imagen1 = new ImageIcon(Ladrillo.class.getResource("/arkanoid/img/letra" + i + ".png"));
            Image conversion1 = imagen1.getImage();
            Image tamaño1 = conversion1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon imgPre1 = new ImageIcon(tamaño1);
            letra = new JLabel();
            letra.setSize(50, 50);
            letra.setLocation(x, y);
            letra.setIcon(imgPre1);
            this.add(letra);

            if ((i + 1) % 8 == 0) {
                x = 220;
                y += 60;
            } else {
                x += 70;
            }
        }
    }
}
