package arkanoid;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class NumPuntuacion extends JLabel{
    Juego p;
    private ImageIcon imagen = new ImageIcon(NumPuntuacion.class.getResource("/arkanoid/img/num0.png"));
    private Image conversion = imagen.getImage();
    private Image tamaño = conversion.getScaledInstance(16, 20, Image.SCALE_SMOOTH);
    private ImageIcon imgPre = new ImageIcon(tamaño);
    
    NumPuntuacion(Juego p){
        this.p = p;
        this.setIcon(imgPre);
    }
}
