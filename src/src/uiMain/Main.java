package uiMain;

import baseDatos.Deserializador;
import gestorAplicacion.elementos.CentroAdopcion;
import gestorAplicacion.elementos.CentroAdopcion.Sedes;
import gestorAplicacion.elementos.Cliente;
import gestorAplicacion.elementos.Cupo;
import gestorAplicacion.elementos.Dieta;
import gestorAplicacion.elementos.Empleado;
import gestorAplicacion.elementos.Empleado.Especialidad;
import gestorAplicacion.elementos.Fallecido;
import gestorAplicacion.elementos.Mascota;
import gestorAplicacion.elementos.Mascota.EstadoSalud;
import gestorAplicacion.elementos.Producto;
import gestorAplicacion.gestion.Cita;
import gestorAplicacion.gestion.Memorial;
import gestorAplicacion.gestion.Tienda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


		

public class Main implements Serializable {
	private static final long serialVersionUID = 1L;

	static CentroAdopcion sede1;
	
	static Scanner sc = new Scanner(System.in);
	static CentroAdopcion centro = new CentroAdopcion("POO");
	private static Scanner scanner = new Scanner(System.in);
	public static ArrayList<CentroAdopcion> centroAdopcions;
	private static Memorial memorial = new Memorial();
	
	
	public static void main(String[] args) {
		centroAdopcions = Deserializador.deserializarCentrosAdopcion();
		Tienda.productos = Deserializador.deserializarProductos();
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		System.out.println("\n - - Bienvenido al Centro Veterinario Virtual: UNamascota. - - \n");
		/*System.out.println("--------------------");
		System.out.println("\n- Ingrese sus datos");
		System.out.print("\n- Nombre Completo: ");
		String nombre = sc.nextLine();
		System.out.print("- Edad: ");
		int edad = sc.nextInt(); 
		sc.nextLine();
		System.out.print("- Cédula: ");
		long cedula = sc.nextLong();
		System.out.println("--------------------");
		
		Cliente cliente = new Cliente(nombre, edad, cedula);
		cliente.agregarPuntos(50000);*/
		
		while (opcion != 6) {
			
			System.out.println("--------------------");
            System.out.println("\n - - ¿Qué desea hacer el día de hoy? - -");
            System.out.println("\n1. Emergencia Veterinaria");
            System.out.println("2. Adquirir Servicios: PetTraining");
			System.out.println("3. Tienda: UNamascota");
            System.out.println("4. Servicio de Memorial"); //memorial
            System.out.println("5. Planificador de Dieta");
            System.out.println("6. (┬┬~~┬┬) Salir");
			System.out.println("\n--------------------");
			System.out.print("Ingrese el número de la opción que desea [1-6]: ");
            
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Scanner no válida. Por favor, ingrese un número válido [1-6].\n");
                sc.nextLine();
                continue;
            }
            
            switch (opcion) {
            	case 1:
					System.out.println("\n--------------------");
            		System.out.println("\nBienvenido a Emergencia Veterinaria.");
            		emergenciaVeterinaria();
            		break;
            	case 2:
					System.out.println("\n--------------------");
            		System.out.println("\nBienvenido a PetTraining.");
					agendarservicioSSeleccionado();
            		break;
            	case 3:
					System.out.println("\n--------------------");
            		System.out.println("\nBienvenido a Tienda UNamascota.");
					tienda();
            		break;
            	case 4:
					System.out.println("\n--------------------");
            		System.out.println("\nBienvenido al servicio memorial.");
            		gestionarMemorial();
            		break;
            	case 5:
					System.out.println("\n--------------------");
					System.out.println("\nBienvenido al Sistema de planificacion de Dieta.\n");
            		planificacionDieta();
            		break;
            	case 6:
					System.out.println("\n--------------------");
                    System.out.println("\nSaliendo del sistema.");
                    break;
            	default:
            		System.out.println("Opción no válida. Por favor, intente de nuevo.\n");
            }
            
		}
		sc.close();
	}

	//MÉTODOS NECESARIOS	
	//scannerS DE DATOS POR TIPO
	static byte readByte() {
		return scanner.nextByte();
	}
	
	static int readInt() {
		return scanner.nextInt();
	}
	
	static String readString() {	
		String string = scanner.nextLine();
		return string;
	}
	
	static long readLong() {
		return scanner.nextLong();
	}
	
	static boolean readBoolean() {
		boolean x=scanner.nextBoolean();
		return x;
	}
	
	static double nextDouble() {
		return scanner.nextDouble();
	}
	
	static void println(Object obj) {
		System.out.println(obj);
	}
	
	static void print(Object obj) {
		System.out.print(obj);
	}

	//Para leer un entero desde la scanner.
	public static int leerEntero() {
		while (true) {
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				scanner.next(); // Limpiar la scanner no válida
			}
		}
	}
	
	//Para leer un número largo desde la scanner.
