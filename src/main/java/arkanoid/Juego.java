package arkanoid;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Juego extends JPanel {
    JLabel lblFondo;
    NumPuntuacion[] auxScore = new NumPuntuacion[6];
    Score score;
    HighScore highScore;
    public Barra barra;
    Barrera barrera;
    Ladrillo ladrillo;
    PowerUp powerUp;
    public Bola bola;
    NumPuntuacion numPuntuacion;
    int puntuacion;
    Icon[] auxExplosion = new Icon[8];

    Juego() {
        setLayout(null);

        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new movimientoKey());
        int cont = 0;
        int puntuacion = 0;
        barra = new Barra(this);
        barra.setSize(130, 25);
        barra.setLocation(430, 900);
        add(barra);
        
        powerUp = new PowerUp(this);
        add(powerUp);

        int x1 = 170;
        int y1 = 940;
        for (int i = 0; i < 11; i++) {
            barrera = new Barrera(this);
            barrera.setSize(50, 10);
            barrera.setLocation(x1, y1);
            this.add(barrera);
            x1 += 60;
        }


        int x2 = 305;
        int y2 = 95;
        for (int i = 0; i < 6; i++) {
            numPuntuacion = new NumPuntuacion(this);
            numPuntuacion.setSize(16, 20);
            numPuntuacion.setLocation(x2, y2);
            auxScore[i] = numPuntuacion;
            add(numPuntuacion);
            x2 += 20;
        }

        int x = 144;
        int y = 250;
        for (int i = 0; i < 88; i++) {
            ladrillo = new Ladrillo(this, cont);
            ladrillo.setSize(63, 25);
            ladrillo.setLocation(x, y);
            this.add(ladrillo);
            if ((i + 1) % 11 == 0) {
                x = 144;
                y += 26;
                cont++;
            } else {
                x += 64;
            }
        }
        bola = new Bola(this);
        bola.setSize(15, 15);
        bola.setLocation(490, 875);
        // bola.setLocation(490, 200);
        add(bola);

        score = new Score(this);
        score.setSize(200, 70);
        score.setLocation(250, 40);
        add(score);

        highScore = new HighScore(this);
        highScore.setSize(270, 100);
        highScore.setLocation(480, 30);
        add(highScore);

        ImageIcon imagen = new ImageIcon(Juego.class.getResource("/arkanoid/img/fondoJugable.png"));
        Image conversion = imagen.getImage();
        Image tamaño = conversion.getScaledInstance(750, 810, Image.SCALE_SMOOTH);
        ImageIcon imgPre = new ImageIcon(tamaño);
        lblFondo = new JLabel();
        lblFondo.setSize(750, 810);
        lblFondo.setLocation(120, 150);
        lblFondo.setIcon(imgPre);
        add(lblFondo);

        for (int i = 0; i < 8; i++) {
            ImageIcon imagen1 = new ImageIcon(Ladrillo.class.getResource("/arkanoid/img/explosion" + i + ".png"));
            Image conversion1 = imagen1.getImage();
            Image tamaño1 = conversion1.getScaledInstance(50, 25, Image.SCALE_SMOOTH);
            ImageIcon imgPre1 = new ImageIcon(tamaño1);
            auxExplosion[i] = imgPre1;
        }
        

    }

    void crearPower(){

    }

    public class movimientoKey extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {

                barra.flagBarraIzquierda = true;

            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

                barra.flagBarraDerecha = true;

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {

                barra.flagBarraIzquierda = false;

            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

                barra.flagBarraDerecha = false;

            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE && bola.flagEmpezar == false) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE && e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    bola.flagEmpezar = true;
                    bola.iniciarDerecha = true;
                } else {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE && e.getKeyCode() == KeyEvent.VK_LEFT) {
                        bola.flagEmpezar = true;
                        bola.iniciarIzquierda = true;
                    } else {
                        bola.flagEmpezar = true;
                        bola.velocidadx = (int) (Math.random() * 5 - 2);
                        while (bola.velocidadx == 0) {
                            bola.velocidadx = (int) (Math.random() * 5 - 2);
                        }
                    }
                }

            }
        }

    }
}
