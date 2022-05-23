package arkanoid;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Low extends JLabel implements ActionListener{
    Principal p;
    Timer timer;
    boolean move = false;


    Low(Principal p){
        this.p = p;
        timer = new Timer(100, this);
        timer.start();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer && move){
            this.setLocation(this.getX(), this.getY()+10);
        }      
        
    }
    
}
