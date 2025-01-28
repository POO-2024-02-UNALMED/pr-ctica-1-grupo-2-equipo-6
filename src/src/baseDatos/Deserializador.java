package baseDatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import gestorAplicacion.elementos.CentroAdopcion;
import gestorAplicacion.elementos.Fallecido;
import gestorAplicacion.elementos.Producto;
public class Deserializador {

    public static ArrayList<CentroAdopcion> deserializarCentrosAdopcion() {
        try {
            FileInputStream fi = new FileInputStream("src/src/baseDatos/temp/sedes.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            ArrayList<CentroAdopcion> centrosAdopcion = (ArrayList<CentroAdopcion>) oi.readObject();
            oi.close();
            fi.close();
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
    public static ArrayList<Producto> deserializarProductos() {
        try {
            FileInputStream fi = new FileInputStream("src/src/baseDatos/temp/productos.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            ArrayList<Producto> productos = (ArrayList<Producto>) oi.readObject();
            oi.close();
            fi.close();
            return productos;
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo ingresado");
        } catch (IOException e) {
            System.out.println("Error en el flujo de inicialización.");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada.");
        }
        return null;
    }
    public static ArrayList<Fallecido> deserializarOsarios() {
        try {
            FileInputStream fi = new FileInputStream("src/src/baseDatos/temp/osarios.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            ArrayList<Fallecido> osarios = (ArrayList<Fallecido>) oi.readObject();
            oi.close();
            fi.close();
            return osarios;
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo ingresado");
        } catch (IOException e) {
            System.out.println("Error en el flujo de inicialización.");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada.");
        }
        return null;
    }
    public static ArrayList<Fallecido> deserializarArboles() {
        try {
            FileInputStream fi = new FileInputStream("src/src/baseDatos/temp/arboles.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            ArrayList<Fallecido> arboles = (ArrayList<Fallecido>) oi.readObject();
            oi.close();
            fi.close();
            return arboles;
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo ingresado");
        } catch (IOException e) {
            System.out.println("Error en el flujo de inicialización.");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada.");
        }
        return null;
    }
    public static ArrayList<Fallecido> deserializarCenizas() {
        try {
            FileInputStream fi = new FileInputStream("src/src/baseDatos/temp/cenizas.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            ArrayList<Fallecido> cenizas = (ArrayList<Fallecido>) oi.readObject();
            oi.close();
            fi.close();
            return cenizas;
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