package arkanoid;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameOver extends JPanel implements ActionListener{
    JButton btnExit;
    JButton btnMenu;
    JButton btnAgain;
    Juego juego;
    Principal a;

    public GameOver(Principal a){
        setLayout(null);
        this.a=a;
        this.setBackground(Color.BLACK);

        // a.remove(juego);
        this.setVisible(true);
        btnAgain = new JButton("AGAIN");
        btnAgain.setSize(150,50);
        btnAgain.setLocation(200,500);
        btnAgain.addActionListener(this);
        add(btnAgain);
        btnMenu = new JButton("MENU");
        btnMenu.setSize(150,50);
        btnMenu.setLocation(400,500);
        btnMenu.addActionListener(this);
        add(btnMenu);
        btnExit = new JButton("EXIT");
        btnExit.setSize(150,50);
        btnExit.setLocation(600,500);
        btnExit.addActionListener(this);
        add(btnExit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAgain){
            juego = new Juego(a);
            juego.setSize(1000,1000);
            juego.setVisible(true);
            a.add(juego);
            // Principal.juego.setVisible(true);
            this.setVisible(false);
        }
        
    }
}
