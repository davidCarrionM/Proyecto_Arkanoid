package arkanoid;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Barrera extends JLabel{
    
    private ImageIcon imagen = new ImageIcon(Barrera.class.getResource("/arkanoid/img/barra.png"));
    private Image conversion = imagen.getImage();
    private Image tamaño = conversion.getScaledInstance(50, 10, Image.SCALE_SMOOTH);
    private ImageIcon imgPre = new ImageIcon(tamaño);
    Principal p;
    Timer timerAnimacion;
    boolean animacion;
    int contaux = 0;
    
    Barrera(Principal p ){
        this.p=p;
        this.setIcon(imgPre);

    }

   
}
