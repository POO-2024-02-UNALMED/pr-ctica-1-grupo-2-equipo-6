package uiMain;

import java.util.List;
import java.util.Scanner;

import gestorAplicacion.elementos.CentroAdopcion;
import gestorAplicacion.elementos.Empleado;
import gestorAplicacion.elementos.Empleado.Especialidad;
import gestorAplicacion.elementos.Mascota;
import gestorAplicacion.elementos.Mascota.EstadoSalud;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static CentroAdopcion centro = new CentroAdopcion("POO");
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		while (opcion != 6) {
			System.out.println("Bienvenido a la veterinaria virtual.");
            System.out.println("\n¿Qué desea hacer?");
            System.out.println("\n1. (Funcionalidad 1)");
            System.out.println("2. (Funcionalidad 2)");
            System.out.println("3. (Funcionalidad 3)");
            System.out.println("4. (Funcionalidad 4)");
            System.out.println("5. (Funcionalidad 5)");
            System.out.println("6. Salir");
            
            opcion = sc.nextInt();
            
            switch (opcion) {
            	case 1:
            		System.out.println("Bienvenido a la funcionalidad 1.");
            		emergenciaVeterinaria();
            		break;
            	case 2:
            		System.out.println("Bienvenido a la funcionalidad 2.");
            		break;
            	case 3:
            		System.out.println("Bienvenido a la funcionalidad 3.");
            		break;
            	case 4:
            		System.out.println("Bienvenido a la funcionalidad 4.");
            		break;
            	case 5:
            		System.out.println("Bienvenido a la funcionalidad 5.");
            		break;
            	case 6:
                    System.out.println("Saliendo del sistema.");
                    break;
            	default:
            		System.out.println("Opción no válidad. Por favor, intente de nuevo.\n");
            }
            
		}
		sc.close();
	}
	
	public static void emergenciaVeterinaria() {
		
		centro.agregarVeterinario(new Empleado("Alberto", 27, 125734625, 321215589, null, Especialidad.VETERINARIO));
		centro.agregarVeterinario(new Empleado("Ricardo", 38, 125846225, 321765589, null, Especialidad.VETERINARIO));
		Mascota mascota;
		String nombre;
		String tipo;
		int edad;
		String sexo;
		String sintomas;
		String[] listaSintomas;
		
		System.out.println("Ingrese los datos de su mascota:");
		System.out.println("Nombre:");
		nombre = sc.nextLine();
		System.out.println("Tipo:");
		tipo = sc.nextLine();
		System.out.println("Edad:");
		edad = sc.nextInt();
		System.out.println("Sexo:");
		sexo = sc.nextLine();
		System.out.println("Síntomas:");
		sintomas = sc.nextLine();
		listaSintomas = sintomas.split(" ");
		
		mascota = new Mascota(nombre, tipo, edad, sexo, EstadoSalud.ENFERMO);
		
		System.out.println("¿En dónde desea que su mascota sea atendida? Ingrese el número:");
		centro.mostrarSedes();
		int sede = sc.nextInt();
		centro.setSede(EstadoSalud.values()[sede-1].name());
		
		if (centro.verificarHospitalizacion(mascota)) {
			System.out.println("Su mascota puede ser hospitalizada.");
		}
		
		else {
			System.out.println("Su mascota no puede ser hospitalizada");
		}
		
		if (centro.gestionarVeterinario() != null) {
			System.out.println("Su veterinario asignado es:\n" + centro.gestionarVeterinario());
			mascota.setVeterinario(centro.gestionarVeterinario());
			centro.gestionarVeterinario().setMascota(mascota);
		}
		else {
			System.out.println("No hay veterinarios dispobibles en esta sede.");
			centro.mostrarSedes();
		}
		
		
		
	}
	
}