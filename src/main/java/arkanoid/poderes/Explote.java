package arkanoid.poderes;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import arkanoid.Ladrillo;
import arkanoid.Juego;

public class Explote extends JLabel implements ActionListener {
    Juego p;
    Timer timer;

    public boolean move = false;
    boolean empezar = false;
    int cont = 0;
    
    public Explote(Juego p) {
        ImageIcon imagen = new ImageIcon(Tall.class.getResource("/arkanoid/img/power1.png"));
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


            if (this.getY() >= 880 && this.getY() <= 900 && this.getX() >= p.barra.getX()  && this.getX() <= (p.barra.getX() + 130)) {
                p.remove(this);
                this.setVisible(false);
                this.move = false;
                for (Component componente : p.getComponents()) {
                    if(componente.getClass() == Ladrillo.class){
                        int random = (int)(Math.random()*10);
                        if(random == 1||random == 2){
                            p.bola.eliminar(componente);
                        }
                    }
                }
            }
            
            if(this.getY() >= 950){
                p.remove(this);
                this.setVisible(false);
                this.move = false;
            }
        }      
    }

}
