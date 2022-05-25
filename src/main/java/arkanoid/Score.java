package arkanoid;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
//TODO ELIMINAR ESTA Y HIGHSCORE
public class Score extends JLabel{
    Juego p;
    ImageIcon imagen = new ImageIcon(Score.class.getResource("/arkanoid/img/score.png"));
    Image conversion = imagen.getImage();
    Image tamaño = conversion.getScaledInstance(200, 70, Image.SCALE_SMOOTH);
    ImageIcon imgPre = new ImageIcon(tamaño);
    Score(Juego p){
        this.p=p;
        this.setIcon(imgPre);



    }
}
