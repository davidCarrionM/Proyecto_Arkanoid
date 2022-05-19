package arkanoid;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Image;
public class Ladrillo extends JLabel{

    Ladrillo(Principal p, int index){
        ImageIcon imagen = new ImageIcon(Bola.class.getResource("/arkanoid/img/bloque"+index+".png"));
        Image conversion = imagen.getImage();
        Image tamaño = conversion.getScaledInstance(63, 25, Image.SCALE_SMOOTH);
        ImageIcon imgPre = new ImageIcon(tamaño);
       
        this.setIcon(imgPre);
    }
    
}