public static long leerEnteroLargo() {
    while (true) {
        try {
            return scanner.nextLong();
        } catch (InputMismatchException e) {
            scanner.next(); // Limpiar la scanner no válida
        }
	}
}

	//Para leer un double desde la scanner.
	public static double leerDouble() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                scanner.next(); // Limpiar la entrada no válida
            }
        }
    }

	//Para leer una cadena de texto desde la scanner.
	public static String leerCadena() {
		return scanner.nextLine();
	}

	public static void emergenciaVeterinaria() {
	
		System.out.println("--------------------");
		System.out.println("\n- Ingrese sus datos");
		System.out.print("\n- Nombre Completo: ");
		String nombre = sc.nextLine();
		System.out.print("- Edad: ");
		int edad = sc.nextInt(); 
		sc.nextLine();
		System.out.print("- Cédula: ");
		long cedula = sc.nextLong();
		sc.nextLine();
		System.out.println("--------------------");
		
		Cliente cliente = new Cliente(nombre, edad, cedula);
		cliente.agregarPuntos(15000);
		
		//Veterinarios en en centro de adopción. Agregar más
		centro.agregarVeterinario(new Empleado("Ana", 30, 439872356, 310543216, null, Especialidad.VETERINARIO));
		centro.agregarVeterinario(new Empleado("Mariana", 32, 123456789, 321456789, null, Especialidad.VETERINARIO));
		centro.agregarVeterinario(new Empleado("Jorge", 40, 987654321, 320765432, null, Especialidad.VETERINARIO));
		centro.agregarVeterinario(new Empleado("Lucía", 28, 246810121, 310987654, null, Especialidad.VETERINARIO));

		//---------------------------------------------------
		
		//Pedir datos de la mascota al usuario
		System.out.println("\nIngrese los datos de su mascota:");
		System.out.print("Nombre: ");
		String nombreMascota = sc.nextLine();
		
		System.out.print("Especie: ");
		String tipo = sc.nextLine();
		
		System.out.print("Edad: ");
		int edadMascota = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Sexo (M/F): ");
		String sexo = sc.nextLine();
		
		System.out.print("Tamaño (1-4): \n1. Miniatura \n2. Pequeño \n3. Mediano \n4. Grande \nIngrese el número correspondiente: ");
		int tamano = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Peso en kg: ");
		double peso = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("¿Cuáles de los siguientes síntomas presenta su mascota? (Sin comas)\nFiebre - Vómito - Picazón - Enrojecimiento - Inflamación");
		String sintomas = sc.nextLine();
		String[] listaSintomas = sintomas.split(" ");
		//---------------------------------------------------
		
		//Crear instancia de Mascota con los datos que ingresó el usuario
		Mascota mascota = new Mascota(nombreMascota, tipo, edadMascota, sexo, EstadoSalud.ENFERMO, tamano, peso);
		//---------------------------------------------------
		
		//Pedirle al usuario que elija la sede y asignarla a la instancia de centro de adopción
		System.out.println("\n¿En dónde desea que su mascota sea atendida? (1-4):");
		centro.mostrarSedes();
		System.out.print("Ingrese el número correspondiente a la sede: ");
		int sede = sc.nextInt();
		sc.nextLine();
		while (sede < 1 || sede > Sedes.values().length) {
			System.out.println("scanner inválida. Por favor, ingrese un número entre 1 y " + Sedes.values().length + ":");
			sede = sc.nextInt();
			sc.nextLine();
		}
		
		centro.setSede(Sedes.values()[sede-1].name());
		String nombreSede  = Sedes.values()[sede-1].toString(); 
		nombreSede = nombreSede.substring(0,1).toUpperCase() + nombreSede.substring(1).toLowerCase();
		System.out.println("\nLa sede seleccionada es: " + nombreSede);
		//---------------------------------------------------
		
		//Verificar si la mascota debe ser hospitalizada
		if (centro.verificarHospitalizacion(mascota, listaSintomas, centro)) {
			
				
				System.out.println("\nSu mascota puede ser hospitalizada.");
				System.out.println("\nElija uno de los siguientes veterinarios disponibles:\n");
				
				for (int i = 0 ; i < centro.gestionarVeterinario().size() ; i++) {
					System.out.println(i+1 + ". " + centro.gestionarVeterinario().get(i));
				}
				
				System.out.print("Ingrese el número correspondiente al veterinario que desea: ");
				int opcion = sc.nextInt();
				sc.nextLine();
				
				//Verificar que el usuario ingrese un número en el rango correcto
				while(opcion < 1 || opcion > centro.gestionarVeterinario().size()) {
					System.out.println("\nscanner inválida. Por favor, ingrese un número entre 1 y " + centro.gestionarVeterinario().size() + ":");
					opcion = sc.nextInt();
					sc.nextLine();
				}
				//---------------------------------------------------
				
				System.out.println("\nSu veterinario asignado es\n" + centro.gestionarVeterinario().get(opcion-1));
				centro.asignarVeterinario(mascota, centro.gestionarVeterinario().get(opcion-1));
				centro.agregarHospitalizado(mascota);
				
				String nombreSede2  = centro.getSede(); 
				nombreSede2 = nombreSede2.substring(0,1).toUpperCase() + nombreSede2.substring(1).toLowerCase();
				System.out.println("\nSu mascota ha sido hospitalizada en la sede: " + nombreSede2);
				
				System.out.println("\nGestionando pago. Seleccione el método de pago (1-3):\n");
				for(int i = 0; i < centro.mostrarOpcionesPago().length; i++){
					System.out.println(i+1 + ". " + centro.mostrarOpcionesPago()[i]);
				}
				
				int pago = sc.nextInt();
				sc.nextLine();
				
				//Verificar que el usuario ingrese un número en el rango correcto
				while(pago < 1 || pago > centro.mostrarOpcionesPago().length) {
					System.out.println("scanner inválida. Por favor, ingrese un número entre 1 y " + centro.mostrarOpcionesPago().length + ":");
					pago = sc.nextInt();
					sc.nextLine();
				}
				//---------------------------------------------------
				
				boolean pagoValido = false;
				while (!pagoValido) {
				    switch (pago) {
				        case 1:
				            centro.procesarPago(1, cliente, 20000);
				            centro.generarFactura(cliente, mascota, 20000);
				            pagoValido = true;
				            break;
				        case 2:
				            centro.procesarPago(2, cliente, 32000);
				            centro.generarFactura(cliente, mascota, 32000);
				            pagoValido = true;
				            break;
				        case 3:
				            if (cliente.getPuntos() < 20000) {
				                System.out.println("\nPuntos insuficientes, seleccione otro método de pago.");
				                pago = sc.nextInt();
				                sc.nextLine();
				            } else {
				                centro.procesarPago(3, cliente, 20000);
				                centro.generarFactura(cliente, mascota, 20000);
				                pagoValido = true;
				            }
				            break;
				        default:
				            System.out.println("Opción no válida.");
				            pago = sc.nextInt();
				            sc.nextLine();
				            break;
				    }
				}
				
				System.out.println("\nEs posible dar de alta a su mascota. ¿Desea hacerlo? (1-2) \n1. Sí \n2. No");
				int alta = sc.nextInt();
				sc.nextLine();
				
				switch (alta) {
					case 1:
						System.out.println("\nSe ha registrato el alta de su mascota " + mascota.getNombre() + ".");
						centro.registrarAlta(mascota);
						System.out.println("\nSaliendo de Emergencia Veterinaria");
						break;
					case 2:
						System.out.println("\nSu mascota " + mascota.getNombre() + " sigue hospitalizada.");
						System.out.println("\nSaliendo de Emergencia Veterinaria");
						break;
					default:
						break;
				}
			
		}
		
		else {
			System.out.println("Su mascota no requiere hospitalización. Redirigiendo a Planificación de Dieta.");
			planificacionDieta();
		}
	}



	//>>-----------------------------------------------------------------------------------------------------------------<<

			
	// función para agendar un servicioSSeleccionado
	static void agendarservicioSSeleccionado(){
		ArrayList<Cita> citasAgendadas = new ArrayList<>();
		System.out.println("\n\n🐾 ¡Bienvenido a PetTraining! 🐾");
		System.out.println("Gracias por elegirnos para cuidar y entrenar a tu peludito.");			
		System.out.println("Por favor, sigue las instrucciones a continuación para que podamos atenderlo de la mejor manera.\n");
		
		boolean repetir = false;
		boolean clienteConocido = false;
		Cliente cliente = null;

		do {
			int sedeSeleccionada = 0;
			int servicioSeleccionado = 0;
		
			// selección de sede
			System.out.println("📍 Selección de Sede 📍");
			System.out.println("1. SEDE MEDELLIN");
			System.out.println("2. SEDE BOGOTA");
			System.out.println("3. SEDE CALI");
			System.out.println("4. SEDE CARTAGENA\n");
		
			// pedir al usuario que seleccione una sede
			do {
				System.out.print("Ingrese su elección dentro del rango [1-4]: ");
				try {
					sedeSeleccionada = leerEntero();
					if (sedeSeleccionada < 1 || sedeSeleccionada > 4) {
						System.out.println("Proporcione una respuestata válida.\n");
					}
					} catch (InputMismatchException e) {
						System.out.println("Proporcione una respuestata válida.\n");
					} finally {
						leerCadena();
					}
				} while (sedeSeleccionada < 1 || sedeSeleccionada > 4);
		
			// mostrar los servicioSSeleccionados disponibles según la sede seleccionada
			System.out.println("\n📋 Servicios Disponibles 📋");
			switch (sedeSeleccionada) {
				case 1:
					System.out.println("SEDE MEDELLIN - servicio Disponibles: \n1. Entrenamiento \n2. Veterinaria");
					break;
				case 2:
					System.out.println("SEDE BOGOTA - servicio Disponibles: \n1. Peluquería");
					break;
				case 3:
					System.out.println("SEDE CALI - servicio Disponibles: \n1. Veterinaria \n2. Entrenamiento");
					break;
				case 4:
					System.out.println("SEDE CARTAGENA - servicio Disponibles: \n1. Entrenamiento");
					break;
			}
		
			System.out.println("3. Cambiar de sede\n");
		
			// pedir al usuario que seleccione un servicioSSeleccionado o cambiar de sede
			do {
				System.out.print("Ingrese su elección dentro del rango [1-3]: ");
				try {
					servicioSeleccionado = leerEntero();
					if (servicioSeleccionado < 1 || servicioSeleccionado > 3) {
						System.out.println("Proporcione una respuestata válida.\n");
					}
				} catch (InputMismatchException e) {
					System.out.println("Proporcione una respuestata válida.\n");
				} finally {
					leerCadena();
				}
			} while (servicioSeleccionado < 1 || servicioSeleccionado > 3);
		
			// si el usuario decide cambiar de sede
			if (servicioSeleccionado == 3) {
				continue;
			}
		
			// verificar si el servicioSSeleccionado está disponible para la especie de la mascota del cliente
			boolean servicioSeleccionadoDisponible = false;
			switch (sedeSeleccionada) {
				case 1:
					if (servicioSeleccionado == 1) {
					// entrenamiento incluye guardería
						System.out.println("\nEl servicio de entrenamiento está disponible para perros y gatos.");
						String respuestata1;
						do {
							println("¿Su mascota pertenece a alguna de estas especies?");
							print("Responda si / no: ");
							respuestata1= leerCadena();
							
							if (respuestata1.equalsIgnoreCase("si")!=true && respuestata1.equalsIgnoreCase("no")!=true) {
								println("Proporcione una respuestata válida.\n");
							}
						}while (respuestata1.equalsIgnoreCase("si")!=true && respuestata1.equalsIgnoreCase("no")!=true);
						
						if (respuestata1.equalsIgnoreCase("si")==true) {
							servicioSeleccionadoDisponible = true;
							servicioSeleccionado = 1;
						}
						break;
					} else if (servicioSeleccionado == 2) {
						String respuestata1;
						System.out.println("\nEl servicio de veterinaria está disponible para perros, gatos, conejos y hámsters.");
						do {
							println("¿Su mascota pertenece a alguna de estas especies?");
							print("Responda si / no: ");
							respuestata1= leerCadena();
							
							if (respuestata1.equalsIgnoreCase("si")!=true && respuestata1.equalsIgnoreCase("no")!=true) {
								println("Proporcione una respuestata válida.\n");
							}
						}while (respuestata1.equalsIgnoreCase("si")!=true && respuestata1.equalsIgnoreCase("no")!=true);
						
						if (respuestata1.equalsIgnoreCase("si")==true) {
							servicioSeleccionadoDisponible = true;
							servicioSeleccionado = 2;
						}
						break;
					}
					break;
				case 2:
					if (servicioSeleccionado == 1) {
						String respuestata2;
						System.out.println("\nEl servicio de peluquería está disponible para perros y gatos.");
						do {
							println("¿Su mascota pertenece a alguna de estas especies?");
							print("Responda si / no: ");
							respuestata2= leerCadena();
							
							if (respuestata2.equalsIgnoreCase("si")!=true && respuestata2.equalsIgnoreCase("no")!=true) {
								println("Proporcione una respuestata válida.\n");
							}
						}while (respuestata2.equalsIgnoreCase("si")!=true && respuestata2.equalsIgnoreCase("no")!=true);
						
						if (respuestata2.equalsIgnoreCase("si")==true) {
							servicioSeleccionadoDisponible = true;
							servicioSeleccionado = 3;
						}
						break;
					}
					break;
				case 3:
					if (servicioSeleccionado == 1) {
						String respuestata3;
						System.out.println("\nEl servicio de veterinaria está disponible para perros, gatos, conejos y hámsters.");
						do {
							println("¿Su mascota pertenece a alguna de estas especies?");
							print("Responda si / no: ");
							respuestata3= leerCadena();
							
							if (respuestata3.equalsIgnoreCase("si")!=true && respuestata3.equalsIgnoreCase("no")!=true) {
								println("Proporcione una respuestata válida.\n");
							}
						}while (respuestata3.equalsIgnoreCase("si")!=true && respuestata3.equalsIgnoreCase("no")!=true);
						
						if (respuestata3.equalsIgnoreCase("si")==true) {
							servicioSeleccionadoDisponible = true;
							servicioSeleccionado = 2;
						}
						break;
					} else if (servicioSeleccionado == 2) {
						String respuestata3;
						System.out.println("\nEl servicio de entrenamiento está disponible para perros y gatos.");
						do {
							println("¿Su mascota pertenece a alguna de estas especies?");
							print("Responda si / no: ");
							respuestata3= leerCadena();
							
							if (respuestata3.equalsIgnoreCase("si")!=true && respuestata3.equalsIgnoreCase("no")!=true) {
								println("Proporcione una respuestata válida.\n");
							}
						}while (respuestata3.equalsIgnoreCase("si")!=true && respuestata3.equalsIgnoreCase("no")!=true);
						
						if (respuestata3.equalsIgnoreCase("si")==true) {
							servicioSeleccionadoDisponible = true;
							servicioSeleccionado = 1;
						}
						break;
					}
					break;
				case 4:
				String respuestata4;
					if (servicioSeleccionado == 1) {
						System.out.println("\nEl servicio de entrenamiento está disponible para perros y gatos.");
						do {
							println("¿Su mascota pertenece a alguna de estas especies?");
							print("Responda si / no: ");
							respuestata4= leerCadena();
							
							if (respuestata4.equalsIgnoreCase("si")!=true && respuestata4.equalsIgnoreCase("no")!=true) {
								println("Proporcione una respuestata válida.\n");
							}
						}while (respuestata4.equalsIgnoreCase("si")!=true && respuestata4.equalsIgnoreCase("no")!=true);
						
						if (respuestata4.equalsIgnoreCase("si")==true) {
							servicioSeleccionadoDisponible = true;
							servicioSeleccionado = 1;
						}
						break;
					}
					break;
				}
		
			// si el servicioSSeleccionado no está disponible para la especie, se termina el proceso
			if (!servicioSeleccionadoDisponible) {
				System.out.println("\nNos disculpamos, pero el servicioSSeleccionado que desea no está disponible para su tipo de mascota. Agradecemos su comprensión.\n");
				repetir = false;
				continue;
			}
		
			// obtener la sede seleccionada y los empleados disponibles
			CentroAdopcion sede = centroAdopcions.get(sedeSeleccionada - 1);
			ArrayList<Empleado> empleadosDisponibles = sede.tieneEmpleados();
		
			// si no hay empleados disponibles, se termina el proceso
			if (empleadosDisponibles.size() == 0) {
				System.out.println("\nActualmente, debido a la falta de disponibilidad de citas, no es posible continuar con el proceso de agendamiento.");
				repetir = false;
			}
			else {
				switch(servicioSeleccionado) {
			
				case 1:
					println("\nContamos con los siguientes entrenadores de mascotas, seleccione el de su preferencia:");
					break;
						
				case 2:
					println("\nContamos con los siguientes veterinarios, seleccione el de su preferencia:");
					break;
						
				case 3:
					println("\nContamos con los siguientes peluqueros de mascotas, seleccione el de su preferencia:");
					break;	
				}
					
				int i = 1;
					
				for(Empleado emple : empleadosDisponibles) {
					println(i +" - "+ emple);
					i++;
				}
					
				//SELECCIONAR AL EMPLEADO
				int num_empleado = 0;
				 do {
					print("\nIngrese su elección dentro del rango [1-" + empleadosDisponibles.size() + "]: " );
					try {
						num_empleado= leerEntero();
							
						if (num_empleado<1 || num_empleado > empleadosDisponibles.size()) {
							println("Proporcione una respuestata válida.");
						}
							
					}catch(InputMismatchException e) {
						println("Proporcione una respuestata válida.");
					}finally {
						leerCadena();
					}
				}while(num_empleado<1 || num_empleado > empleadosDisponibles.size());
					 
				Empleado empleado_seleccionado = empleadosDisponibles.get(num_empleado - 1);//EMPLEADO SELECCIONADO
				println("Empleado seleccionado: " + empleado_seleccionado);//QUITAR
					 
					 
				 //SELECCIONAR EL DIA (LUNES, MARTES,MIERCOLES..) EN EL QUE SE QUIERE EL servicioSSeleccionado
				println("\nSeleccione el día en el que desea el servicioSSeleccionado.");
				String[] diasSemana = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado"};
				int num_dia=0;
				for (int j = 0; j <diasSemana.length; j++) {
					println((j + 1) + ". " + diasSemana[j]);
					}
					
				do {
					try {
						print("Ingrese su elección dentro del rango [1-6]: ");
						num_dia = leerEntero();
						if (num_dia<1 || num_dia>6) {
							println("Proporcione una respuestata válida.\n");
								
							}
						}catch(InputMismatchException e) {
							println("Proporcione una respuestata válida.\n");
							leerCadena();
							}
					}while(num_dia<1 || num_dia>6);
					
				//CUPOS QUE TIENE EL EMPLEADO PARA EL DIA SELECCIONADO
				ArrayList <Cupo> cupos_disponibles = empleado_seleccionado.cupos_disponibles(num_dia);
					
				//SI EL EMPLEADO NO TIENE CUPOS PARA ESE DÍA, ENTONCES EL PROCESO NO PODRÁ CONTINIAR.
				if (cupos_disponibles.size()==0) {
					println("Lamentablemente, el empleado seleccionado no tiene disponibilidad para el día que se eligió.");
					repetir = false;
				}
				else {
				//SI EL EMPLEADO TIENE CUPOS PARA EL DIA SELECCIONADO, ENTONCES SE LE MOSTRARÁN AL CLIENTE
					println("\nPor favor, seleccione la franja horaria que mejor se adapte a su necesidad. Si ninguna opción es adecuada,"
						+ "\npuedes seleccionar la opción " + (cupos_disponibles.size()+1) +" para cancelar.\n");
						
					println("Cupos disponibles para el " + diasSemana[num_dia -1] + " " + cupos_disponibles.get(0).fechaFormateada() + ": "); 
					int o = 1;
					for (Cupo cupo: cupos_disponibles) {
							
						println( o + ". " + cupo);
							
						o++;
					}
					println((cupos_disponibles.size()+1) + ". Cancelar");
						
					//SELECCIONAR EL CUPO DE PREFERENCIA, O CANCELAR
					int num_cupo=0;
					do {
						try {
							print("Ingrese su elección en el rango en el rango [1 -" + (cupos_disponibles.size()+1) +"]: ");
							num_cupo = leerEntero();
							
							if (num_cupo<1 || num_cupo>(cupos_disponibles.size()+1)) {
								println("Proporcione una respuestata válida");
							}
								
						}catch(InputMismatchException e) {
							 println("Proporcione una respuestata válida.");
						}
						finally {
							leerCadena(); //CONSUMIR SALTO DE LÍNEA
						}
						
					}while(num_cupo<1 || num_cupo>(cupos_disponibles.size()+1));
						
					//SI EL USUARIO DECIDE CANCELAR EL PROCESO DE AGENDAMIENTO DE CITA, ENTONCES EL PROCESO FINALIZARÁ.
					if (num_cupo==(cupos_disponibles.size()+1)) {
							
						println("Se ha cancelado el agendamiento de la cita.");
							
					}
					else {	
					//DE LO CONTRARIO, SI SELECCIONA UNI, ENTONCES SE PROCEDE A REOCGER LOS DATOS DEL CLIENTE 
					//Y LA MASCOTA.
						Cupo cupo_seleccionado = cupos_disponibles.get(num_cupo-1);
						
						if (clienteConocido!=true) {
							
							cliente = obtenerDatosCliente(); //DATOS DEL CLIENTE
							
							cliente = CentroAdopcion.esCliente(cliente); //COMPROBAR SI EL CLIENTE YA ESTÁ REGISTRADO
							leerCadena();
							}
							
							Mascota mascota = obtenerDatosMascota(servicioSeleccionado); //DATOS DE LA MASCOTA.
							
							//CREAR EL OBJETO DE TIPO CITA
							Cita nuevaCita = new Cita(cliente,mascota,empleado_seleccionado,cupo_seleccionado,servicioSeleccionado);
							
							citasAgendadas.add(nuevaCita);//AGREGAR LA CITA AL ARRAY DE CITAS QUE EL USUARIO ESTÁ AGENDANDO
							
							// si hay citas agendadas
							if (citasAgendadas.size() != 0) {
								boolean aplicarDescuento = false;
					
								// si el cliente tiene más de 15 puntos, se le ofrece un descuento
								if (cliente.getPuntos() > 15) {
									System.out.println("\nSr./Sra. " + cliente.getNombre() + " en estos momentos cuenta con " + cliente.getPuntos() + " puntos."
											+ "\n¿Desea hacer uso de 15 puntos para obtener un descuento del 10%?");
									String scanner;
									do {
										System.out.print("Responda si / no: ");
										scanner = leerCadena();
					
										if (!scanner.equalsIgnoreCase("si") && !scanner.equalsIgnoreCase("no")) {
											System.out.println("Proporcione una respuestata válida.\n");
										}
									} while (!scanner.equalsIgnoreCase("si") && !scanner.equalsIgnoreCase("no"));
					
									// si acepta el descuento, se aplica a todas las citas agendadas y se descuentan los puntos
									if (scanner.equalsIgnoreCase("si")) {
										aplicarDescuento = true;
					
										for (Cita cita : citasAgendadas) {
											cita.aplicarDescuento();
											cliente.disminuir_Puntos(15);
										}
					
										System.out.println("¡Descuento aplicado exitosamente! Se han descontado 15 puntos de su cuenta.");
									} else {
										System.out.println("No se aplicó el descuento.");
									}
								}
						
								// mostrar los detalles de las citas agendadas
							System.out.println("\n🗓️ DETALLES DE LAS CITAS AGENDADAS 🗓️");
				
							for (Cita cita : citasAgendadas) {
								System.out.println(cita);
								System.out.println("-----------------\n");
							}
			
		
							println("\n¡Cita agendada exitosamente!");
							
							
							println("\n¿Desea agendar otra cita?");
							String respuesta;
							leerCadena(); //CONSUMIR SALTO DE LÍNEA
							do {
								print("Responda si / no: ");
								respuesta= leerCadena();
								
								if (respuesta.equalsIgnoreCase("si")!=true && respuesta.equalsIgnoreCase("no")!=true) {
									println("Proporcione una respuestata válida.\n");
									
								}
							}while (respuesta.equalsIgnoreCase("si")!=true && respuesta.equalsIgnoreCase("no")!=true);
							
							if (respuesta.equalsIgnoreCase("si")==true) {
								
								repetir=true;
								clienteConocido = true;
							}
							else {
								repetir = false;
								clienteConocido = false;
							}     	    	    	    
						}   	    	    	
					}    
				}
			}
		}while(repetir);
		
	}
				
			// función para obtener los datos del cliente
		public static Cliente obtenerDatosCliente() {
			System.out.println("\nAntes de continuar, le informamos que para hacer uso del servicio seleccionado la persona encargada de la mascota debe ser mayor de edad.\n");
	
			String nombre;
			int edad = 0;
			long cedula = 0;
		
			System.out.println("Proporcione la siguiente información. ");
			System.out.print("Ingrese su nombre: ");
			nombre = leerCadena();
			while (edad <= 0) {
				try {
					System.out.print("Ingrese su edad: ");
					edad = leerEntero();
					if (edad <= 0) {
						System.out.println("Proporcione una respuestata válida.\n");
					}
				} catch (RuntimeException e) {
					System.out.println("Proporcione una respuestata válida.\n");
				} finally {
					leerCadena(); // consumir salto de línea
				}
			}
				// si el usuario es menor de edad, se piden los datos de un adulto responsable
			if (edad < 18) {
				System.out.println("El interesado en hacer uso del servicioSSeleccionado es menor de edad.\n");
				do {
					System.out.println("Proporcione los datos de un adulto responsable: ");
					System.out.print("Ingrese su nombre: ");
					nombre = leerCadena();
	
					try {
						System.out.print("Ingrese su edad: ");
						edad = leerEntero();
	
						if (edad <= 0) {
							System.out.println("Proporcione una edad válida.\n");
						}
		
						if (edad > 0 && edad < 18) {
							System.out.println("La edad ingresada no corresponde a la de un adulto.\n");
						}
	
					} catch (RuntimeException e) {
						System.out.println("Proporcione una respuestata válida.\n");
					} finally {
						leerCadena(); // consumir salto de línea
					}
				} while (edad < 18);
			}
		
			while (cedula <= 0) {
				try {
					System.out.print("Ingrese su número de identificación: ");
					cedula = leerEnteroLargo();
					if (cedula <= 0) {
						System.out.println("Proporcione una respuestata válida.\n");
						cedula = 0;
					}
				} catch (InputMismatchException e) {
					System.out.println("Proporcione una respuestata válida.\n");
					leerCadena();
				}
			}
		
				Cliente cliente = new Cliente(nombre, edad, cedula);
				return cliente;
			}
			public static Mascota obtenerDatosMascota(int servicio) {
				leerCadena();//CONSUMIR SALTO DE LÍNEA
				
				String nombre = null;
				int edad = 0;
				String especie = null;
				String sexo = null;
				
				println("\nProporcione la siguiente información sobre su mascota.");
				
				print("Ingrese el nombre: ");
				nombre= leerCadena();
				
				do {
					try {
						print("Ingrese la edad (meses): ");
						edad= leerEntero();
					
						if (edad<=0) {
							println("Proporcione una  respuesta válida.\n");
							}
						}catch(InputMismatchException e) {
							println("proporcione una respuesta válida.\n");
							leerCadena();
							}		
				}while(edad<=0);
				
				int eleccion=0;
				int opciones=0;
				
				println("\nSeleccione la especie de su mascota.");
				if (servicio==1 || servicio==3) {
					opciones=2;
					println("1. Perro \n2. Gato");
				}
				
				if (servicio==2) {
					opciones=4;
					println("1. Perro \n2. Gato\n3. Conejo \n4. Hámster");
				}
		
				do {		
					try {
						print("Ingrese su elección dentro del rango [1-"+ opciones +"]: ");
						eleccion=leerEntero();
						
						if (eleccion<1 || eleccion > opciones) {
							println("Opción fuera de rango.\n");
						}
						}catch(InputMismatchException e) {
							println("Se ha ingresado un tipo de dato incorrecto.\n");
							leerCadena();
							}
					}while(eleccion<1 || eleccion>opciones);
				
				switch(eleccion) {
				
				case 1:
					especie="Perro";
					break;
				case 2:
					especie= "Gato";
					break;
				case 3:
					especie ="Conejo";
					break;
				case 4:
					especie="Hámster";
					break;		
				}
				
				println("\nSeleccione el género de su mascota: ");
				println("1. Macho\n2. Hembra");
				eleccion=0;
				
				do {		
					try {
						print("Ingrese su elección dentro del rango [1-2]: ");
						eleccion=leerEntero();
						
						if (eleccion<1 || eleccion >2) {
							println("Proporcione una respuesta válida.\n");
						}
						}catch(InputMismatchException e) {
							println("Proporcione una respuesta válida.\n");
							leerCadena();//CONSUMIR SALTO DE LÍNEA
							}
					}while(eleccion<1 || eleccion>2);
				
				switch(eleccion) {
				
				case 1:
					sexo="Macho";
					break;
				case 2:
					sexo="Hembra";
					break;
				}
				
				Mascota mascota = new Mascota(nombre,especie, edad,sexo);
				
				return mascota;	
			}


