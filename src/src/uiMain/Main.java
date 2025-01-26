package uiMain;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import gestorAplicacion.elementos.CentroAdopcion;
import gestorAplicacion.elementos.Empleado;
import gestorAplicacion.elementos.Empleado.Especialidad;
import gestorAplicacion.elementos.Mascota;
import gestorAplicacion.elementos.CentroAdopcion.Sedes;
import gestorAplicacion.elementos.Cliente;
import gestorAplicacion.elementos.Cupo;
import gestorAplicacion.elementos.Mascota.EstadoSalud;
import gestorAplicacion.gestion.Cita;


		

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static CentroAdopcion centro = new CentroAdopcion("POO");
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<CentroAdopcion> sedes = new ArrayList<>();
		
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		System.out.println("Bienvenido a la veterinaria virtual.");
		System.out.println("\nIngrese sus datos");
		System.out.println("\nNombre:");
		String nombre = sc.nextLine();
		System.out.println("Edad:");
		int edad = sc.nextInt(); 
		sc.nextLine();
		System.out.println("Cédula:");
		long cedula = sc.nextLong();
		
		Cliente cliente = new Cliente(nombre, edad, cedula);
		cliente.agregarPuntos(50000);
		
		while (opcion != 6) {
			
            System.out.println("\n¿Qué desea hacer?");
            System.out.println("\n1. Emergencia Veterinaria");
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
            		System.out.println("\nBienvenido a Emergencia Veterinaria.");
            		emergenciaVeterinaria(cliente);
            		break;
            	case 2:
            		System.out.println("Bienvenido a la funcionalidad 2.");
					//agendarServicio();
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
	//Para leer un entero desde la entrada.
	public static int leerEntero() {
		while (true) {
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				scanner.next(); // Limpiar la entrada no válida
			}
		}
	}
	
	//Para leer un número largo desde la entrada.
