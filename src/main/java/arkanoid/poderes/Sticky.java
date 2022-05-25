package arkanoid.poderes;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import arkanoid.Juego;

public class Sticky extends JLabel implements ActionListener {
    Juego p;
    public Timer timer;

    public boolean move = false;
    boolean empezar = false;
    int cont = 0;
    
    public Sticky(Juego p) {
        ImageIcon imagen = new ImageIcon(Tall.class.getResource("/arkanoid/img/power6.png"));
        Image conversion = imagen.getImage();
        Image tamaño = conversion.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon imgPre = new ImageIcon(tamaño);
        this.setIcon(imgPre);
        this.p = p;
        timer = new Timer(50, this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer && move){
            this.setLocation(this.getX(), this.getY()+10);


            if (this.getY() >= 880 && this.getY() <= 900 && this.getX() >= p.barra.getX()  && this.getX() <= (p.barra.getX() + 130+p.powerCrecer)) {
                p.remove(this);
                this.setVisible(false);
                this.move = false;
                p.bola.flagEmpezar = false;
                p.bola.setLocation(p.barra.getX()+65, 875);
            }
            
            if(this.getY() >= 950){
                p.remove(this);
                this.setVisible(false);
                this.move = false;
            }
        }      
    }

}
