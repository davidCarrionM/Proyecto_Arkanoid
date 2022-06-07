package arkanoid.acciones;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import arkanoid.Menu;
import arkanoid.Principal;
import arkanoid.Statics;
import arkanoid.objetos.Ladrillo;

public class Records extends JPanel implements ActionListener {
    Principal a;
    JLabel numPuntuacion;
    JLabel posLetra;
    JLabel top;
    JLabel subTitulo;
    JLabel cabecera;
    JLabel num;
    JButton back;
    ImageIcon imagen4 = new ImageIcon(Ladrillo.class.getResource("/arkanoid/img/back.png"));
    Image conversion4 = imagen4.getImage();
    Image tamaño4 = conversion4.getScaledInstance(200, 40, Image.SCALE_SMOOTH);
    ImageIcon imgPre4 = new ImageIcon(tamaño4);
    ImageIcon imagen5 = new ImageIcon(Ladrillo.class.getResource("/arkanoid/img/back+.png"));
    Image conversion5 = imagen5.getImage();
    Image tamaño5 = conversion5.getScaledInstance(200, 40, Image.SCALE_SMOOTH);
    ImageIcon imgPre5 = new ImageIcon(tamaño5);
    File f = new File(System.getProperty("user.home") + "/arkanoid_records.txt");

    public Records(Principal a) {
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.a = a;

        ImageIcon imagen2 = new ImageIcon(Menu.class.getResource("/arkanoid/img/topTitulo.png"));
        Image conversion2 = imagen2.getImage();
        Image tamaño2 = conversion2.getScaledInstance(800, 80, Image.SCALE_SMOOTH);
        ImageIcon imgPre2 = new ImageIcon(tamaño2);
        top = new JLabel();
        top.setSize(800, 80);
        top.setLocation(90, 80);
        top.setIcon(imgPre2);
        add(top);

        ArrayList<ObjetoRecord> objetos = new ArrayList<ObjetoRecord>();
        String cadena;
        String[] split = new String[2];
        try (Scanner f1 = new Scanner(new File(f.getPath()))) {
            while (f1.hasNext()) {
                ObjetoRecord ob = new ObjetoRecord();
                cadena = f1.nextLine();
                split = cadena.split(";");
                ob.nombre = split[0];
                ob.puntuacion = Integer.parseInt(split[1]);
                objetos.add(ob);
            }
        } catch (IOException e) {
            System.err.println("Error de acceso al archivo: " + e.getMessage());
        }
        // BURBUJA
        for (int limit = objetos.size() - 1; limit > 0; limit--) {
            for (int firstIndex = 0; firstIndex < limit; firstIndex++) {
                int secondIndex = firstIndex + 1;
                if (objetos.get(firstIndex).puntuacion > objetos.get(secondIndex).puntuacion) {
                    ObjetoRecord first = objetos.get(firstIndex);
                    ObjetoRecord second = objetos.get(secondIndex);
                    objetos.set(firstIndex, second);
                    objetos.set(secondIndex, first);
                }
            }
        }

        Statics.record = objetos.get(objetos.size() - 1).puntuacion;

        int x = 100;
        int y = 450;
        int x2 = 230;
        int y2 = 450;
        int x3 = 530;
        int y3 = 450;
        for (int i = 0; i < 5; i++) {
            ImageIcon imagen1 = new ImageIcon(Records.class.getResource("/arkanoid/img/num" + (i + 1) + ".png"));
            Image conversion1 = imagen1.getImage();
            Image tamaño1 = conversion1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            ImageIcon imgPre1 = new ImageIcon(tamaño1);
            num = new JLabel();
            num.setSize(40, 40);
            num.setLocation(x, y);
            num.setIcon(imgPre1);
            this.add(num);
            y += 95;

            for (int j = 0; j < 6; j++) {
                ImageIcon imagen11 = new ImageIcon(Records.class.getResource("/arkanoid/img/num"
                        + (String.format("%06d", objetos.get(objetos.size() - i - 1).puntuacion).charAt(j) + ".png")));
                Image conversion11 = imagen11.getImage();
                Image tamaño11 = conversion11.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                ImageIcon imgPre11 = new ImageIcon(tamaño11);
                numPuntuacion = new JLabel();
                numPuntuacion.setSize(30, 30);
                numPuntuacion.setLocation(x2, y2);
                numPuntuacion.setIcon(imgPre11);
                add(numPuntuacion);
                x2 += 40;
            }
            y2 += 95;
            x2 = 230;

            for (int j = 0; j < 10; j++) {
                char auxLetra = (String.format("%-10s", objetos.get(objetos.size() - i - 1).nombre).charAt(j));
                if (auxLetra == '?') {
                    auxLetra = '1';
                }
                ImageIcon imagen11 = new ImageIcon(
                        Records.class.getResource("/arkanoid/img/letras/letra" + (auxLetra) + ".png"));
                Image conversion11 = imagen11.getImage();
                Image tamaño11 = conversion11.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
                ImageIcon imgPre11 = new ImageIcon(tamaño11);
                posLetra = new JLabel();
                posLetra.setSize(30, 30);
                posLetra.setLocation(x3, y3);
                posLetra.setIcon(imgPre11);
                add(posLetra);
                x3 += 33;
            }
            y3 += 95;
            x3 = 530;
        }

        ImageIcon imagen = new ImageIcon(Menu.class.getResource("/arkanoid/img/subTituloR.png"));
        Image conversion = imagen.getImage();
        Image tamaño = conversion.getScaledInstance(800, 150, Image.SCALE_SMOOTH);
        ImageIcon imgPre = new ImageIcon(tamaño);
        subTitulo = new JLabel();
        subTitulo.setSize(800, 150);
        subTitulo.setLocation(90, 200);
        subTitulo.setIcon(imgPre);
        add(subTitulo);
        ImageIcon imagen3 = new ImageIcon(Menu.class.getResource("/arkanoid/img/cabecera.png"));
        Image conversion3 = imagen3.getImage();
        Image tamaño3 = conversion3.getScaledInstance(650, 50, Image.SCALE_SMOOTH);
        ImageIcon imgPre3 = new ImageIcon(tamaño3);
        cabecera = new JLabel();
        cabecera.setSize(650, 50);
        cabecera.setLocation(50, 380);
        cabecera.setIcon(imgPre3);
        add(cabecera);
        back = new JButton();
        back.setSize(200, 40);
        back.setLocation(50, 40);
        back.setIcon(imgPre4);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.addMouseListener(new MouseEvent());
        back.addActionListener(this);
        this.add(back);
    }

    public class MouseEvent extends MouseAdapter {

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            if (e.getSource() == back) {
                back.setIcon(imgPre5);
            }
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            if (e.getSource() == back) {
                back.setIcon(imgPre4);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.setVisible(false);
            this.removeAll();
            a.menu.setVisible(true);
        }
    }

}