public static long leerEnteroLargo() {
    while (true) {
        try {
            return scanner.nextLong();
        } catch (InputMismatchException e) {
            scanner.next(); // Limpiar la entrada no válida
        }
	}
}
	//Para leer una cadena de texto desde la entrada.
	public static String leerCadena() {
		return scanner.nextLine();
	}

	public static void emergenciaVeterinaria(Cliente cliente) {
		
		
		
		//Veterinarios en en centro de adopción. Agregar más
		centro.agregarVeterinario(new Empleado("Alberto", 27, 125734625, 321215589, null, Especialidad.VETERINARIO));
		centro.agregarVeterinario(new Empleado("Ricardo", 38, 125846225, 321765589, null, Especialidad.VETERINARIO));
		//---------------------------------------------------
		
		//Pedir datos de la mascota al usuario
		System.out.println("\nIngrese los datos de su mascota:");
		System.out.println("Nombre:");
		String nombre = sc.nextLine();
		
		System.out.println("Especie:");
		String tipo = sc.nextLine();
		
		System.out.println("Edad:");
		int edad = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Sexo (M/F):");
		String sexo = sc.nextLine();
		
		System.out.println("Tamaño (1-4): \n1. Miniatura \n2. Pequeño \n3. Mediano \n4. Grande");
		int tamano = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Peso en kg:");
		double peso = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Síntomas (sin comas):");
		String sintomas = sc.nextLine();
		String[] listaSintomas = sintomas.split(" ");
		//---------------------------------------------------
		
		//Crear instancia de Mascota con los datos que ingresó el usuario
		Mascota mascota = new Mascota(nombre, tipo, edad, sexo, EstadoSalud.ENFERMO, tamano, peso);
		centro.agregarHospitalizado(mascota);
		//---------------------------------------------------
		
		//Pedirle al usuario que elija la sede y asignarla a la instancia de centro de adopción
		System.out.println("\n¿En dónde desea que su mascota sea atendida? (1-4):");
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
		System.out.println("\nLa sede seleccionada es: " + nombreSede);
		//---------------------------------------------------
		
		//Verificar si la mascota debe ser hospitalizada
		if (centro.verificarHospitalizacion(mascota)) {
			
			int gravedad = 0;
			int compatibilidad = 0;
			
			//Asignar valores de gravedad y compatibilidad a los síntomas
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
	                    System.out.println("\nSintoma desconocido: " + sintoma);
	                    break;
	            }
	        }
			//---------------------------------------------------
			
			//Verificar que el Índice de Emergencia de la mascota sea mayor a 7.0 para confirmar hospitalización
			if (!centro.gestionarVeterinario().isEmpty() && mascota.indiceEmergencia(gravedad, compatibilidad) >= 7.0) {
				
				System.out.println("\nSu mascota puede ser hospitalizada.");
				System.out.println("\nElija uno de los siguientes veterinarios disponibles:\n");
				
				for (int i = 0 ; i < centro.gestionarVeterinario().size() ; i++) {
					System.out.println(i+1 + ". " + centro.gestionarVeterinario().get(i));
				}
				
				int opcion = sc.nextInt();
				sc.nextLine();
				
				//Verificar que el usuario ingrese un número en el rango correcto
				while(opcion < 1 || opcion > centro.gestionarVeterinario().size()) {
					System.out.println("\nEntrada inválida. Por favor, ingrese un número entre 1 y " + centro.gestionarVeterinario().size() + ":");
					opcion = sc.nextInt();
					sc.nextLine();
				}
				//---------------------------------------------------
				
				System.out.println("\nSu veterinario asignado es\n" + centro.gestionarVeterinario().get(opcion-1));
				centro.asignarVeterinario(mascota, centro.gestionarVeterinario().get(opcion-1));
				//mascota.setVeterinario(centro.gestionarVeterinario().get(opcion-1));	//Asignar veterinario a la mascota
				//centro.gestionarVeterinario().get(opcion-1).setMascota(mascota);	//Asignar mascota al veterinario
				
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
				while(opcion < 1 || opcion > centro.mostrarOpcionesPago().length) {
					System.out.println("Entrada inválida. Por favor, ingrese un número entre 1 y " + centro.mostrarOpcionesPago().length + ":");
					opcion = sc.nextInt();
					sc.nextLine();
				}
				//---------------------------------------------------
				
				//sc.close();
				
				switch (pago) {
					case 1:
						centro.procesarPago(1, cliente, 20000);
						centro.generarFactura(cliente, mascota, 20000);
						//System.out.println("Saliendo de Emergencia Veterinaria");
						break;
					case 2:
						centro.procesarPago(2, cliente, 32000);
						centro.generarFactura(cliente, mascota, 32000);
						//System.out.println("Saliendo de Emergencia Veterinaria");
						break;
					case 3:
						centro.procesarPago(3, cliente, 20000);
						centro.generarFactura(cliente, mascota, 20000);
						//System.out.println("Saliendo de Emergencia Veterinaria");
						break;
					default:
						break;
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
				//planificacionDieta();
			}
			
		}
		
		else {
			System.out.println("No hay veterinarios dispobibles en esta sede.");
		}
		//sc.close();
	}

}



	//>>-----------------------------------------------------------------------------------------------------------------<<

			
	/*	// función para agendar un servicio
	static void agendarServicio(){
		ArrayList<Cita> citasAgendadas = new ArrayList<>();
		System.out.println("\n\n🐾 ¡Bienvenido a PetTraining! 🐾");
		System.out.println("Gracias por elegirnos para cuidar y entrenar a tu peludito.");			
		System.out.println("Por favor, sigue las instrucciones a continuación para que podamos atenderlo de la mejor manera.\n");
		
		boolean repetir = false;
		Cliente cliente = null;

		// obtener los datos del cliente y verificar si está registrado
		cliente = obtenerDatosCliente();
		cliente = CentroAdopcion.EsCliente(cliente); // comprobar si el cliente ya está registrado
		leerCadena(); // consumir salto de línea
		
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
						System.out.println("Proporcione una respuesta válida.\n");
					}
					} catch (InputMismatchException e) {
						System.out.println("Proporcione una respuesta válida.\n");
					} finally {
						leerCadena();
					}
				} while (sedeSeleccionada < 1 || sedeSeleccionada > 4);
		
			// mostrar los servicios disponibles según la sede seleccionada
			System.out.println("\n📋 Servicios Disponibles 📋");
			switch (sedeSeleccionada) {
				case 1:
					System.out.println("SEDE CENTRO - Servicios: \n1. Entrenamiento \n2. Veterinaria");
					break;
				case 2:
					System.out.println("SEDE NORTE - Servicios: \n1. Peluquería");
					break;
				case 3:
					System.out.println("SEDE SUR - Servicios: \n1. Veterinaria \n2. Entrenamiento");
					break;
				case 4:
					System.out.println("SEDE OESTE - Servicios: \n1. Entrenamiento");
					break;
			}
		
			System.out.println("3. Cambiar de sede\n");
		
			// pedir al usuario que seleccione un servicio o cambiar de sede
			do {
				System.out.print("Ingrese su elección dentro del rango [1-3]: ");
				try {
					servicioSeleccionado = leerEntero();
					if (servicioSeleccionado < 1 || servicioSeleccionado > 3) {
						System.out.println("Proporcione una respuesta válida.\n");
					}
				} catch (InputMismatchException e) {
					System.out.println("Proporcione una respuesta válida.\n");
				} finally {
					leerCadena();
				}
			} while (servicioSeleccionado < 1 || servicioSeleccionado > 3);
		
			// si el usuario decide cambiar de sede
			if (servicioSeleccionado == 3) {
				continue;
			}
		
			// verificar si el servicio está disponible para la especie de la mascota del cliente
			boolean servicioDisponible = false;
			switch (sedeSeleccionada) {
				case 1:
					if (servicioSeleccionado == 1) {
					// entrenamiento incluye guardería
						System.out.println("\nEl servicio de entrenamiento (incluye guardería) está disponible para perros y gatos.");
						//servicioDisponible = confirmarEspecie("perros y gatos");
					} else if (servicioSeleccionado == 2) {
						System.out.println("\nEl servicio de veterinaria está disponible para perros, gatos, conejos y hámsters.");
						//servicioDisponible = confirmarEspecie("perros, gatos, conejos y hámsters");
					}
					break;
				case 2:
					if (servicioSeleccionado == 1) {
						System.out.println("\nEl servicio de peluquería está disponible para perros y gatos.");
						//servicioDisponible = confirmarEspecie("perros y gatos");
					}
					break;
				case 3:
					if (servicioSeleccionado == 1) {
						System.out.println("\nEl servicio de veterinaria está disponible para perros, gatos, conejos y hámsters.");
						//servicioDisponible = confirmarEspecie("perros, gatos, conejos y hámsters");
					} else if (servicioSeleccionado == 2) {
					// entrenamiento incluye guardería
						System.out.println("\nEl servicio de entrenamiento (incluye guardería) está disponible para perros y gatos.");
						//servicioDisponible = confirmarEspecie("perros y gatos");
					}
					break;
				case 4:
					if (servicioSeleccionado == 1) {
					// entrenamiento incluye guardería
						System.out.println("\nEl servicio de entrenamiento (incluye guardería) está disponible para perros y gatos.");
						//servicioDisponible = confirmarEspecie("perros y gatos");
					}
					break;
				}
		
			// si el servicio no está disponible para la especie, se termina el proceso
			if (!servicioDisponible) {
				System.out.println("\nNos disculpamos, pero el servicio que desea no está disponible para su tipo de mascota. Agradecemos su comprensión.\n");
				repetir = false;
				continue;
			}
		
			// obtener la sede seleccionada y los empleados disponibles
			CentroAdopcion sede = sedes.get(sedeSeleccionada - 1);
			ArrayList<Empleado> empleadosDisponibles = sede.tieneEmpleados();
		
			// si no hay empleados disponibles, se termina el proceso
			if (empleadosDisponibles.size() == 0) {
				System.out.println("\nActualmente, debido a la falta de disponibilidad de citas, no es posible continuar con el proceso de agendamiento.");
				repetir = false;
				continue;
			} else {
			// mostrar los empleados disponibles según el servicio seleccionado
				switch (servicioSeleccionado) {
					case 1:
						System.out.println("\nContamos con los siguientes entrenadores, seleccione el de su preferencia:");
						break;
					case 2:
						System.out.println("\nContamos con los siguientes veterinarios, seleccione el de su preferencia:");
						break;
				}
		
						int indiceEmpleado = 1;
						for (Empleado emp : empleadosDisponibles) {
							System.out.println(indiceEmpleado + " - " + emp);
							indiceEmpleado++;
						}
		
						// pedir al usuario que seleccione un empleado
						int numEmpleadoSeleccionado = 0;
						do {
							System.out.print("\nIngrese su elección dentro del rango [1-" + empleadosDisponibles.size() + "]: ");
							try {
								numEmpleadoSeleccionado = leerEntero();
								if (numEmpleadoSeleccionado < 1 || numEmpleadoSeleccionado > empleadosDisponibles.size()) {
									System.out.println("Proporcione una respuesta válida.");
								}
							} catch (InputMismatchException e) {
								System.out.println("Proporcione una respuesta válida.");
							} finally {
								leerCadena();
							}
						} while (numEmpleadoSeleccionado < 1 || numEmpleadoSeleccionado > empleadosDisponibles.size());
		
						Empleado empleadoSeleccionado = empleadosDisponibles.get(numEmpleadoSeleccionado - 1); // empleado seleccionado
						System.out.println("Empleado seleccionado: " + empleadoSeleccionado);
		
						// selección del día de la cita
						System.out.println("\nSeleccione el día en el que desea el servicio.");
						String[] diasSemana = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado"};
						int diaSeleccionado = 0;
						for (int j = 0; j < diasSemana.length; j++) {
							System.out.println((j + 1) + ". " + diasSemana[j]);
						}
		
						// pedir al usuario que seleccione un día
						do {
							try {
								System.out.print("Ingrese su elección dentro del rango [1-6]: ");
								diaSeleccionado = leerEntero();
								if (diaSeleccionado < 1 || diaSeleccionado > 6) {
									System.out.println("Proporcione una respuesta válida.\n");
								}
							} catch (InputMismatchException e) {
								System.out.println("Proporcione una respuesta válida.\n");
								leerCadena();
							}

							ArrayList <Cupo> cuposDisponibles = empleadoSeleccionado.cuposDisponibles(num_dia);
        	    
							//SI EL EMPLEADO NO TIENE CUPOS PARA ESE DÍA, ENTONCES EL PROCESO NO PODRÁ CONTINIAR.
							if (cuposDisponibles.size()==0) {
								System.out.println("Lamentablemente, el empleado seleccionado no tiene disponibilidad para el día que se eligió.");
								repetir = false;
							}
							else {
								//SI EL EMPLEADO TIENE CUPOS PARA EL DIA SELECCIONADO, ENTONCES SE LE MOSTRARÁN AL CLIENTE
								System.out.println("\nPor favor, seleccione la franja horaria que mejor se adapte a su necesidad. Si ninguna opción es adecuada,"
										+ "\npuedes seleccionar la opción " + (cuposDisponibles.size()+1) +" para cancelar.\n");
								
								System.out.println("Cupos disponibles para el " + diasSemana[num_dia -1] + " " + cuposDisponibles.get(0).fechaFormateada() + ": "); 
								int o = 1;
								for (Cupo cupo: cuposDisponibles) {
									
									System.out.println( o + ". " + cupo);
									
									o++;
								}
								System.out.println((cuposDisponibles.size()+1) + ". Cancelar");
								
								//SELECCIONAR EL CUPO DE PREFERENCIA, O CANCELAR
								int num_cupo=0;
								do {
									try {
										System.out.print("Ingrese su elección en el rango en el rango [1 -" + (cuposDisponibles.size()+1) +"]: ");
										num_cupo = leerEntero();
									
										if (num_cupo<1 || num_cupo>(cuposDisponibles.size()+1)) {
											System.out.println("Proporcione una respuesta válida");
										}
										
								 }catch(InputMismatchException e) {
									System.out.println("Proporcione una respuesta válida.");
								}
									finally {
										leerCadena(); //CONSUMIR SALTO DE LÍNEA
									}

							} while (num_cupo < 1 || num_cupo > (cuposDisponibles.size() + 1));
		
							// si el usuario decide cancelar el proceso de agendamiento
							if (num_cupo == (cuposDisponibles.size() + 1)) {
								System.out.println("Se ha cancelado el agendamiento de la cita.");
							} else {
								// si el usuario selecciona un cupo, se procede a recoger los datos del cliente y la mascota
								Cupo cupoSeleccionado = cuposDisponibles.get(num_cupo - 1);
		
								// crear el objeto de tipo cita
								Cita nuevaCita = new Cita(cliente, null , empleadoSeleccionado, cupoSeleccionado, servicioSeleccionado);
		
								// agregar la cita al array de citas que el usuario está agendando
								citasAgendadas.add(nuevaCita);
		
								System.out.println("\n¡Cita agendada exitosamente!");
		
								// preguntar al usuario si desea agendar otra cita
								System.out.println("\n¿Desea agendar otra cita?");
								String respuesta;
								leerCadena(); // consumir salto de línea
								do {
									System.out.print("Responda si / no: ");
									respuesta = leerCadena();
		
									if (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) {
										System.out.println("Proporcione una respuesta válida.\n");
									}
								} while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no"));
		
								if (respuesta.equalsIgnoreCase("si")) {
									repetir = true;
								} else {
									repetir = false;
								}
							}
						}
					}
				} while (repetir);
		
				// si hay citas agendadas
				if (citasAgendadas.size() != 0) {
					boolean aplicarDescuento = false;
		
					// si el cliente tiene más de 15 puntos, se le ofrece un descuento
					if (cliente.getPuntos() > 15) {
						System.out.println("\nSr./Sra. " + cliente.getNombre() + " en estos momentos cuenta con " + cliente.getPuntos() + " puntos."
								+ "\n¿Desea hacer uso de 15 puntos para obtener un descuento del 10%?");
						String entrada;
						do {
							System.out.print("Responda si / no: ");
							entrada = leerCadena();
		
							if (!entrada.equalsIgnoreCase("si") && !entrada.equalsIgnoreCase("no")) {
								System.out.println("Proporcione una respuesta válida.\n");
							}
						} while (!entrada.equalsIgnoreCase("si") && !entrada.equalsIgnoreCase("no"));
		
						// si acepta el descuento, se aplica a todas las citas agendadas y se descuentan los puntos
						if (entrada.equalsIgnoreCase("si")) {
							aplicarDescuento = true;
		
							for (Cita cita : citasAgendadas) {
								cita.aplicarDescuento();
								cliente.disminuirPuntos(15);
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
				}
			}
			// función para obtener los datos del cliente
			public static Cliente obtenerDatosCliente() {
				System.out.println("\nAntes de continuar, le informamos que para hacer uso del servicio la persona encargada de la mascota debe ser mayor de edad.\n");
		
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
							System.out.println("Proporcione una respuesta válida.\n");
						}
					} catch (RuntimeException e) {
						System.out.println("Proporcione una respuesta válida.\n");
					} finally {
						leerCadena(); // consumir salto de línea
					}
				}
		
				// si el usuario es menor de edad, se piden los datos de un adulto responsable
				if (edad < 18) {
					System.out.println("El interesado en hacer uso del servicio es menor de edad.\n");
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
							System.out.println("Proporcione una respuesta válida.\n");
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
							System.out.println("Proporcione una respuesta válida.\n");
							cedula = 0;
						}
					} catch (InputMismatchException e) {
						System.out.println("Proporcione una respuesta válida.\n");
						leerCadena();
					}
				}
		
				Cliente cliente = new Cliente(nombre, edad, cedula);
				return cliente;
			}
		}
*/