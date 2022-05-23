package arkanoid;

import java.awt.Color;
import java.awt.PageAttributes.ColorType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Low extends JLabel implements ActionListener{
    PowerUp p;
    Timer power;
    JLabel low;
    boolean NuevoPower = false;
    boolean move = false;

    Low(PowerUp p){
        this.p = p;
        this.setOpaque(true);
        this.setBackground(Color.GREEN);
        power = new Timer(100, this);
        power.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(NuevoPower){
    
        }
        if (e.getSource() == power && move){
            this.setLocation(this.getX(), this.getY()+10);
        }      
        
    }
    
}
