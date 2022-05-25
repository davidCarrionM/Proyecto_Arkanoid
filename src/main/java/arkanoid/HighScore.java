package arkanoid;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HighScore extends JLabel{
    Juego p;
    ImageIcon imagen0 = new ImageIcon(HighScore.class.getResource("/arkanoid/img/highscore.png"));
    Image conversion0 = imagen0.getImage();
    Image tamaño0 = conversion0.getScaledInstance(270, 100, Image.SCALE_SMOOTH);
    ImageIcon imgPre0 = new ImageIcon(tamaño0);

    HighScore(Juego p){
        this.p = p;
        this.setIcon(imgPre0);
    }
}
