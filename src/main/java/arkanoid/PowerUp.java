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
        
        if(gestion>=0 && gestion<=20){
            System.out.println("Crea");
            
            low = new Low(p);
            low.setSize(20,10);
            low.setLocation(XLadrillo+22, YLadrillo+7);
            low.setOpaque(true);
            low.setBackground(Color.green);
            p.getContentPane().doLayout();
            p.add(low,1);
             low.setVisible(false);
            low.setVisible(true);
        }else{
            if(gestion>20 && gestion<=40){
                System.out.println("Crea");
                
                low = new Low(p);
                low.setSize(20,10);
                low.setLocation(XLadrillo+22, YLadrillo+7);
                low.setOpaque(true);
                low.setBackground(Color.yellow);
                p.getContentPane().doLayout();
                p.add(low,1);
                 low.setVisible(false);
                low.setVisible(true);
            }else{
                
            }
        }

    }    
}
