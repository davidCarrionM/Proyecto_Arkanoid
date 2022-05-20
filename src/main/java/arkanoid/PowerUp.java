package arkanoid;


import java.awt.Color;

import javax.swing.JLabel;

public class PowerUp extends JLabel {
    Principal p;
    JLabel low;
    int XLadrillo;
    int YLadrillo;

    PowerUp(Principal p){
    this.p = p;

    }

    public void gestionar(){
        int gestion = (int) (Math.random()*100);
        
        if(gestion>=0 && gestion<=49){
            System.out.println("Crea");
            // p.low.NuevoPower = true;
            
            p.low = new Low(p);
            p.low.setSize(200,200);
            p.low.setLocation(p.powerUp.XLadrillo, p.powerUp.YLadrillo);
            p.low.setOpaque(true);
            p.low.setBackground(Color.white);
            p.low.setVisible(true);
            p.add(p.low);
            // System.err.println("NUEVO LOW");
            // NuevoPower = false;
            // move = true;
        }else{
            System.out.println("NO Crea");
            
        }

    }    
}