//>>--------------------------------------------------------------------------------------------------------------------------------------<<

	
	public static void gestionarMemorial() {
		
		System.out.println("--------------------");
		System.out.println("\n- Ingrese sus datos");
		System.out.print("\n- Nombre Completo: ");
		String nombre = sc.nextLine();
		System.out.print("- Edad: ");
		int edad = sc.nextInt(); 
		sc.nextLine();
		System.out.print("- Cédula: ");
		long cedula = sc.nextLong();
		sc.nextLine();
		System.out.println("--------------------");
		
		Cliente cliente = new Cliente(nombre, edad, cedula);
		
		System.out.println("\n¿En dónde desea que su mascota sea atendida? (1-4):");
		centro.mostrarSedes();
		System.out.print("Ingrese el número correspondiente a la sede: ");
		int sede = sc.nextInt();
		sc.nextLine();
		while (sede < 1 || sede > Sedes.values().length) {
			System.out.println("scanner inválida. Por favor, ingrese un número entre 1 y " + Sedes.values().length + ":");
			sede = sc.nextInt();
			sc.nextLine();
		}
		
		centro.setSede(Sedes.values()[sede-1].name());
		String nombreSede  = Sedes.values()[sede-1].toString(); 
		nombreSede = nombreSede.substring(0,1).toUpperCase() + nombreSede.substring(1).toLowerCase();
		System.out.println("\nLa sede seleccionada es: " + nombreSede);
		
		int opcion = 0;
		while (opcion != 4) {
			System.out.println("\nGestion del Memorial:");
			System.out.println("1. Añadir memorial");
			System.out.println("2. Ver memorial");
			System.out.println("3. Decorar memorial");
			System.out.println("4. Volver al menu principal");
			
			opcion = leerEntero();
			
			switch (opcion) {
			case 1 -> {
			    System.out.println("Ingrese el nombre del fallecido:");
			    String nombreFallecido = sc.nextLine();
			    System.out.println("Ingrese la especie de la mascota:");
			    String especieFallecido = sc.nextLine();
			    System.out.println("Ingrese la edad que tenia al fallecer");
			    int edadMascota = sc.nextInt();
			    sc.nextLine();
			    Mascota mascota = new Mascota(nombreFallecido, especieFallecido, edadMascota, null, null, 0, 0);

			    System.out.println("Ingrese la fecha de fallecimiento (YYYY-MM-DD)");
			    String fecha = sc.nextLine();
			    System.out.println("¿Deseas dejar un mensaje? (si/no)");
			    String respuesta = sc.nextLine();

			    String mensaje;
			    if (respuesta.equalsIgnoreCase("Si")) {
			        System.out.println("Ingrese su mensaje:");
			        mensaje = sc.nextLine();
			    } else {
			        mensaje = "Descansa en paz " + nombreFallecido;
			    }
			    System.out.println("Por cuanto tiempo desea usar nuestros servicios(1/2):");
			    System.out.println("1. Para siempre.");
			    System.out.println("2. Tiempo limitado.");
			    int duracion = sc.nextInt();
			    sc.nextLine();

			    float precio = 0;
			    String tiempo = null;
			    if (duracion == 1) {
			        tiempo = "Forever";
			        precio = 1000000;
			    } else if (duracion == 2) {
			        System.out.println("Ingrese el tiempo que desea usar nuestros servicios (En multiplos de 5):");
			        int anos = sc.nextInt();
			        sc.nextLine();
			        if (anos % 5 != 0) {
			            System.out.println("El tiempo debe de ser en multiplos de 5 años. Redondearemos al múltiplo más cercano.");
			            anos = ((anos + 4) / 5) * 5;
			        }
			        tiempo = anos + " años";
			        precio = (anos / 5) * 50000;
			    } else {
			        System.out.println("Opcion no valida.");
			        break;
			    }

			    String tipo;
			    while (true) {
			        System.out.println("Ingrese el tipo de memorial que desea (Sepulcro/Osario/Cremacion/Arbol):");
			        tipo = sc.nextLine();

			        if (tipo.equalsIgnoreCase("Sepulcro") || tipo.equalsIgnoreCase("Osario") || 
			            tipo.equalsIgnoreCase("Cremacion") || tipo.equalsIgnoreCase("Arbol")) {
			            break;
			        } else {
			            System.out.println("Opción no válida. Por favor, ingrese una de las opciones válidas: Sepulcro, Osario, Cremacion, Arbol.");
			        }
			    }

			    Fallecido fallecido = new Fallecido(mascota, fecha, mensaje, cliente, tiempo, tipo);

			    if (memorial.cupos(tipo)) {
			        if (memorial.anadirFallecido(fallecido, tipo)) {
			            System.out.println("Memorial añadido con éxito.");
			            System.out.println("Precio del servicio: $" + precio);
			        } else {
			            System.out.println("De momento no contamos con este tipo de servicio.");
			        }
			    } else {
			        System.out.println("No hay cupos disponibles para " + tipo + ".");
			    }
			}
				
			case 2 -> {
			    System.out.println("Ingrese el tipo de memorial que desea ver (Sepulcro/Osario/Cenizas/Arbol):");
			    String tipo = sc.nextLine();

			    ArrayList<Fallecido> listaFallecidos = memorial.obtenerFallecidosPorTipo(tipo);
			
			    if (listaFallecidos == null || listaFallecidos.isEmpty()) {
			        System.out.println("No hay registros en esta categoría.");
			    } else {
			        System.out.println("Lista de registros en " + tipo + ":");
			        System.out.println(memorial.visitaMemorial(listaFallecidos));
			    }
			}

			case 3 -> {
			    System.out.println("Ingrese el tipo de memorial al cual desea agregar flores (Sepulcro/Osario/Cenizas/Arbol):");
			    String tipo = sc.nextLine();

			    ArrayList<Fallecido> listaFallecidos = memorial.obtenerFallecidosPorTipo(tipo);

			    if (listaFallecidos == null || listaFallecidos.isEmpty()) {
			        System.out.println("No hay registros en este tipo de memorial.");
			    } else {
			        System.out.println("Lista de memoriales disponibles en " + tipo + ":");
			        System.out.println(memorial.visitaMemorial(listaFallecidos));

			        System.out.println("Ingrese el número del memorial al cual desea agregar flores:");
			        int seleccion = sc.nextInt();
			        sc.nextLine();

			        if (seleccion >= 1 && seleccion <= listaFallecidos.size()) {
			            Fallecido seleccionado = listaFallecidos.get(seleccion - 1);

			            System.out.println("Ingrese el nombre de la flor que desea agregar:");
			            String flor = sc.nextLine();

			            String resultado = seleccionado.ponerFlor(flor);
			            System.out.println(resultado);
			        } else {
			            System.out.println("Selección no válida.");
			        }
			    }
			}

			case 4 -> System.out.println("Volviendo al menu principal...4");
			}
		}
	}

