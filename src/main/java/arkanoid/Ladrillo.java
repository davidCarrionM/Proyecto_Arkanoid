package arkanoid;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ladrillo extends JLabel implements ActionListener {
    boolean animacion = false;
    Timer timerAnimacion;
    int contaux = 0;
    Principal p;

    Ladrillo(Principal p, int index) {
        ImageIcon imagen = new ImageIcon(Ladrillo.class.getResource("/arkanoid/img/bloque" + index + ".png"));
        Image conversion = imagen.getImage();
        Image tamaño = conversion.getScaledInstance(63, 25, Image.SCALE_SMOOTH);
        ImageIcon imgPre = new ImageIcon(tamaño);
        this.setIcon(imgPre);
        timerAnimacion = new Timer(100, this);
        timerAnimacion.start();
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == timerAnimacion && animacion) {
            ImageIcon imagen = new ImageIcon(Ladrillo.class.getResource("/arkanoid/img/explosion" + 3 + ".png"));
            Image conversion = imagen.getImage();
            Image tamaño = conversion.getScaledInstance(63, 25, Image.SCALE_SMOOTH);
            ImageIcon imgPre = new ImageIcon(tamaño);
            this.setIcon(imgPre);
            if (contaux == 12) {
                animacion = false;
                this.setVisible(false);
                p.remove(this);
            }
        }

    }

}
