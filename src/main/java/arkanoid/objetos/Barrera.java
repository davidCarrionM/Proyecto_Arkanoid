package arkanoid.objetos;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import arkanoid.acciones.Juego;

/**
 * Protecion para que no se caiga la bola que se destruye cuando se choca la bola
 */
public class Barrera extends JLabel{
    
    private ImageIcon imagen = new ImageIcon(Barrera.class.getResource("/arkanoid/img/barra.png"));
    private Image conversion = imagen.getImage();
    private Image tamaño = conversion.getScaledInstance(50, 10, Image.SCALE_SMOOTH);
    private ImageIcon imgPre = new ImageIcon(tamaño);
    Juego p;
    Timer timerAnimacion;
    boolean animacion;
    int contaux = 0;
    
    public Barrera(Juego p ){
        this.p=p;
        this.setIcon(imgPre);

    }

   
}
