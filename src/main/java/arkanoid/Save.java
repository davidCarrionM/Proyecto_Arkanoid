package arkanoid;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Save extends JPanel implements ActionListener{
    JButton letra;
    JButton back;
    JLabel vacio;
    Principal a;
    JLabel highScore;
    JLabel score;
    JLabel name;
    JLabel nameRegis;
    boolean winOver;
    ImageIcon imagen4 = new ImageIcon(Ladrillo.class.getResource("/arkanoid/img/back.png"));
    Image conversion4 = imagen4.getImage();
    Image tamaño4 = conversion4.getScaledInstance(200, 40, Image.SCALE_SMOOTH);
    ImageIcon imgPre4 = new ImageIcon(tamaño4);
    ImageIcon imagen5 = new ImageIcon(Ladrillo.class.getResource("/arkanoid/img/back+.png"));
    Image conversion5 = imagen5.getImage();
    Image tamaño5 = conversion5.getScaledInstance(200, 40, Image.SCALE_SMOOTH);
    ImageIcon imgPre5 = new ImageIcon(tamaño5);

    public Save(Principal a) {
        this.setLayout(null);
        this.setBackground(Color.black);
        this.a = a;

        int x1 = 330;
        int y1 = 350;
        for (int i = 0; i < 10; i++) {
            ImageIcon imagen1 = new ImageIcon(Save.class.getResource("/arkanoid/img/vacio.png"));
            Image conversion1 = imagen1.getImage();
            Image tamaño1 = conversion1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon imgPre1 = new ImageIcon(tamaño1);
            vacio = new JLabel();
            vacio.setSize(50, 50);
            vacio.setLocation(x1, y1);
            vacio.setIcon(imgPre1);
            this.add(vacio);
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
            letra.setActionCommand(i + "1");
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
            if(winOver){
                a.win.setVisible(true);
            }else{
                a.gameOver.setVisible(true);
            }
            this.setVisible(false);
            a.remove(a.save);
            this.removeAll();

        }
        
    }
}
