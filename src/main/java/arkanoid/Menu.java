package arkanoid;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener {
    JButton btnExit;
    JButton btnMenu;
    JButton btnStart;
    Juego juego;
    Principal a;

    public Menu(Principal a) {
        setLayout(null);
        this.a = a;
        this.setBackground(Color.BLACK);

        btnStart = new JButton("Start");
        btnStart.setSize(150, 50);
        btnStart.setLocation(200, 500);
        btnStart.addActionListener(this);
        add(btnStart);
        btnMenu = new JButton("MENU");
        btnMenu.setSize(150, 50);
        btnMenu.setLocation(200, 700);
        btnMenu.addActionListener(this);
        add(btnMenu);
        btnExit = new JButton("EXIT");
        btnExit.setSize(150, 50);
        btnExit.setLocation(200, 900);
        btnExit.addActionListener(this);
        add(btnExit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) {
            juego = new Juego(a);
            juego.setSize(1000, 1000);
            juego.setVisible(true);
            a.add(juego);
            this.setVisible(false);
        }
    }
}
