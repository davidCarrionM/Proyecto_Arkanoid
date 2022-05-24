package arkanoid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Principal extends JFrame implements ActionListener{
    
    Timer tiempo;
    int contTiempo = 0;
    String titulo = "Arkanoid";
    String tituloAux = "";
    public static Menu menu;
    public static Juego juego;
    public static GameOver gameOver;
    static boolean eliminar = false;

    public Principal(){
        super("Arkanoid");

        tiempo = new Timer(300, this);
        tiempo.start();
        juego = new Juego(this);
        juego.setSize(1000,1000);
        juego.setVisible(false);
        add(juego);
        menu = new Menu(this);
        menu.setSize(1000,1000);
        menu.setVisible(true);
        add(menu);
        // gameOver = new GameOver(this);
        // gameOver.setSize(1000,1000);
        // gameOver.setVisible(false);
        // add(gameOver);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tiempo) {
           
            if (contTiempo == 0) {
                contTiempo = titulo.length() + 4;
                Principal.super.setTitle(" -- "+Principal.super.getTitle());
                tituloAux = " -- "+tituloAux;
            }
            if (contTiempo <= titulo.length()) {
                tituloAux = titulo.charAt(contTiempo - 1) + tituloAux;
                Principal.super.setTitle(tituloAux);
            }
            contTiempo--;


            // if(eliminar){
            //     this.remove(juego);
            //     eliminar = false;
            // }
        }
        
    }

}
