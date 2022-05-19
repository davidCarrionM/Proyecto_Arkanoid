package arkanoid;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Principal extends JFrame {
    JLabel lblFondo;
    JLabel lblScore;
    JLabel lblHighScore;
    Barra barra;
    Barrera barrera;
    Ladrillo ladrillo;
    Bola bola;

    Principal() {
        super("Arkanoid");
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        getContentPane().setFocusable(true);
        getContentPane().addKeyListener(new movimientoKey());
        int cont = 0;

        barra = new Barra(this);
        barra.setSize(130, 25);
        barra.setLocation(430, 900);
        add(barra);

        int x1 = 170;
        int y1 = 940;
        for (int i = 0; i < 11; i++) {
            barrera = new Barrera(this);
            barrera.setSize(50, 10);
            barrera.setLocation(x1, y1);
            this.add(barrera);
            x1 += 60;
        }

        int x = 156;
        int y = 250;
        for (int i = 0; i < 60; i++) {
            ladrillo = new Ladrillo(this,cont);
            ladrillo.setSize(63, 25);
            ladrillo.setLocation(x, y);
            this.add(ladrillo);
            if ((i + 1) % 10 == 0) {
                x = 156;
                y += 35;
                cont++;
            } else {
                x += 68;
            }
        }
        bola = new Bola(this);
        bola.setSize(15, 15);
        bola.setLocation(490, 875);
        // bola.setLocation(490, 200);
        add(bola);

        lblScore = new JLabel("Score");
        lblScore.setSize(200, 70);
        lblScore.setLocation(250, 40);
        lblScore.setOpaque(true);
        lblScore.setBackground(Color.WHITE);
        add(lblScore);

        lblHighScore = new JLabel("High Score");
        lblHighScore.setSize(270, 100);
        lblHighScore.setLocation(480, 30);
        lblHighScore.setOpaque(true);
        lblHighScore.setBackground(Color.WHITE);
        add(lblHighScore);

        ImageIcon imagen = new ImageIcon(Principal.class.getResource("/arkanoid/img/fondoJugable.png"));
        Image conversion = imagen.getImage();
        Image tamaño = conversion.getScaledInstance(750, 810, Image.SCALE_SMOOTH);
        ImageIcon imgPre = new ImageIcon(tamaño);
        lblFondo = new JLabel();
        lblFondo.setSize(750, 810);
        lblFondo.setLocation(120, 150);
        lblFondo.setIcon(imgPre);
        add(lblFondo);

    }

    public class movimientoKey extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {

                if (bola.flagEmpezar) {
                    if (barra.getX() - 10 >= 150) {
                        barra.setLocation(barra.getX() - 10, barra.getY());
                    }
                } else {
                    if (barra.getX() - 10 >= 150) {
                        barra.setLocation(barra.getX() - 10, barra.getY());
                        bola.setLocation(bola.getX() - 10, bola.getY());
                    }
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (bola.flagEmpezar) {
                    if (barra.getX() + 10 <= 710) {
                        barra.setLocation(barra.getX() + 10, barra.getY());
                    }
                } else {
                    if (barra.getX() + 10 <= 710) {
                        barra.setLocation(barra.getX() + 10, barra.getY());
                        bola.setLocation(bola.getX() + 10, bola.getY());
                    }
                }
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
                    }
                }

            }
        }

    }
}
