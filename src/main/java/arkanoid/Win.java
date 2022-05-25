package arkanoid;

import java.awt.Color;

import javax.swing.JPanel;

public class Win extends JPanel{
    Principal p;

    Win(Principal p){
        this.p=p;
        this.setBackground(Color.YELLOW);
    }

}
