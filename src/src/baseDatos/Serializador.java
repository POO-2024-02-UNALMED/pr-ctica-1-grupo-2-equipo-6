package baseDatos;
import gestorAplicacion.gestion.Tienda;
import uiMain.Main;
import gestorAplicacion.gestion.Memorial;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serializador {
    private static void serializar(ArrayList<? extends Object> lista, String nombre) {

            File archivo = new File("");

            try {
                File path = new File(archivo.getAbsolutePath() + "/src/src/baseDatos/temp/" + nombre + ".txt");

                FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(lista);

                oos.close();
                fos.close();

            }catch(FileNotFoundException e) {

                System.out.println("No se encuentra el archivo ingresado");

            }catch(IOException e) {

                System.out.println("Error en el flujo de inicializacion");

            }
        }
    public static void serializarListas() {
            
            //metodos estaticos
            
            serializar(Main.centroAdopcions, "sedes");
            serializar(Memorial.osarios, "osarios");
            serializar(Memorial.cenizas, "cenizas");
            serializar(Memorial.arboles, "arboles");
            serializar(Tienda.productos, "productos");

        }
}