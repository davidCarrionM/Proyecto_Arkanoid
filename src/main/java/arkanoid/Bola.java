package arkanoid;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Bola extends JLabel implements ActionListener {
    Timer timerBola;
    boolean flagEmpezar = false;
    int velocidady = -4;
    int velocidadx = 0;
    Principal p;

    Bola(Principal p) {
        timerBola = new Timer(16, this);
        timerBola.start();
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timerBola && flagEmpezar) {
            this.setLocation(this.getX() + velocidadx, this.getY() + velocidady);

            for (Component component : p.getContentPane().getComponents()) {
                if (component.getClass() == Ladrillo.class) {

                    if (this.getY() <= (component.getY()+25) && this.getX() >= component.getX() && this.getX() <= (component.getX() + 63)) {
                        component.setVisible(false);
                        velocidady = +4;
                        p.remove(component);
                    }
                }
            }
 

            if (this.getY() <= 180) {
                velocidady = -4;
            }
            if(this.getY() >= 880 && this.getX() >= p.barra.getX()+87 && this.getX() <= (p.barra.getX() + 130)){
                velocidady=-4;
                velocidadx=+2;
            }
            if(this.getY() >= 880 && this.getX() >= p.barra.getX() && this.getX() <= (p.barra.getX() + 43)){
                velocidady=-4;
                velocidadx=-2;
            }
            if(this.getX()<=150){
                velocidadx=+2;
            }
            if(this.getX()>=840){
                velocidadx=-2;
            }
            if (this.getY() >= 880 && this.getX() >= p.barra.getX() && this.getX() <= (p.barra.getX() + 130)) {
                velocidady = -4;
            }

        }
    }

}
