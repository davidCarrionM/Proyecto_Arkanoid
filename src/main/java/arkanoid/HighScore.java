package arkanoid;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HighScore extends JLabel{
    Principal p;
    ImageIcon imagen = new ImageIcon(HighScore.class.getResource("/arkanoid/img/highscore.jpg"));
    Image conversion = imagen.getImage();
    Image tamaño = conversion.getScaledInstance(270, 100, Image.SCALE_SMOOTH);
    ImageIcon imgPre = new ImageIcon(tamaño);

    HighScore(Principal p){
        this.p = p;
        this.setIcon(imgPre);
    }
}
