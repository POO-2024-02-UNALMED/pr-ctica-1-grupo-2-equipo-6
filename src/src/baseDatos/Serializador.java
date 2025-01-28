package baseDatos;

import gestorAplicacion.elementos.CentroAdopcion;
import gestorAplicacion.elementos.Cliente;
import gestorAplicacion.elementos.Empleado;
import gestorAplicacion.elementos.Mascota;
import gestorAplicacion.elementos.Producto;
import gestorAplicacion.elementos.Fallecido;
import gestorAplicacion.gestion.Tienda;
import gestorAplicacion.gestion.Memorial;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serializador {

    public static void main(String[] args){
        ArrayList<CentroAdopcion> centrosAdopcion = new ArrayList<>();
        
        // Crear y agregar los centros de adopción
        CentroAdopcion centro1 = new CentroAdopcion("Centro de Adopción Medellín");
        centro1.setSede(CentroAdopcion.Sedes.MEDELLIN.name());
        centro1.agregarVeterinario(new Empleado("Carlos", 30, 123456789, 300123456, null, Empleado.Especialidad.VETERINARIO));
        centro1.agregarVeterinario(new Empleado("Ana", 35, 234567890, 310234567, null, Empleado.Especialidad.VETERINARIO));
        centro1.agregarVeterinario(new Empleado("Luis", 40, 345678901, 320345678, null, Empleado.Especialidad.PELUQUERO));
        centro1.agregarVeterinario(new Empleado("Marta", 45, 456789012, 330456789, null, Empleado.Especialidad.ENTRENADOR));
        centro1.agregarVeterinario(new Empleado("Pedro", 50, 567890123, 340567890, null, Empleado.Especialidad.VETERINARIO));
        centro1.agregarHospitalizado(new Mascota("Buddy", "Perro", 5, "Macho", Mascota.EstadoSalud.SANO, 50, 20.5));
        centro1.agregarHospitalizado(new Mascota("Max", "Gato", 3, "Macho", Mascota.EstadoSalud.ENFERMO, 30, 10.2));
        centro1.agregarHospitalizado(new Mascota("Luna", "Conejo", 2, "Hembra", Mascota.EstadoSalud.ENTRATAMIENTO, 20, 5.8));
        centro1.agregarHospitalizado(new Mascota("Rocky", "Hámster", 1, "Macho", Mascota.EstadoSalud.SANO, 10, 0.5));
        centro1.agregarHospitalizado(new Mascota("Bella", "Perro", 4, "Hembra", Mascota.EstadoSalud.SANO, 45, 18.0));

        CentroAdopcion centro2 = new CentroAdopcion("Centro de Adopción Bogotá");
        centro2.setSede(CentroAdopcion.Sedes.BOGOTA.name());
        centro2.agregarVeterinario(new Empleado("Laura", 40, 678901234, 360678901, null, Empleado.Especialidad.VETERINARIO));
        centro2.agregarVeterinario(new Empleado("Miguel", 45, 789012345, 370789012, null, Empleado.Especialidad.PELUQUERO));
        centro2.agregarVeterinario(new Empleado("Andrea", 38, 890123456, 380890123, null, Empleado.Especialidad.ENTRENADOR));
        centro2.agregarVeterinario(new Empleado("Fernando", 55, 901234567, 390901234, null, Empleado.Especialidad.VETERINARIO));
        centro2.agregarVeterinario(new Empleado("Elena", 32, 912345678, 400912345, null, Empleado.Especialidad.VETERINARIO));
        centro2.agregarHospitalizado(new Mascota("Tiger", "Gato", 4, "Macho", Mascota.EstadoSalud.ENFERMO, 25, 9.5));
        centro2.agregarHospitalizado(new Mascota("Shadow", "Perro", 6, "Macho", Mascota.EstadoSalud.SANO, 55, 25.0));
        centro2.agregarHospitalizado(new Mascota("Snow", "Conejo", 1, "Hembra", Mascota.EstadoSalud.ENTRATAMIENTO, 15, 3.8));
        centro2.agregarHospitalizado(new Mascota("Milo", "Hámster", 2, "Macho", Mascota.EstadoSalud.SANO, 8, 0.7));
        centro2.agregarHospitalizado(new Mascota("Oliver", "Gato", 5, "Macho", Mascota.EstadoSalud.ENFERMO, 28, 11.0));

        CentroAdopcion centro3 = new CentroAdopcion("Centro de Adopción Cali");
        centro3.setSede(CentroAdopcion.Sedes.CALI.name());
        centro3.agregarVeterinario(new Empleado("Jorge", 29, 876543219, 460876543, null, Empleado.Especialidad.VETERINARIO));
        centro3.agregarVeterinario(new Empleado("Carmen", 48, 765432109, 470765432, null, Empleado.Especialidad.PELUQUERO));
        centro3.agregarVeterinario(new Empleado("Lucia", 33, 654321098, 480654321, null, Empleado.Especialidad.ENTRENADOR));
        centro3.agregarVeterinario(new Empleado("Mario", 37, 543210987, 490543210, null, Empleado.Especialidad.VETERINARIO));
        centro3.agregarVeterinario(new Empleado("Beatriz", 41, 432109876, 500432109, null, Empleado.Especialidad.VETERINARIO));
        centro3.agregarHospitalizado(new Mascota("Daisy", "Perro", 4, "Hembra", Mascota.EstadoSalud.ENFERMO, 48, 19.5));
        centro3.agregarHospitalizado(new Mascota("Simba", "Gato", 2, "Macho", Mascota.EstadoSalud.SANO, 29, 12.3));
        centro3.agregarHospitalizado(new Mascota("Bunny", "Conejo", 3, "Hembra", Mascota.EstadoSalud.ENTRATAMIENTO, 22, 4.0));
        centro3.agregarHospitalizado(new Mascota("Nemo", "Hámster", 1, "Macho", Mascota.EstadoSalud.SANO, 12, 0.6));
        centro3.agregarHospitalizado(new Mascota("Charlie", "Perro", 5, "Macho", Mascota.EstadoSalud.ENFERMO, 53, 22.1));

        CentroAdopcion centro4 = new CentroAdopcion("Centro de Adopción Cartagena");
        centro4.setSede(CentroAdopcion.Sedes.CARTAGENA.name());
        centro4.agregarVeterinario(new Empleado("Pablo", 36, 321098765, 510321098, null, Empleado.Especialidad.VETERINARIO));
        centro4.agregarVeterinario(new Empleado("Silvia", 46, 210987654, 520210987, null, Empleado.Especialidad.PELUQUERO));
        centro4.agregarVeterinario(new Empleado("Raul", 39, 109876543, 530109876, null, Empleado.Especialidad.ENTRENADOR));
        centro4.agregarVeterinario(new Empleado("Patricia", 42, 987654321, 540987654, null, Empleado.Especialidad.VETERINARIO));
        centro4.agregarVeterinario(new Empleado("Julio", 28, 876543210, 550876543, null, Empleado.Especialidad.VETERINARIO));
        centro4.agregarHospitalizado(new Mascota("Oscar", "Perro", 6, "Macho", Mascota.EstadoSalud.SANO, 56, 23.2));
        centro4.agregarHospitalizado(new Mascota("Lily", "Gato", 3, "Hembra", Mascota.EstadoSalud.ENFERMO, 31, 13.4));
        centro4.agregarHospitalizado(new Mascota("Thumper", "Conejo", 2, "Macho", Mascota.EstadoSalud.ENTRATAMIENTO, 24, 6.1));
        centro4.agregarHospitalizado(new Mascota("Hammy", "Hámster", 1, "Hembra", Mascota.EstadoSalud.SANO, 14, 0.8));
        centro4.agregarHospitalizado(new Mascota("Rex", "Perro", 4, "Macho", Mascota.EstadoSalud.ENFERMO, 49, 21.3));

        // Agregar clientes estáticos a la clase CentroAdopcion
        CentroAdopcion.registrarCliente(new Cliente("Ana", 25, 987654321, 310987654, "Calle 1 # 2-3"));
        CentroAdopcion.registrarCliente(new Cliente("Pedro", 35, 876543210, 320876543, "Calle 4 # 5-6"));
        CentroAdopcion.registrarCliente(new Cliente("Maria", 45, 765432109, 330765432, "Calle 7 # 8-9"));
        CentroAdopcion.registrarCliente(new Cliente("Luis", 32, 654321098, 340654321, "Calle 10 # 11-12"));
        CentroAdopcion.registrarCliente(new Cliente("Carlos", 52, 543210987, 350543210, "Calle 13 # 14-15"));

        centrosAdopcion.add(centro1);
        centrosAdopcion.add(centro2);
        centrosAdopcion.add(centro3);
        centrosAdopcion.add(centro4);


        //Productos para Tienda UNamascota
        
            // Crear objetos de tipo Producto
        Producto producto1 = new Producto("Croquetas de Pollo para perro", 50000, "Perro", "Alimentación", 100);
        Producto producto2 = new Producto("Croquetas de Pollo para gato", 45000, "Gato", "Alimentación", 50);
        Producto producto3 = new Producto("Chips de zanahoria para Conejo", 15000, "Conejo", "Alimentacion", 30);
        Producto producto4 = new Producto("Alpiste", 30000, "Ave", "Alimento", 30);
        Producto producto5 = new Producto("Cama para perro", 100000, "Perro", "Hogar", 20);
        Producto producto6 = new Producto("Cama para gato", 90000, "Gato", "Hogar", 15);
        Producto producto7 = new Producto("Cama para conejo", 80000, "Conejo", "Hogar", 10);
        Producto producto8 = new Producto("Caseta para ave", 70000, "Ave", "Hogar", 5);
        Producto producto9 = new Producto("Collar para perro", 25000, "Perro", "Accesorio", 50);
        Producto producto10 = new Producto("Collar para gato", 20000, "Gato", "Accesorio", 40);
        Producto producto11 = new Producto("Moño de Conejo", 15000, "Conejo", "Accesorio", 30);
        Producto producto12 = new Producto("Sombreritos para Aves", 10000, "Ave", "Accesorio", 20);
        Producto producto13 = new Producto("Juguete para Perro", 10000, "Perro", "Entretenimiento", 20);
        Producto producto14 = new Producto("Juguete para Gato", 8000, "Gato", "Entretenimiento", 15);
        Producto producto15 = new Producto("Juguete para Conejo", 6000, "Conejo", "Entretenimiento", 10);

        // Agregar productos al inventario de la Tienda
        
        Tienda.agregarProducto(producto1);
        Tienda.agregarProducto(producto2);
        Tienda.agregarProducto(producto3);
        Tienda.agregarProducto(producto4);
        Tienda.agregarProducto(producto5);
        Tienda.agregarProducto(producto6);
        Tienda.agregarProducto(producto7);
        Tienda.agregarProducto(producto8);
        Tienda.agregarProducto(producto9);
        Tienda.agregarProducto(producto10);
        Tienda.agregarProducto(producto11);
        Tienda.agregarProducto(producto12);
        Tienda.agregarProducto(producto13);
        Tienda.agregarProducto(producto14);
        Tienda.agregarProducto(producto15);

        //Agregar mascotas difuntas
        
        /*Mascota mascotaF1 = new Mascota("Copérnico", "Perro", 10, null, null, 0, 0);
        Mascota mascotaF2 = new Mascota("Zack", "Perro", 6, null, null, 0, 0);
        Mascota mascotaF3 = new Mascota("Mia", "Gato", 12, null, null, 0, 0);
        Mascota mascotaF4 = new Mascota("Lola", "Hámster", 2, null, null, 0, 0);
        Mascota mascotaF5 = new Mascota("Apollo", "Perro", 13, null, null, 0, 0);
        Mascota mascotaF6 = new Mascota("Daisy", "Perro", 9, null, null, 0, 0);
        Mascota mascotaF7 = new Mascota("Copérnico", "Gato", 14, null, null, 0, 0);
        Mascota mascotaF8 = new Mascota("Copérnico", "Hamster", 1, null, null, 0, 0);
        Mascota mascotaF9 = new Mascota("Copérnico", "Conejo", 3, null, null, 0, 0);
        Mascota mascotaF10 = new Mascota("Copérnico", "Gato", 12, null, null, 0, 0);
        Mascota mascotaF11 = new Mascota("Copérnico", "Conejo", 3, null, null, 0, 0);
        Mascota mascotaF12 = new Mascota("Copérnico", "Hámster", 4, null, null, 0, 0); 
        
        //Agregar mascotas difuntas a los memoriales
        
        Memorial memorial1 = new Memorial(centro1);
        memorial1.anadirOsario(new Fallecido(mascotaF1, "2023-01-12", "Siempre en mis recuerdos.", null, "Forever", "Osario"));
        memorial1.anadirArbol(new Fallecido(mascotaF2, "2024-11-24", null, null, "Forever", "Arbol"));
        memorial1.anadirCenizas(new Fallecido(mascotaF3, "2001-06-01", "Siempre en mis recuerdos.", null, "30 años", "Cenizas"));
        memorial1.anadirOsario(new Fallecido(mascotaF4, "2016-04-23", "Nunca te olvidare.", null, "Forever", "Osario"));
        
        Memorial memorial2 = new Memorial(centro2);
        memorial2.anadirArbol(new Fallecido(mascotaF5, "2005-02-21", null, null, "45 años", "Arbol"));
        memorial2.anadirCenizas(new Fallecido(mascotaF6, "2014-10-25", ":(", null, "Forever", "Cenizas"));
        memorial2.anadirCenizas(new Fallecido(mascotaF7, "2025-01-28", "Gracias por tu compañia.", null, "Forever", "Cenizas"));
        
        Memorial memorial3 = new Memorial(centro3);
        memorial3.anadirSepulcro(new Fallecido(mascotaF8, "2020-07-01", null, null, "Forever", "Sepulcro"));
        memorial3.anadirSepulcro(new Fallecido(mascotaF9, "2018-12-09", "Siempre en mi corazon", null, "Forever", "Sepulcro"));
        memorial3.anadirArbol(new Fallecido(mascotaF10, "2020-07-01", null, null, "Forever", "Arbol"));
        
        Memorial memorial4 = new Memorial(centro4);
        memorial4.anadirOsario(new Fallecido(mascotaF11, "2020-07-01", null, null, "Forever", "Osario"));
        memorial4.anadirArbol(new Fallecido(mascotaF12, "2020-07-01", null, null, "Forever", "Arbol")); */
        
        try {
            // Define la ruta del archivo
            String filePath = "src/src/baseDatos/temp/productos.txt";
            File outputFile = new File(filePath);

            // Crea los directorios si no existen
            if (!outputFile.getParentFile().exists()) {
                outputFile.getParentFile().mkdirs();
            }

            // Serializa el objeto
            FileOutputStream f = new FileOutputStream(outputFile);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(Tienda.productos);
            o.close();
            f.close();
            System.out.println("Archivo creado y datos serializados exitosamente.");
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo ingresado");
        } catch (IOException e) {
            System.out.println("Error en el flujo de inicialización");
        }
    }
}