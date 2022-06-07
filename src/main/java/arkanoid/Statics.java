package arkanoid;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Statics {
    public static int puntuacion;
    public static int record;
    public static int time;
    File f = new File(System.getProperty("user.home") + "/arkanoid_records.txt");

    Statics() {
        if (f.exists()) {

        } else {
            try (PrintWriter f1 = new PrintWriter(new FileWriter(f.getPath(), true))) {
                for (int i = 0; i < 5; i++) {
                    f1.print("AAAAAAAAAA" + ";" + "0" + "\n");
                }
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "La base de datos no existe", "error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

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
    }
}
