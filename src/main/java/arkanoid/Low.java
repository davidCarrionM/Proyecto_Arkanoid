package arkanoid;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Low extends JLabel implements ActionListener{
    Principal p;
    Timer power;
    JLabel low;
    boolean NuevoPower = false;
    boolean move = false;

    Low(Principal p){
        this.p = p;
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
