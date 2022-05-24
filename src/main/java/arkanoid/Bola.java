package arkanoid;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import arkanoid.Principal;
public class Bola extends JLabel implements ActionListener {
    Timer timerBola;
    public boolean flagEmpezar = false;
    int contEliminar = 0;
    int velocidady = -4;
    int velocidadx = 0;
    boolean iniciarIzquierda = false;
    boolean iniciarDerecha = false;
    Juego p;
    public int vel =4;
    public int powerCrecer = 0;
    ImageIcon imagen = new ImageIcon(Bola.class.getResource("/arkanoid/img/bola.png"));
    Image conversion = imagen.getImage();
    Image tamaño = conversion.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
    ImageIcon imgPre = new ImageIcon(tamaño);
    Principal a;

    Bola(Juego p,Principal a) {
        timerBola = new Timer(15, this);
        timerBola.start();
        this.p = p;
        this.a = a;
        this.setIcon(imgPre);
    }

    public void eliminar(Component objeto) {
        ((Ladrillo)objeto).animacion = true;
        p.puntuacion += 10;
        contEliminar++;
        for(int i = 0; i<p.auxScore.length;i++){
        ImageIcon imagen1 = new ImageIcon(Bola.class.getResource("/arkanoid/img/num"+(String.format("%06d", p.puntuacion).charAt(i)+".png")));
        Image conversion1 = imagen1.getImage();
            Image tamaño1 = conversion1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
            ImageIcon imgPre1 = new ImageIcon(tamaño1);
            p.auxScore[i].setIcon(imgPre1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timerBola && flagEmpezar) {
            this.setLocation(this.getX() + velocidadx, this.getY() + velocidady);

            // ladrillo
            for (Component component : p.getComponents()) {
                if (component.getClass() == Ladrillo.class) {
                    // ladrillo-abajo
                    if (this.getY() <= (component.getY() + 25)
                            && this.getY() >= component.getY()
                            && this.getX() >= component.getX()
                            && this.getX() <= (component.getX() + 62)

                    ) {
                        velocidady = +vel;
                        eliminar(component);
                    }
                    // ladrillo-arriba
                    if (this.getY() + this.getHeight() >= component.getY()
                            && this.getY() + this.getHeight() <= component.getY() + 20
                            && this.getX() >= component.getX()
                            && this.getX() <= (component.getX() + 63)) {

                        velocidady = -vel;
                        eliminar(component);
                    }
                    // ladrillo-derecha
                    if (this.getX() <= component.getX() + 10 && this.getX() >= component.getX() + 50
                            && this.getY() <= component.getY() + 25 && this.getY() >= component.getY()) {
                        // System.out.println("DERECHA");
                        velocidadx = +2;
                        eliminar(component);

                    }
                    // ladrillo-izquierda
                    if (this.getX() + 10 <= component.getX() + 10 && this.getX() + 10 >= component.getX()
                            && this.getY() <= component.getY() + 25 && this.getY() >= component.getY()) {
                        // System.out.println("IZQUIERDA");
                        velocidadx = -2;
                        eliminar(component);

                    }

                }
            }
            // Barrera
            for (Component component : p.getComponents()) {
                if (component.getClass() == Barrera.class) {
                    if (this.getY() >= component.getY() && this.getX() >= component.getX()
                            && this.getX() <= (component.getX() + 50)) {
                        component.setVisible(false);
                        p.remove(component);
                        this.setLocation(p.barra.getX() + (p.barra.getWidth() / 2), p.barra.getY() - 20);
                        flagEmpezar = false;
                        velocidady = -vel;
                        velocidadx = 0;
                    }
                }
            }

            // Perder
            if (this.getY() >= 1000) {
                System.out.println("GAME OVER");
                flagEmpezar = false;
                p.puntuacion = 0;
                a.gameOver = new GameOver(a);
                a.gameOver.setSize(1000,1000);
                a.gameOver.setVisible(true);
                a.add(a.gameOver);
                a.juego.setVisible(false);
                // Principal.eliminar = true;              
            }
            // barra derecha
            if (this.getY() >= 880 && this.getY() <= 900 && this.getX() >= p.barra.getX() + 100
                    && this.getX() <= (p.barra.getX() + 120+powerCrecer)) {
                velocidady = -vel;
                velocidadx = +2;
            }
            // barra izquierda
            if (this.getY() >= 880 && this.getY() <= 900 && this.getX() >= p.barra.getX() - 10
                    && this.getX() <= (p.barra.getX() + 20+powerCrecer)) {
                velocidady = -vel;
                velocidadx = -2;
            }
            // barra centro
            if (this.getY() >= 880 && this.getY() <= 900 && this.getX() >= p.barra.getX() + 21
                    && this.getX() <= (p.barra.getX() + 109+powerCrecer)) {
                velocidady = -vel;
            }
            // techo
            if (this.getY() <= 180) {
                velocidady = +vel;
            }
            // izquierda
            if (this.getX() <= 150) {
                velocidadx = +2;
            }
            // derecha
            if (this.getX() >= 830) {
                velocidadx = -2;
            }

        }
    }

}
