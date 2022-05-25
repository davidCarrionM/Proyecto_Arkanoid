package arkanoid;

import javax.swing.JLabel;

import arkanoid.poderes.*;

public class PowerUp extends JLabel {
    Juego p;
    int XLadrillo;
    int YLadrillo;
    public Tall tall;
    public Low low;
    public Explote explote;
    public Bad bad;
    public Speed speed;
    public Sticky sticky;

    PowerUp(Juego p) {
        this.p = p;
    }

    public void gestionar() {
        int gestion = (int) (Math.random() * 100);

        if (p.bola.flagEmpezar) {

            if (gestion >= 0 && gestion < 10) {
                tall = new Tall(p);
                tall.setSize(30, 30);
                tall.setLocation(XLadrillo + 22, YLadrillo + 7);
                p.add(tall, 1);
                tall.setVisible(false);
                tall.setVisible(true);
                tall.move = true;
            } else {
                if (gestion >= 10 && gestion < 20) {
                    low = new Low(p);
                    low.setSize(30, 30);
                    low.setLocation(XLadrillo + 22, YLadrillo + 7);
                    p.add(low, 1);
                    low.setVisible(false);
                    low.setVisible(true);
                    low.move = true;
                } else {
                    if (gestion >= 20 && gestion < 30) {
                        explote = new Explote(p);
                        explote.setSize(30, 30);
                        explote.setLocation(XLadrillo + 22, YLadrillo + 7);
                        p.add(explote, 1);
                        explote.setVisible(false);
                        explote.setVisible(true);
                        explote.move = true;
                    } else {
                        if (gestion >= 30 && gestion < 40) {
                            bad = new Bad(p);
                            bad.setSize(30, 30);
                            bad.setLocation(XLadrillo + 22, YLadrillo + 7);
                            p.add(bad, 1);
                            bad.setVisible(false);
                            bad.setVisible(true);
                            bad.move = true;
                        } else {
                            if (gestion >= 40 && gestion < 50) {
                                speed = new Speed(p);
                                speed.setSize(30, 30);
                                speed.setLocation(XLadrillo + 22, YLadrillo + 7);
                                p.add(speed, 1);
                                speed.setVisible(false);
                                speed.setVisible(true);
                                speed.move = true;
                            } else {
                                if (gestion >= 50 && gestion < 60) {
                                    sticky = new Sticky(p);
                                    sticky.setSize(30, 30);
                                    sticky.setLocation(XLadrillo + 22, YLadrillo + 7);
                                    p.add(sticky, 1);
                                    sticky.setVisible(false);
                                    sticky.setVisible(true);
                                    sticky.move = true;
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
