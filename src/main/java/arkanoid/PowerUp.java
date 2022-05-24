package arkanoid;


import java.awt.Color;

import javax.swing.JLabel;

public class PowerUp extends JLabel {
    Principal p;
    int XLadrillo;
    int YLadrillo;
    Tall tall;
    Low low;
    Explote explote;
    PowerUp(Principal p){
        this.p = p;
    }

    public void gestionar(){
        int gestion = (int) (Math.random()*100);
        
        if(gestion>=0 && gestion<10){
            System.out.println("Crea");
            
            tall = new Tall(p);
            tall.setSize(30,30);
            tall.setLocation(XLadrillo+22, YLadrillo+7);
            p.getContentPane().doLayout();
            p.add(tall,1);
            tall.setVisible(false);
            tall.setVisible(true);
            tall.move = true;
        }else{
            if(gestion>=10 && gestion<20){
                low = new Low(p);
                low.setSize(30,30);
                low.setLocation(XLadrillo+22, YLadrillo+7);
                p.getContentPane().doLayout();
                p.add(low,1);
                 low.setVisible(false);
                low.setVisible(true);
                low.move = true;
            }else{
                if(gestion>=20 && gestion<30){
                    explote = new Explote(p);
                    explote.setSize(30,30);
                    explote.setLocation(XLadrillo+22, YLadrillo+7);
                    p.getContentPane().doLayout();
                    p.add(explote,1);
                    explote.setVisible(false);
                    explote.setVisible(true);
                    explote.move = true;
                }
            }
        }

    }    
}
