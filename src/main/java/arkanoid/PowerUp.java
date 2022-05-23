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
            
            
            low = new Low(p);
            low.setSize(20,10);
            low.setLocation(XLadrillo, YLadrillo);
            low.setBackground(Color.green);
            p.getContentPane().doLayout();
            low.
            p.add(low);
            low.setVisible(false);
            low.setVisible(true);
        }else{
            System.out.println("NO Crea");
            
        }

    }    
}
