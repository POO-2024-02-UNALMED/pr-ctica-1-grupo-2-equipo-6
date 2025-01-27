package baseDatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import gestorAplicacion.elementos.CentroAdopcion;

public class Deserializador {

    public static ArrayList<CentroAdopcion> deserializarCentrosAdopcion() {
        try {
            FileInputStream fi = new FileInputStream("src/src/baseDatos/temp/sedes.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            ArrayList<CentroAdopcion> centrosAdopcion = (ArrayList<CentroAdopcion>) oi.readObject();
            oi.close();
            fi.close();
            System.out.println("Deserialización exitosa. Número de centros de adopción: " + centrosAdopcion.size());
            return centrosAdopcion;
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo ingresado");
        } catch (IOException e) {
            System.out.println("Error en el flujo de inicialización.");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada.");
        }
        return null;
    }

}