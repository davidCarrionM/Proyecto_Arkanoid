package arkanoid;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Save extends JPanel {
    JLabel letra;
    Principal a;
    public Save(Principal a) {
        this.setLayout(null);
        this.setBackground(Color.black);
        this.a=a;

        int x = 144;
        int y = 250;
        for (int i = 0; i < 32; i++) {
            ImageIcon imagen = new ImageIcon(Ladrillo.class.getResource("/arkanoid/img/letra" + i + ".png"));
            Image conversion = imagen.getImage();
            Image tamaño = conversion.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon imgPre = new ImageIcon(tamaño);
            letra = new JLabel();
            letra.setSize(50, 50);
            letra.setLocation(x, y);
            letra.setIcon(imgPre);
            this.add(letra);

            if ((i + 1) % 8 == 0) {
                x = 144;
                y += 26;
            } else {
                x += 70;
            }
        }
    }
}
