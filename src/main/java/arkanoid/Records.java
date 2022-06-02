package arkanoid;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


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

    Records(Principal a) {
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

        ImageIcon imagen13 = new ImageIcon(GameOver.class.getResource("/arkanoid/img/num0.png"));
        Image conversion13 = imagen13.getImage();
        Image tamaño13 = conversion13.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon imgPre13 = new ImageIcon(tamaño13);
        ImageIcon imagen14 = new ImageIcon(GameOver.class.getResource("/arkanoid/img/letra.png"));
        Image conversion14 = imagen14.getImage();
        Image tamaño14 = conversion14.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon imgPre14 = new ImageIcon(tamaño14);
        
        ArrayList<ObjetoRecord> objetos = new ArrayList<ObjetoRecord>();
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        ArrayList<String> cadenas = new ArrayList<String>();
        String cadena;
        
        String[] split = new String[2];
        try (Scanner f1 = new Scanner(new File(f.getPath()))) {
            while (f1.hasNext()) {
                ObjetoRecord ob = new ObjetoRecord();
                cadena = f1.nextLine();
                cadenas.add(cadena);
                split = cadena.split(";");
                numeros.add(Integer.parseInt(split[1]));                
                
                ob.nombre = split[0];
                ob.puntuacion =  Integer.parseInt(split[1]);
                objetos.add(ob);
            }
        } catch (IOException e) {
            System.err.println("Error de acceso al archivo: " + e.getMessage());
        }
        String[] ffinal = new String[5];

        int maximo = 0;
        

        //BURBUJA
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

        System.err.println("Hola");

        System.out.println(objetos.get(1).nombre+";"+objetos.get(1).puntuacion);
        for (int i = 0; i < objetos.size(); i++) {
            System.out.println(objetos.get(i).nombre+";"+objetos.get(i).puntuacion);
        }


        // //BURBUJA
        // for (int limit = numeros.size() - 1; limit > 0; limit--) {
        //     for (int firstIndex = 0; firstIndex < limit; firstIndex++) {
        //         int secondIndex = firstIndex + 1;
        //         if (numeros.get(firstIndex) > numeros.get(secondIndex)) {
        //             int first = numeros.get(firstIndex);
        //             int second = numeros.get(secondIndex);
        //             numeros.set(firstIndex, second);
        //             numeros.set(secondIndex, first);
        //         }
        //     }
        // }
        


        // for (int i = 0; i < numeros.size(); i++) {
        //     System.out.println(numeros.get(i));
        // }
        // System.out.println("--------------------------------");

        // for (int i = 0; i < 5; i++) {
            
        //     for (int j = 0; j < numeros.size(); j++) {
        //         split = cadenas.get(j).split(";");
        //         if( numeros.get(numeros.size()-j-1) == 400){
        //             //Integer.parseInt(split[1])
        //             ffinal[0]=cadenas.get(j);
        //         } 
        //     }
        //     System.out.println(ffinal[i]);

        // }

        int x = 100;
        int y = 450;
        int x2 = 230;
        int y2 = 450;
        int x3 = 520;
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
                numPuntuacion = new JLabel();
                numPuntuacion.setSize(30, 30);
                numPuntuacion.setLocation(x2, y2);
                numPuntuacion.setIcon(imgPre13);
                add(numPuntuacion);
                x2 += 40;
            }
            y2 += 95;
            x2 = 230;

            for (int j = 0; j < 10; j++) {
                posLetra = new JLabel();
                posLetra.setSize(30, 30);
                posLetra.setLocation(x3, y3);
                posLetra.setIcon(imgPre14);
                add(posLetra);
                x3 += 33;
            }
            y3 += 95;
            x3 = 520;
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
            a.menu.setVisible(true);
        }
    }

}