//>>--------------------------------------------------------------------------------------------------------------------------------------<<
public static void tienda() {
		

		
	//CREAMOS UN EMPLEADO PARA QUE ATIENDA LA TIENDA
	Empleado empliado = new Empleado("Albert", 22, 555, 1323, "West Elm", Empleado.Especialidad.VENDEDOR);
	
	// CREACIÓN DE TIENDA
	//t1 = new Tienda(empliado, sede1);
	Tienda t1 = new Tienda(empliado,sede1);
	
	// BUCLE QUE MANTIENE LA OPERACION DE LA TIENDA, DE ROMPERSE, SE TERMINA LA FUNCIONALIDAD
	
	boolean bucle = true; // VARIABLE PARA EL SEGUNDO MENÚ
	
	println("\n - - ¡Bienvenido a la tienda de mascotas del Centro de cuidado Mascota: UNamascota! - - ");
	println("Aquí encontrarás los mejores productos para el cuidado y la diversión de tu compañero peludo.\n");
	
	while (true) { 
	
		println("-----------------------------");
		println("\n¿Qué te trae por estos lares amante de los peluditos?");
		println("1. Ir de compras");
		println("2. Salir\n");
		print("Ingrese el número de la opción que desea [1-2]: ");
		
		int menu = 0; // ENTERO QUE EL USUARIO VA A INGREASAR, PARA ESCOGER OPCION 
		while (menu==0) { //MIENTRAS EL ENTERO SEA CERO (PARA CONTROLAR QUE EL USUARIO LE DÉ UN VALOR)
			try {//CONTROL DE ERRORES 
				menu = leerEntero(); //SE LEE EL ENTERO 
				if (menu>0 && menu<=2) { //SI ESTÁ ENTRE 1 Y 2 TERMINA 
					break;
				}
				else {
					println("¡Oh no!, Ingrese un número válido por favor");
					menu = 0;
					continue;
				}
			}
			catch(InputMismatchException e) {
				println("Por favor ingrese un índice disponible (Pista: Entre 1 y 2)");
			}
			finally {
					scanner.nextLine();//SALTO DE LINEA
				}
		}
		
	if (menu==1) {	// OPCION 1 DEL PRIMER MENÚ, ADQUIRIR PRODCUTO.		
		while (bucle==true) { //UTILIZAMOS LA VARIABLE BUCLE INICIADA ANTES DEL PRIMER WHILE
			
			println("\n--------------------------------------------------------");
			println("\n¿Cómo desea que se le muestren los productos?");
			println("1. Mostrar todo");
			println("2. Filtrar por tipo\n");
			print("Ingrese el número de la opción que desea [1-2]: \n");
			println("\n--------------------------------------------------------");
				
			int menuTienda = 0; // VOLVEMOS A RECIBIR UNA scanner, ESTA VEZ PARA DECIDIR COMO FILTRAR LOS PRODUCTOS
			while (menuTienda==0) {
				try {
					menuTienda = leerEntero();
					if (menuTienda>0 && menuTienda<=2) { // SE CONTROLA QUE ESTÉ DENTRO DEL RANGO 
						break;
					}
					else {
						println("Por favor ingrese un índice disponible (Pista: Entre 1 y 2)");
						menuTienda = 0;
						continue;
					}
				}
				catch(InputMismatchException e) {
					println("Por favor ingrese un índice disponible (Pista: Entre 1 y 2)");
				}
				finally {
					scanner.nextLine();//SALTO DE LINEA
				}
			}
			
			if (menuTienda==1) { //EN CASO DE QUE SE QUIERA VISUALIZAR TODOO	
				println("\nProductos disponibles:");
				println(t1.inventario()); // SE LLAMA AL MÉTODO INVENTARIO DE TIENDA, PARA QUE DEVULVA TODOS LOS PRODUCTOS SIN MÁS
			}
			else { // DE LO CONTRARIO, SE LE VOLVERÁ A PEDIR UNA scanner PARA QUE INDIQUE POR QUE TIPO DE Mascota QUIERE VER 
				print("\n¿Por qué tipo de Mascota te gustaría ver? [perros, gatos, aves o conejos]: ");
				while (true) { //BUCLE PARA CONTROLAR ÉSTE NUEVO MENÚ
					try {
						String tipo = leerCadena(); // SE LEE EL STRING 
						tipo.toLowerCase(); // SE PONE EL TEXTO EN MINÚSCULAS
						
						//LUEGO LO COMPARAMOS EN ESTE GRUPO DE CONDICIONALES SIMPLES 
						
						switch (tipo.toLowerCase()) {
							case "perros":
								println("\nProductos disponibles: \n");
								println(t1.filtrar("Perro"));
								break;
							case "perro":
								println("\nProductos disponibles: \n");
								println(t1.filtrar("Perro"));
								break;
							case "gatos":
								println("\nProductos disponibles: \n");
								println(t1.filtrar("Gato"));
								break;
							case "gato":
								println("\nProductos disponibles: \n");
								println(t1.filtrar("Gato"));
								break;
							case "aves":
								println("\nProductos disponibles: \n");
								println(t1.filtrar("Ave"));
								break;
							case "ave":
								println("\nProductos disponibles: \n");
								println(t1.filtrar("Ave"));
								break;
							case "conejos":
								println("\nProductos disponibles: \n");
								println(t1.filtrar("Conejo"));
								break;
							case "conejo":
								println("\nProductos disponibles: \n");
								println(t1.filtrar("Conejo"));
								break;
							default:
								println("Por favor, ingrese el tipo del Mascota en minúsculas [perros, gatos, aves o conejos]");
								continue;
						}

						break;
					}
					catch(InputMismatchException e) {
						println("Por favor, coloque un tipo valido de Mascota");
					}
				}
			}
			
			// UNA VEZ QUE AL USUARIO SE LE IMPRIMIÓ LOS PRODUCTOS, VENIMOS ACÁ A CONTROLAR LA COMPRA
			
			boolean control = true;
			while (control) {
				try {
					print("Digite el índice del producto a comprar: ");
					int indice = leerEntero(); //INDICE PARA LOCALIZAR EL PRODUCTO QUE QUIERE EL USUARIO 
		
					print("Indique cuantas unidades necesita del producto: ");
					int unidades = leerEntero(); //CANTIDAD DE UNIDADES QUE EL USUARIO VA A COMPRAR
						
					//  REGISTRO DEL USUARIO PARA REALIZAR LA COMPRA-------------------------------------
						
					if (unidades==1) { //SI SOLO VA A COMPRAR UNA UNIDAD
						println("\nSus datos serán tomados para registrar la compra.");
						print("Ingrese su cédula: ");
						long cedula = scanner.nextLong();
						print("Ingrese su edad: ");
						int edad = scanner.nextInt();
						print("Ingrese su nombre: ");
						scanner.nextLine();
						String nombre = leerCadena();
							
						//SE REGISTA EL USUARIO, CREANDO UN OBJETO DEL TIPO CLIENTE Y PASANDOLO AL MÉTODO COMPRA DE TIENDA 
						Cliente cliente = new Cliente(nombre, edad, cedula);
						println("\n"+t1.compra(indice, cliente)); 
						//ESTE FILTRO DE: UNIDADES == 1, ES PORQUE EL MÉTODO COMPRA QUE RECIBE DOS PARÁMETROS RETORNA ALGO MÁS ADECUADO PARA ESTE CASO 
					}
					else { // CUANDO EL USUARIO VA A COMPRAR MÁS DE UNA UNIDAD 
						println("\nSus datos serán tomados para registrar la compra.");
						print("Ingrese su cédula: ");
						long cedula = scanner.nextLong();
						print("Ingrese su edad: ");
						int edad = scanner.nextInt();
						print("Ingrese su nombre: ");
						scanner.nextLine();
						String nombre = leerCadena();
						print("Ingrese su número de teléfono: ");
						long telefono = scanner.nextLong();
						print("Ingrese su dirección: ");
						scanner.nextLine();
						String direccion = leerCadena();
							
						// SE REGISTA EL USUARIO, CREANDO UN OBJETO DEL TIPO CLIENTE Y PASANDOLO AL MÉTODO COMPRA DE TIENDA
						// SE LE AGREGA TAMBIEN, LA CANTIDAD DE UNIDADES AL MÉTODO COMPRA 
						Cliente cliente = new Cliente(nombre, edad, cedula, telefono, direccion);
						println("\n"+t1.compra(indice, unidades, cliente));
					}
						
					// --------------------------------------------------------------------------------
						
					control = false;
					
				}
				catch(InputMismatchException e) {
					println("Por favor lea e ingrese correctamente los datos\n");
				}
				
			}
			
			// SE LE PIDE SI DESEA VOLVER A REINICIAR EL CICLO DESDE EL MENÚ DE COMPRA 
			print("\n¿Desea volver al catálogo? [si/no]: ");
			String respuesta = " ";
			while (true) {//CONTROL CON UN WHILE SOLAMENTE, HASTA QUE NO RECIBA UNA respuestaTA VÁLIDA.
				respuesta = scanner.nextLine();
				respuesta.toLowerCase();
				if (respuesta.equals("si")||respuesta.equals("no")) {
					break; 
				}else {
					println("Por favor, ingrese una respuestata válida [si/no]");
					continue;
				}
			}
				if (respuesta.equals("si")) {
					continue; //VOLVER A INICIAR CICLO DE COMPRA
				}
				else {
					println("Esperamos verlo por aquí pronto.\n");
					break; // SALIR DE LA TIENDA 
				}
			}//BUCLE COMPRAR
	}//CONDICINAL MENU INGRESAR TIENDA
	else {
		break;//OPCION 2 SALIR
	}
	}//BUCLE INICIAL
}//FINAL MÉTODO TIENDA

