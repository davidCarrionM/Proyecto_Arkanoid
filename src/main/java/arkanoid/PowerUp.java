package arkanoid;


import java.awt.Color;

import javax.swing.JLabel;

public class PowerUp extends JLabel {
    Principal p;
    int XLadrillo;
    int YLadrillo;
    Low low;

    PowerUp(Principal p){
    this.p = p;

    }

    public void gestionar(){
        int gestion = (int) (Math.random()*100);
        
        if(gestion>=0 && gestion<=49){
            System.out.println("Crea");
            
            
            low = new Low(this);
            low.setSize(200,200);
            low.setLocation(1500, 400);
            p.add(low);
        }else{
            System.out.println("NO Crea");
            
        }

    }    
}
