package arkanoid;

import javax.swing.JFrame;

public class Principal extends JFrame{
    
    public static Juego juego;

    Principal(){

        juego = new Juego();
        juego.setSize(1000,1000);
        juego.setVisible(true);
        add(juego);
    }

}
