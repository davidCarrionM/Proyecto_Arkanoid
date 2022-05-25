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

public class Win extends JPanel implements ActionListener {
    Principal p;
    JButton btnExit;
    JButton btnMenu;
    JButton btnAgain;
    Juego juego;
    JLabel highScore;
    JButton btnSave;
    JLabel lblWin;
    Principal a;
    ImageIcon imagen2 = new ImageIcon(Menu.class.getResource("/arkanoid/img/play.png"));
    Image conversion2 = imagen2.getImage();
    Image tamaño2 = conversion2.getScaledInstance(220, 60, Image.SCALE_SMOOTH);
    ImageIcon imgPre2 = new ImageIcon(tamaño2);

    ImageIcon imagen3 = new ImageIcon(Menu.class.getResource("/arkanoid/img/exit.png"));
    Image conversion3 = imagen3.getImage();
    Image tamaño3 = conversion3.getScaledInstance(220, 60, Image.SCALE_SMOOTH);
    ImageIcon imgPre3 = new ImageIcon(tamaño3);

    ImageIcon imagen4 = new ImageIcon(Menu.class.getResource("/arkanoid/img/play+.png"));
    Image conversion4 = imagen4.getImage();
    Image tamaño4 = conversion4.getScaledInstance(220, 60, Image.SCALE_SMOOTH);
    ImageIcon imgPre4 = new ImageIcon(tamaño4);

    ImageIcon imagen5 = new ImageIcon(Menu.class.getResource("/arkanoid/img/exit+.png"));
    Image conversion5 = imagen5.getImage();
    Image tamaño5 = conversion5.getScaledInstance(220, 60, Image.SCALE_SMOOTH);
    ImageIcon imgPre5 = new ImageIcon(tamaño5);

    ImageIcon imagen6 = new ImageIcon(Menu.class.getResource("/arkanoid/img/menu.png"));
    Image conversion6 = imagen6.getImage();
    Image tamaño6 = conversion6.getScaledInstance(220, 60, Image.SCALE_SMOOTH);
    ImageIcon imgPre6 = new ImageIcon(tamaño6);

    ImageIcon imagen7 = new ImageIcon(Menu.class.getResource("/arkanoid/img/menu+.png"));
    Image conversion7 = imagen7.getImage();
    Image tamaño7 = conversion7.getScaledInstance(220, 60, Image.SCALE_SMOOTH);
    ImageIcon imgPre7 = new ImageIcon(tamaño7);

    ImageIcon imagen8 = new ImageIcon(Menu.class.getResource("/arkanoid/img/win.png"));
    Image conversion8 = imagen8.getImage();
    Image tamaño8 = conversion8.getScaledInstance(500, 270, Image.SCALE_SMOOTH);
    ImageIcon imgPre8 = new ImageIcon(tamaño8);

    ImageIcon imagen9 = new ImageIcon(Menu.class.getResource("/arkanoid/img/save.png"));
    Image conversion9 = imagen9.getImage();
    Image tamaño9 = conversion9.getScaledInstance(200, 90, Image.SCALE_SMOOTH);
    ImageIcon imgPre9 = new ImageIcon(tamaño9);

    ImageIcon imagen10 = new ImageIcon(Menu.class.getResource("/arkanoid/img/save+.png"));
    Image conversion10 = imagen10.getImage();
    Image tamaño10 = conversion10.getScaledInstance(200, 90, Image.SCALE_SMOOTH);
    ImageIcon imgPre10 = new ImageIcon(tamaño10);

    Win(Principal a) {
        setLayout(null);
        this.p = p;
        this.setBackground(Color.YELLOW);
        this.a = a;
        this.setBackground(Color.BLACK);

        lblWin = new JLabel();
        lblWin.setSize(500, 270);
        lblWin.setLocation(250, 250);
        lblWin.setIcon(imgPre8);
        add(lblWin);
        this.setVisible(true);
        btnAgain = new JButton();
        btnAgain.setSize(220, 50);
        btnAgain.setLocation(90, 700);
        btnAgain.addActionListener(this);
        btnAgain.setFocusPainted(false);
        btnAgain.setBorderPainted(false);
        btnAgain.setContentAreaFilled(false);
        btnAgain.setIcon(imgPre2);
        btnAgain.addMouseListener(new MouseEvent());
        add(btnAgain);

        btnMenu = new JButton("MENU");
        btnMenu.setSize(220, 50);
        btnMenu.setLocation(390, 700);
        btnMenu.addActionListener(this);
        btnMenu.setFocusPainted(false);
        btnMenu.setBorderPainted(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setIcon(imgPre6);
        btnMenu.addMouseListener(new MouseEvent());
        add(btnMenu);

        btnExit = new JButton("EXIT");
        btnExit.setSize(220, 50);
        btnExit.setLocation(690, 700);
        btnExit.addActionListener(this);
        btnExit.setIcon(imgPre3);
        btnExit.setFocusPainted(false);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.addMouseListener(new MouseEvent());
        add(btnExit);
        ImageIcon imagen0 = new ImageIcon(HighScore.class.getResource("/arkanoid/img/highscore.jpg"));
        Image conversion0 = imagen0.getImage();
        Image tamaño0 = conversion0.getScaledInstance(270, 100, Image.SCALE_SMOOTH);
        ImageIcon imgPre0 = new ImageIcon(tamaño0);
        highScore = new JLabel();
        highScore.setSize(270, 100);
        highScore.setLocation(480, 30);
        highScore.setIcon(imgPre0);
        add(highScore);
        btnSave = new JButton("SAVE");
        btnSave.setSize(200, 90);
        btnSave.setLocation(50 , 50);
        btnSave.addActionListener(this);
        btnSave.setFocusPainted(false);
        btnSave.setBorderPainted(false);
        btnSave.setContentAreaFilled(false);
        btnSave.setIcon(imgPre9);
        btnSave.addMouseListener(new MouseEvent());
        add(btnSave);

    }

    public class MouseEvent extends MouseAdapter {

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            if (e.getSource() == btnAgain) {
                btnAgain.setIcon(imgPre4);
            }
            if (e.getSource() == btnExit) {
                btnExit.setIcon(imgPre5);
            }
            if (e.getSource() == btnMenu) {
                btnMenu.setIcon(imgPre7);
            }
            if(e.getSource()== btnSave){
                btnSave.setIcon(imgPre10);
            }
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            if (e.getSource() == btnAgain) {
                btnAgain.setIcon(imgPre2);
            }
            if (e.getSource() == btnExit) {
                btnExit.setIcon(imgPre3);
            }
            if (e.getSource() == btnMenu) {
                btnMenu.setIcon(imgPre6);
            }
            if(e.getSource()== btnSave){
                btnSave.setIcon(imgPre9);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgain) {
            juego = new Juego(a);
            juego.setSize(1000, 1000);
            juego.setVisible(true);
            a.add(juego);
            // Principal.juego.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == btnMenu) {
            a.menu.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }
}
