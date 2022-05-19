package arkanoid;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Image;

public class Barra extends JLabel{
    private ImageIcon imagen = new ImageIcon(Bola.class.getResource("/arkanoid/img/barra.png"));
    private Image conversion = imagen.getImage();
    private Image tamaño = conversion.getScaledInstance(130, 25, Image.SCALE_SMOOTH);
    private ImageIcon imgPre = new ImageIcon(tamaño);

    Barra(Principal p){
        this.setIcon(imgPre);
    }
}