public static void planificacionDieta() {

	//registro del cliente
	System.out.println("--------------------");
	System.out.println("\n- Ingrese sus datos");
	System.out.print("\n- Nombre Completo: ");
	String nombreC = sc.nextLine();
	System.out.print("- Edad: ");
	int edadC = sc.nextInt(); 
	sc.nextLine();
	System.out.print("- Cédula: ");
	long cedula = sc.nextLong();
	sc.nextLine();
	System.out.println("\n--------------------");
	
	Cliente cliente = new Cliente(nombreC, edadC, cedula);
	cliente.agregarPuntos(0);

	//ingresar datos de la mascota
		System.out.println("\nIngresa los datos de su mascota:");
		System.out.println("Nombre:");
		String nombre = Main.leerCadena();
		
		System.out.println("Especie:");
		String tipo = "";
		while (true) {//validar que la especie introducida sea valido.
			tipo = Main.leerCadena();
			if (tipo.equalsIgnoreCase("Gato") || tipo.equalsIgnoreCase("Perro")) {
				break;
			} else {
				System.out.println("Lo sentimos, la planificacion de dieta solo esta disponible para gatos y perros.");
				return;
			 }
		}
		
		System.out.println("Edad:");
		int edad = Main.leerEntero();
		
		System.out.println("Sexo (M/F):");
		String sexo = "";
		while (true) {//validar que el dato introducido sea valido.
			sexo = Main.leerCadena();
			if (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("F")) {
				break;
			} else { System.out.println(""); }
		}
		
		System.out.println("Tamaño (1-4): \n1. Miniatura \n2. Pequeño \n3. Mediano \n4. Grande");
		int tamano = 3;
		while (true) {//validar que el dato introducido sea valido.
			tamano = Main.leerEntero();
			if (tamano > 0 && tamano < 5) {
				break;
			} else { System.out.println("Entrada no valida, intentalo de nuevo."); }
		}
		
		System.out.println("Peso en kg:");
		double peso = Main.leerDouble();

		//Crear un objeto Mascota con los datos que ingresó el usuario
		Mascota mascota = new Mascota(nombre, tipo, edad, sexo, EstadoSalud.SANO, tamano, peso);
		//Crea el objeto dieta asociado a la mascota
		Dieta dieta = new Dieta(mascota);
		//utiliza las formulas aritmeticas de los metodos calcularPesoIdeal() y planDieta() para calcular el porcentaje de nutrientes que debe
		//consumir la mascota, dependiendo de su debe subir o bajar de peso.
		dieta.calcularPesoIdeal();
        dieta.planDieta();
		//imprime la dieta planificada

		System.out.println("\n--------------------\n");

		System.out.println(dieta.toString());

		System.out.println("\n--------------------");


		//Mini tienda de productos dieteticos
		
		// Determinar el tipo de Dieta bar (perro o gato)
		String tipoDietaBar = tipo.equalsIgnoreCase("Perro") ? "Dieta Bar para Perros" : "Dieta Bar para Gatos";

		// Creaion de la tienda y de los productos dieta bar.
		Tienda tienda = new Tienda(new Empleado("Albert", 22, 555, 1323, "West Elm", Empleado.Especialidad.VENDEDOR));
		Producto[] productosBar = {
			new Producto("Dieta Bar Alto en Proteinas para " + tipo + " (Gramo)" , 45f, "Dieta", "Alimento para " + tipo , 1000),
			new Producto("Dieta Bar Alto en Grasas para " + tipo + " (Gramo)" , 45f, "Dieta", "Alimento para " + tipo, 1000),
			new Producto("Dieta Bar Alto en Carbohidratos para " + tipo + " (Gramo)" , 45, "Dieta", "Alimento para " + tipo , 1000)
		};

		for (Producto producto : productosBar) {
			Tienda.agregarProducto(producto);
		}

		// Compra de Dieta bar
		System.out.println("\n¿Desea adquirir Dieta Bar para su mascota? [si/no]:");
		
		while (true) {
				String respuesta = Main.leerCadena();
				if (respuesta.equalsIgnoreCase("si")) { 
				// Mostrar opciones de Dieta BAR desde el inventario
				System.out.println("\nSabores disponibles de " + tipoDietaBar + ":");
				System.out.println(tienda.filtrar("Dieta"));
				System.out.println("Ingrese el número del sabor que desea:");
				int opcionSabor = Main.leerEntero();
				System.out.println("Ingrese la cantidad en gramos que desea comprar:");
				int cantidadGramos = Main.leerEntero();

				String resultadoCompra = tienda.compra(opcionSabor, cantidadGramos, cliente);
				System.out.println(resultadoCompra);
				System.out.println("Desear seguir comprando? [Si/No]");
				} else if (respuesta.equalsIgnoreCase("no")) {
					System.out.println("\nGracias por ingresar a la interaz de planeacion de dieta!\nRedireccionandote al menu principal...\n");
					break;
				} else {
				System.out.println("");
				}
		}

}//Fin de Planeacion Dieta

}