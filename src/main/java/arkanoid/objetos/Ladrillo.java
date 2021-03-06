package arkanoid.objetos;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import arkanoid.acciones.Juego;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Ladrillo donde tiene que chocar la bola y de lcual saldran los poderes
 */
public class Ladrillo extends JLabel implements ActionListener {
    boolean animacion = false;
    Timer timerAnimacion;
    int contaux = 0;
    Juego p;

    public Ladrillo(Juego p, int index) {
        ImageIcon imagen = new ImageIcon(Ladrillo.class.getResource("/arkanoid/img/bloque" + index + ".png"));
        Image conversion = imagen.getImage();
        Image tamaño = conversion.getScaledInstance(63, 25, Image.SCALE_SMOOTH);
        ImageIcon imgPre = new ImageIcon(tamaño);
        this.setIcon(imgPre);
        this.p = p;
        

        timerAnimacion = new Timer(40, this);
        timerAnimacion.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timerAnimacion && animacion) {
            if (contaux == 7) {
                animacion = false;
                p.powerUp.XLadrillo = this.getX();
                p.powerUp.YLadrillo = this.getY();
                p.powerUp.gestionar();
                this.setVisible(false);
                p.remove(this);
            }else{
                this.setIcon(p.auxExplosion[contaux]);
                contaux++;
            }
        }

    }

}
