package arkanoid;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Save extends JPanel implements ActionListener {
    JButton letra;
    JButton back;
    JButton del;
    JButton send;
    String finalName = "";
    ArrayList<Character> coleccion = new ArrayList<Character>();
    JLabel vacio;
    Principal a;
    JLabel highScore;
    JLabel score;
    File f = new File(System.getProperty("user.home")+"/arkanoid_records.txt");

    JLabel name;
    JLabel nameRegis;
    boolean winOver;
    int cont = 0;
    public JLabel numPuntuacion;
    public JLabel[] auxScore = new JLabel[6];
    public JLabel[] auxVacio = new JLabel[10];
    ImageIcon imagen4 = new ImageIcon(Ladrillo.class.getResource("/arkanoid/img/back.png"));
    Image conversion4 = imagen4.getImage();
    Image tamaño4 = conversion4.getScaledInstance(200, 40, Image.SCALE_SMOOTH);
    ImageIcon imgPre4 = new ImageIcon(tamaño4);
    ImageIcon imagen5 = new ImageIcon(Ladrillo.class.getResource("/arkanoid/img/back+.png"));
    Image conversion5 = imagen5.getImage();
    Image tamaño5 = conversion5.getScaledInstance(200, 40, Image.SCALE_SMOOTH);
    ImageIcon imgPre5 = new ImageIcon(tamaño5);
    ImageIcon imagen1 = new ImageIcon(Save.class.getResource("/arkanoid/img/vacio.png"));
    Image conversion1 = imagen1.getImage();
    Image tamaño1 = conversion1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    ImageIcon imgPre1 = new ImageIcon(tamaño1);

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

    public Save(Principal a) {
        this.setLayout(null);
        this.setBackground(Color.black);
        this.a = a;

        int x1 = 330;
        int y1 = 350;
        for (int i = 0; i < 10; i++) {
            vacio = new JLabel();
            vacio.setSize(50, 50);
            vacio.setLocation(x1, y1);
            vacio.setIcon(imgPre1);
            this.add(vacio);
            auxVacio[i] = vacio;
            x1 += 55;
        }
        ImageIcon imagen2 = new ImageIcon(Save.class.getResource("/arkanoid/img/name.png"));
        Image conversion2 = imagen2.getImage();
        Image tamaño2 = conversion2.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon imgPre2 = new ImageIcon(tamaño2);
        name = new JLabel();
        name.setSize(200, 50);
        name.setLocation(140, 350);
        name.setIcon(imgPre2);
        add(name);

        ImageIcon imagen0 = new ImageIcon(Save.class.getResource("/arkanoid/img/highscore.png"));
        Image conversion0 = imagen0.getImage();
        Image tamaño0 = conversion0.getScaledInstance(270, 100, Image.SCALE_SMOOTH);
        ImageIcon imgPre0 = new ImageIcon(tamaño0);
        highScore = new JLabel();
        highScore.setSize(270, 100);
        highScore.setLocation(480, 30);
        highScore.setIcon(imgPre0);
        add(highScore);
        ImageIcon imagen = new ImageIcon(Save.class.getResource("/arkanoid/img/score.png"));
        Image conversion = imagen.getImage();
        Image tamaño = conversion.getScaledInstance(200, 70, Image.SCALE_SMOOTH);
        ImageIcon imgPre = new ImageIcon(tamaño);
        score = new JLabel();
        score.setSize(200, 70);
        score.setLocation(250, 40);
        score.setIcon(imgPre);
        add(score);
        ImageIcon imagen3 = new ImageIcon(Save.class.getResource("/arkanoid/img/nameRegis.png"));
        Image conversion3 = imagen3.getImage();
        Image tamaño3 = conversion3.getScaledInstance(600, 75, Image.SCALE_SMOOTH);
        ImageIcon imgPre3 = new ImageIcon(tamaño3);
        nameRegis = new JLabel();
        nameRegis.setSize(600, 75);
        nameRegis.setLocation(200, 200);
        nameRegis.setIcon(imgPre3);
        add(nameRegis);

        int x = 220;
        int y = 500;
        for (int i = 0; i < 32; i++) {
            ImageIcon imagen1 = new ImageIcon(Ladrillo.class.getResource("/arkanoid/img/letra" + i + ".png"));
            Image conversion1 = imagen1.getImage();
            Image tamaño1 = conversion1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon imgPre1 = new ImageIcon(tamaño1);
            letra = new JButton();
            letra.setSize(50, 50);
            letra.setLocation(x, y);
            letra.setIcon(imgPre1);
            letra.setActionCommand(i + "");
            letra.addActionListener(this);
            this.add(letra);

            if ((i + 1) % 8 == 0) {
                x = 220;
                y += 80;
            } else {
                x += 70;
            }
        }

        back = new JButton();
        back.setSize(200, 40);
        back.setLocation(50, 70);
        back.setIcon(imgPre4);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.addMouseListener(new MouseEvent());
        back.addActionListener(this);
        this.add(back);

        ImageIcon imagen1 = new ImageIcon(Save.class.getResource("/arkanoid/img/del.png"));
        Image conversion1 = imagen1.getImage();
        Image tamaño1 = conversion1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon imgPre1 = new ImageIcon(tamaño1);
        del = new JButton();
        del.setSize(50, 50);
        del.setLocation(780, 660);
        del.setIcon(imgPre1);
        del.addMouseListener(new MouseEvent());
        del.addActionListener(this);
        this.add(del);

        ImageIcon imagen5 = new ImageIcon(Save.class.getResource("/arkanoid/img/send.png"));
        Image conversion5 = imagen5.getImage();
        Image tamaño5 = conversion5.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon imgPre5 = new ImageIcon(tamaño5);
        send = new JButton();
        send.setSize(50, 50);
        send.setLocation(780, 580);
        send.setIcon(imgPre5);
        send.addMouseListener(new MouseEvent());
        send.addActionListener(this);
        this.add(send);

        ImageIcon imagen13 = new ImageIcon(GameOver.class.getResource("/arkanoid/img/num0.png"));
        Image conversion13 = imagen13.getImage();
        Image tamaño13 = conversion13.getScaledInstance(16, 20, Image.SCALE_SMOOTH);
        ImageIcon imgPre13 = new ImageIcon(tamaño13);

        int x2 = 305;
        int y2 = 95;

        // + (String.format("%06d", Statics.puntuacion).charAt(i) +
        for (int i = 0; i < 6; i++) {

            numPuntuacion = new JLabel();
            numPuntuacion.setSize(16, 20);
            numPuntuacion.setLocation(x2, y2);
            auxScore[i] = numPuntuacion;
            numPuntuacion.setIcon(imgPre13);
            add(numPuntuacion);
            x2 += 20;

        }
    }

    public class MouseEvent extends MouseAdapter {

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            if (e.getSource() == back) {
                back.setIcon(imgPre5);
            }
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            if (e.getSource() == back) {
                back.setIcon(imgPre4);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            if (winOver) {
                a.win.setVisible(true);
            } else {
                a.gameOver.setVisible(true);
            }
            this.setVisible(false);
            a.remove(a.save);
            this.removeAll();
        }

        if (e.getSource().getClass() == JButton.class) {
            if (e.getSource() != back && e.getSource() != del && e.getSource() != send) {
                if (cont < 10 && cont >= 0) {
                    ImageIcon imagen13 = new ImageIcon(
                            GameOver.class.getResource("/arkanoid/img/letra" + e.getActionCommand() + ".png"));
                    Image conversion13 = imagen13.getImage();
                    Image tamaño13 = conversion13.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    ImageIcon imgPre13 = new ImageIcon(tamaño13);
                    auxVacio[cont].setIcon(imgPre13);
                    if ((Integer.parseInt(e.getActionCommand())) + 65 >= 65
                            && (Integer.parseInt(e.getActionCommand())) + 65 < 91) {

                        Character a = (char) ((Integer.parseInt(e.getActionCommand())) + 65);
                        coleccion.add(a);
                    } else {
                        // espacio
                        if (Integer.parseInt(e.getActionCommand()) == 26) {
                            Character a = (char) (32);
                            coleccion.add(a);

                        }
                        // punto
                        if (Integer.parseInt(e.getActionCommand()) == 27) {
                            Character a = (char) (46);
                            coleccion.add(a);

                        }
                        // Exclamacion
                        if (Integer.parseInt(e.getActionCommand()) == 28) {
                            Character a = (char) (33);
                            coleccion.add(a);

                        }
                        // Interrogante
                        if (Integer.parseInt(e.getActionCommand()) == 29) {
                            Character a = (char) (63);
                            coleccion.add(a);

                        }
                        // Corchete izquierda
                        if (Integer.parseInt(e.getActionCommand()) == 30) {
                            Character a = (char) (91);
                            coleccion.add(a);

                        }
                        // Corchete derecha
                        if (Integer.parseInt(e.getActionCommand()) == 31) {
                            Character a = (char) (93);
                            coleccion.add(a);

                        }
                    }
                }
                if (cont < 10) {

                    cont++;
                }
            }
            if (e.getSource() == del && cont > 0) {
                cont--;
                auxVacio[cont].setIcon(imgPre1);
                coleccion.remove(coleccion.size() - 1);
            }

            if (e.getSource() == send) {
                for (int i = 0; i < coleccion.size(); i++) {
                    finalName += coleccion.get(i);
                }
                System.err.println(finalName);

                try (PrintWriter f1 = new PrintWriter(new FileWriter(f.getPath(), true))) {
                    f1.print(finalName+";"+Statics.puntuacion+"\n");
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "La base de datos no existe", "error",
                            JOptionPane.ERROR_MESSAGE);
                }


                if (winOver) {
                    a.win.setVisible(true);
                } else {
                    a.gameOver.setVisible(true);
                }
                this.setVisible(false);
                a.remove(a.save);
                this.removeAll();
                
            }
            // for (int i = 0; i < 10; i++) {

            // if((Integer.parseInt(auxVacio.))+81>=81 &&
            // (Integer.parseInt(e.getActionCommand()))+81<107){
            // System.err.println("LETRA");
            // }
            // }

            // }
            // }
            // if (e.getSource().getClass() == JButton.class) {
            // if (e.getSource() != back && e.getSource() != del && e.getSource() != send) {
            // if((Integer.parseInt(e.getActionCommand()))+81>=81 &&
            // (Integer.parseInt(e.getActionCommand()))+81<107){
            // System.err.println("LETRA");
            // }

            // }
            // }

        }

    }
}
