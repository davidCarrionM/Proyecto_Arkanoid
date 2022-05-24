package arkanoid;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Barra extends JLabel implements ActionListener{
     ImageIcon imagen = new ImageIcon(Bola.class.getResource("/arkanoid/img/barra.png"));
     Image conversion = imagen.getImage();
     Image tamaño = conversion.getScaledInstance(130, 25, Image.SCALE_SMOOTH);
     public ImageIcon imgPre = new ImageIcon(tamaño);
    Principal p;
    Timer timerBarraDerecha;
    Timer timerBarraIzquierda;
    boolean flagBarraDerecha = false;
    boolean flagBarraIzquierda = false;
    public int movimiento = 10;

    Barra(Principal p){
        this.setIcon(imgPre);
        this.p=p;
        timerBarraDerecha = new Timer(17, this);
        timerBarraDerecha.start();
        timerBarraIzquierda = new Timer(17, this);
        timerBarraIzquierda.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==timerBarraDerecha && flagBarraDerecha){
            if (p.bola.flagEmpezar) {
                if (this.getX() + 10 <= 710-p.bola.powerCrecer) {
                    this.setLocation(this.getX() + movimiento, this.getY());
                }
            } else {
                if (this.getX() + 10 <= 710-p.bola.powerCrecer) {
                    this.setLocation(this.getX() + movimiento, this.getY());
                    p.bola.setLocation(p.bola.getX() + movimiento, p.bola.getY());
                }
            }
        }
        if(e.getSource()==timerBarraIzquierda && flagBarraIzquierda){
            if (p.bola.flagEmpezar) {
                if (this.getX() - 10 >= 150) {
                    this.setLocation(this.getX() - movimiento, this.getY());
                }
            } else {
                if (this.getX() - 10 >= 150) {
                    this.setLocation(this.getX() - movimiento, this.getY());
                    p.bola.setLocation(p.bola.getX() - movimiento, p.bola.getY());
                }
            }
        }
        
    }

}
