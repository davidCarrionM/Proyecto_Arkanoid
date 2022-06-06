package arkanoid;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Juego extends JPanel implements ActionListener {
    JLabel lblFondo;
    JLabel score;
    JLabel highScore;
    public Barra barra;
    Barrera barrera;
    Timer tiempo;
    Ladrillo ladrillo;
    PowerUp powerUp;
    public Bola bola;
    int puntuacion;
    Icon[] auxExplosion = new Icon[8];
    Principal a;
    public int powerCrecer = 0;
    public JLabel numPuntuacion;
    public JLabel[] auxHighScore = new JLabel[6];
    public JLabel[] auxScore = new JLabel[6];
    ArrayList<Ladrillo> ladrillos = new ArrayList<Ladrillo>();

    public void Ganar() {
        System.out.println("GANASTE");
        bola.flagEmpezar = false;
        a.win.setVisible(true);
        a.win.score();
        this.tiempo.stop();

        this.setVisible(false);
        this.removeAll();
    }

    public void score() {
        for (int i = 0; i < 6; i++) {
            ImageIcon imagen1 = new ImageIcon(Bola.class
                    .getResource("/arkanoid/img/num" + (String.format("%06d", Statics.puntuacion).charAt(i) + ".png")));
            Image conversion1 = imagen1.getImage();
            Image tamaño1 = conversion1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
            ImageIcon imgPre1 = new ImageIcon(tamaño1);
            auxScore[i].setIcon(imgPre1);
        }
    }

    public void Perder() {
        bola.flagEmpezar = false;
        a.gameOver.setVisible(true);
        a.gameOver.score();
        this.setVisible(false);
        this.tiempo.stop();
        this.removeAll();

    }

    Juego(Principal a) {
        Statics.time = 0;

        setLayout(null);
        this.setFocusable(true);
        this.grabFocus();
        this.a = a;
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new movimientoKey());
        int cont = 0;
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
        ImageIcon imagen = new ImageIcon(Juego.class.getResource("/arkanoid/img/num0.png"));
        Image conversion = imagen.getImage();
        Image tamaño = conversion.getScaledInstance(15,15, Image.SCALE_SMOOTH);
        ImageIcon imgPre = new ImageIcon(tamaño);

        int x2 = 305;
        int y2 = 95;
        for (int i = 0; i < 6; i++) {
            numPuntuacion = new JLabel();
            numPuntuacion.setSize(15,15);
            numPuntuacion.setLocation(x2, y2);
            auxScore[i] = numPuntuacion;
            numPuntuacion.setIcon(imgPre);
            add(numPuntuacion);
            x2 += 20;
        }
        int x3 = 555;
        int y3 = 95;
        for (int j = 0; j < 6; j++) {
            ImageIcon imagen11 = new ImageIcon(Records.class.getResource("/arkanoid/img/num" + (String.format("%06d", Statics.record).charAt(j) + ".png")));
            Image conversion11 = imagen11.getImage();
            Image tamaño11 = conversion11.getScaledInstance(15,15, Image.SCALE_SMOOTH);
            ImageIcon imgPre11 = new ImageIcon(tamaño11);
            highScore = new JLabel();
            highScore.setSize(15,15);
            highScore.setLocation(x3, y3);
            highScore.setIcon(imgPre11);
            add(highScore);
            x3 += 20;
        }

        int x = 144;
        int y = 250;
        for (int i = 0; i < 88; i++) {
            ladrillo = new Ladrillo(this, cont);
            ladrillo.setSize(63, 25);
            ladrillo.setLocation(x, y);
            ladrillos.add(ladrillo);
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
        ImageIcon imagen2 = new ImageIcon(Save.class.getResource("/arkanoid/img/score.png"));
        Image conversion2 = imagen2.getImage();
        Image tamaño2 = conversion2.getScaledInstance(200, 70, Image.SCALE_SMOOTH);
        ImageIcon imgPre2 = new ImageIcon(tamaño2);
        score = new JLabel();
        score.setSize(200, 70);
        score.setLocation(250, 40);
        score.setIcon(imgPre2);
        add(score);

        ImageIcon imagen0 = new ImageIcon(Juego.class.getResource("/arkanoid/img/highscore.png"));
        Image conversion0 = imagen0.getImage();
        Image tamaño0 = conversion0.getScaledInstance(270, 100, Image.SCALE_SMOOTH);
        ImageIcon imgPre0 = new ImageIcon(tamaño0);
        highScore = new JLabel();
        highScore.setSize(270, 100);
        highScore.setLocation(480, 30);
        highScore.setIcon(imgPre0);
        add(highScore);

        ImageIcon imagen6 = new ImageIcon(Juego.class.getResource("/arkanoid/img/fondoJugable.png"));
        Image conversion6 = imagen6.getImage();
        Image tamaño6 = conversion6.getScaledInstance(750, 810, Image.SCALE_SMOOTH);
        ImageIcon imgPre6 = new ImageIcon(tamaño6);
        lblFondo = new JLabel();
        lblFondo.setSize(750, 810);
        lblFondo.setLocation(120, 150);
        lblFondo.setIcon(imgPre6);
        add(lblFondo);

        for (int i = 0; i < 8; i++) {
            ImageIcon imagen1 = new ImageIcon(Ladrillo.class.getResource("/arkanoid/img/explosion" + i + ".png"));
            Image conversion1 = imagen1.getImage();
            Image tamaño1 = conversion1.getScaledInstance(50, 25, Image.SCALE_SMOOTH);
            ImageIcon imgPre1 = new ImageIcon(tamaño1);
            auxExplosion[i] = imgPre1;
        }

        tiempo = new Timer(1000, this);
        tiempo.start();

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tiempo) {
            Statics.time +=1;
            System.err.println("tiempo Juego"+Statics.time);
        }
    }
}
