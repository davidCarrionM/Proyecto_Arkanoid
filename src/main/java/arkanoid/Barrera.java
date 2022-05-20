package arkanoid;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Image;

public class Barrera extends JLabel{
    
    private ImageIcon imagen = new ImageIcon(Barrera.class.getResource("/arkanoid/img/barra.png"));
    private Image conversion = imagen.getImage();
    private Image tamaño = conversion.getScaledInstance(50, 10, Image.SCALE_SMOOTH);
    private ImageIcon imgPre = new ImageIcon(tamaño);
    
    Barrera(Principal p ){
        this.setIcon(imgPre);
    }
}
