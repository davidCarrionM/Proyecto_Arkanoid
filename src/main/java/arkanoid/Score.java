package arkanoid;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Score extends JLabel{
    Principal p;
    ImageIcon imagen = new ImageIcon(Score.class.getResource("/arkanoid/img/score.jpg"));
    Image conversion = imagen.getImage();
    Image tamaño = conversion.getScaledInstance(200, 70, Image.SCALE_SMOOTH);
    ImageIcon imgPre = new ImageIcon(tamaño);
    Score(Principal p){
        this.p=p;
        this.setIcon(imgPre);
    }
}
