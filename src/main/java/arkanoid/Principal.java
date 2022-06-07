package arkanoid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.Timer;

import arkanoid.acciones.GameOver;
import arkanoid.acciones.Juego;
import arkanoid.acciones.Records;
import arkanoid.acciones.Save;
import arkanoid.acciones.Win;

public class Principal extends JFrame implements ActionListener{
    
    Timer tiempo;
    int contTiempo = 0;
    String titulo = "Arkanoid";
    String tituloAux = "";
    public  Menu menu;
    public  Juego juego; 
    public  GameOver gameOver;
    public  Win win;
    public Records records;
    public  Save save;
    boolean eliminar = false;
    Statics clasesEstaticas = new Statics();
    File f = new File(System.getProperty("user.home")+"/arkanoid_records.txt");


    public Principal(){
        super("Arkanoid");

        tiempo = new Timer(300, this);
        tiempo.start();
        menu = new Menu(this);
        menu.setSize(1000,1000);
        menu.setVisible(true);
        add(menu);
        gameOver = new GameOver(this);
        gameOver.setSize(1000,1000);
        gameOver.setVisible(false);
        add(gameOver);
        win = new Win(this);
        win.setSize(1000,1000);
        win.setVisible(false);
        add(win);
        save = new Save(this);
        save.setSize(1000,1000);
        save.setVisible(false);
        add(save);

        
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


            if(eliminar){
                this.remove(juego);
                this.juego.setVisible(false);
                eliminar = false;
            }
        }
        
    }

}
