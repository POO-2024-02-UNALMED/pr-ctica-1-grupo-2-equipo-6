package uiMain;

import java.util.List;
import java.util.Scanner;

import gestorAplicacion.elementos.CentroAdopcion;
import gestorAplicacion.elementos.Empleado;
import gestorAplicacion.elementos.Empleado.Especialidad;
import gestorAplicacion.elementos.Mascota;
import gestorAplicacion.elementos.CentroAdopcion.Sedes;
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
            
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número del 1 al 6.\n");
                sc.nextLine();
                continue;
            }
            
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
            		System.out.println("Opción no válida. Por favor, intente de nuevo.\n");
            }
            
		}
		sc.close();
	}
	
	public static void emergenciaVeterinaria() {
		
		centro.agregarVeterinario(new Empleado("Alberto", 27, 125734625, 321215589, null, Especialidad.VETERINARIO));
		centro.agregarVeterinario(new Empleado("Ricardo", 38, 125846225, 321765589, null, Especialidad.VETERINARIO));
		
		System.out.println("Ingrese los datos de su mascota:");
		System.out.println("Nombre:");
		String nombre = sc.nextLine();
		
		System.out.println("Tipo:");
		String tipo = sc.nextLine();
		
		System.out.println("Edad:");
		int edad = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Sexo:");
		String sexo = sc.nextLine();
		
		System.out.println("Síntomas:");
		String sintomas = sc.nextLine();
		String[] listaSintomas = sintomas.split(" ");
		
		Mascota mascota = new Mascota(nombre, tipo, edad, sexo, EstadoSalud.ENFERMO);
		
		System.out.println("¿En dónde desea que su mascota sea atendida? Ingrese el número:");
		centro.mostrarSedes();
		int sede = sc.nextInt();
		sc.nextLine();
		while (sede < 1 || sede > Sedes.values().length) {
			System.out.println("Entrada inválida. Por favor, ingrese un número entre 1 y " + Sedes.values().length + ":");
			sede = sc.nextInt();
			sc.nextLine();
		}
		
		centro.setSede(Sedes.values()[sede-1].name());
		String nombreSede  = Sedes.values()[sede-1].toString(); 
		nombreSede = nombreSede.substring(0,1).toUpperCase() + nombreSede.substring(1).toLowerCase();
		System.out.println("La sede seleccionada es: " + nombreSede);
		
		if (centro.verificarHospitalizacion(mascota)) {
			//int opcion;
			
			//System.out.println("Su mascota puede ser hospitalizada.");
			//System.out.println("Elija uno de los siguientes veterinarios disponibles:");
			
			/*for (Empleado veterinario : centro.gestionarVeterinario()) {
				System.out.println(veterinario);
			}*/
			int gravedad = 0;
			int compatibilidad = 0;
			
			for (String sintoma : listaSintomas) {
	            switch (sintoma.toLowerCase()) {
	                case "fiebre":
	                    gravedad += 2;
	                    compatibilidad += 3;
	                    break;
	                case "vomito":
	                case "vómito":
	                    gravedad += 3;
	                    compatibilidad += 2;
	                    break;
	                case "picazon":
	                case "picazón":
	                    gravedad += 2;
	                    compatibilidad += 1;
	                    break;
	                case "enrojecimiento":
	                    gravedad += 1;
	                    compatibilidad += 2;
	                    break;
	                case "inflamacion":
	                case "inflamación":
	                    gravedad += 2;
	                    compatibilidad += 2;
	                    break;
	                case "y":
	                	break;
	                default:
	                    System.out.println("Sintoma desconocido: " + sintoma);
	                    break;
	            }
	        }
			
			if (!centro.gestionarVeterinario().isEmpty() && mascota.indiceEmergencia(gravedad, compatibilidad) >= 7.0) {
				
				System.out.println("Su mascota puede ser hospitalizada.");
				System.out.println("Elija uno de los siguientes veterinarios disponibles:");
				
				for (int i = 0 ; i < centro.gestionarVeterinario().size() ; i++) {
					System.out.println(i+1 + ". " + centro.gestionarVeterinario().get(i));
				}
				
				int opcion = sc.nextInt();
				sc.nextLine();
				
				while(opcion < 1 || opcion > centro.gestionarVeterinario().size()) {
					System.out.println("Entrada inválida. Por favor, ingrese un número entre 1 y " + centro.gestionarVeterinario().size() + ":");
					opcion = sc.nextInt();
					sc.nextLine();
				}
				
				System.out.println("Su veterinario asignado es\n" + centro.gestionarVeterinario().get(opcion-1));
				mascota.setVeterinario(centro.gestionarVeterinario().get(opcion-1));
				centro.gestionarVeterinario().get(opcion-1).setMascota(mascota);
				
				String nombreSede2  = centro.getSede(); 
				nombreSede2 = nombreSede2.substring(0,1).toUpperCase() + nombreSede2.substring(1).toLowerCase();
				System.out.println("Su mascota ha sido hospitalizada en la sede: " + nombreSede2);
			}
			else {
				System.out.println("No hay veterinarios dispobibles en esta sede.");
				centro.mostrarSedes();
			}
			
		}
		
		else {
			System.out.println("Su mascota no requiere hospitalización. Redirigiendo a Planificación de Dieta.");
			//planificacionDieta();
		}
		
	}
		
}