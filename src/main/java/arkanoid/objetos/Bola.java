package arkanoid.objetos;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import arkanoid.Statics;
import arkanoid.acciones.Juego;

/**
 * Bola del juego donde se van a gestionar todas las colisiones
 */
public class Bola extends JLabel implements ActionListener {
    Timer timerBola;
    public boolean flagEmpezar = false;
    public int vel = 4; // TODO cambiar a dooble aleatorio la velocidad y direccion
    int velocidady = -vel;
    public int velocidadx = 0;
    public boolean iniciarIzquierda = false;
    public boolean iniciarDerecha = false;
    Juego p;
    ImageIcon imagen = new ImageIcon(Bola.class.getResource("/arkanoid/img/bola.png"));
    Image conversion = imagen.getImage();
    Image tamaño = conversion.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
    ImageIcon imgPre = new ImageIcon(tamaño);

    public void ReproducirSonido(String nombreSonido) {
        try {
            AudioInputStream audioInputStream = AudioSystem
                    .getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }

    // Principal a;
    public Bola(Juego p) {
        timerBola = new Timer(15, this);
        timerBola.start();
        this.p = p;
        // this.a = a;
        this.setIcon(imgPre);
    }

    public void eliminar(Component objeto) {
        p.ladrillos.remove(objeto);
        ReproducirSonido("src/main/java/arkanoid/sonidos/romper.wav");
        ((Ladrillo) objeto).animacion = true;
        Statics.puntuacion += 10;
        p.score();

        if (p.ladrillos.size() == 0) {
            p.Ganar();
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
                            && this.getX() <= (component.getX() + 50) && this.getY() <= component.getY()+10) {
                        ReproducirSonido("src/main/java/arkanoid/sonidos/barrera.wav");
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
                p.Perder();
            }
            // barra derecha
            if (this.getY() >= 880 && this.getY() <= 900 && this.getX() >= p.barra.getX() + 100
                    && this.getX() <= (p.barra.getX() + 120 + p.powerCrecer)) {
                velocidady = -vel;
                velocidadx = +2;
                ReproducirSonido("src/main/java/arkanoid/sonidos/rebote.wav");
            }
            // barra izquierda
            if (this.getY() >= 880 && this.getY() <= 900 && this.getX() >= p.barra.getX() - 10
                    && this.getX() <= (p.barra.getX() + 20 + p.powerCrecer)) {
                velocidady = -vel;
                velocidadx = -2;
                ReproducirSonido("src/main/java/arkanoid/sonidos/rebote.wav");
            }
            // barra centro
            if (this.getY() >= 880 && this.getY() <= 900 && this.getX() >= p.barra.getX() + 21
                    && this.getX() <= (p.barra.getX() + 109 + p.powerCrecer)) {
                velocidady = -vel;
                ReproducirSonido("src/main/java/arkanoid/sonidos/rebote.wav");

            }
            // techo
            if (this.getY() <= 180) {
                velocidady = +vel;
                ReproducirSonido("src/main/java/arkanoid/sonidos/rebote.wav");
            }
            // izquierda
            if (this.getX() <= 150) {
                velocidadx = +2;
                ReproducirSonido("src/main/java/arkanoid/sonidos/rebote.wav");
            }
            // derecha
            if (this.getX() >= 830) {
                velocidadx = -2;
                ReproducirSonido("src/main/java/arkanoid/sonidos/rebote.wav");
            }

        }
    }

}
