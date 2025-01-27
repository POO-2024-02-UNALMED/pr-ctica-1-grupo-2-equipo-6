package uiMain;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import gestorAplicacion.elementos.Empleado;
import gestorAplicacion.elementos.Empleado.Especialidad;
import gestorAplicacion.elementos.Mascota;
import gestorAplicacion.elementos.CentroAdopcion.Sedes;
import gestorAplicacion.elementos.CentroAdopcion;
import gestorAplicacion.elementos.Cliente;
import gestorAplicacion.elementos.Cupo;
import gestorAplicacion.elementos.Mascota.EstadoSalud;
import gestorAplicacion.gestion.Cita;
import gestorAplicacion.gestion.Tienda;


		

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
            System.out.println("3. Tienda UNamascota");
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
            		System.out.println("\nBienvenido a Emergencias del Centro Veterinaria UNamascota.");
            		emergenciaVeterinaria(cliente);
            		break;
            	case 2:
            		System.out.println("Bienvenido a la funcionalidad 2.");
					//agendarServicio();
            		break;
            	case 3:
            		System.out.println("Bienvenido a la Tienda del Centro Veterinario UNamascota.");
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


public static void tienda() {
		

		
	//CREAMOS UN EMPLEADO PARA QUE ATIENDA LA TIENDA
	Empleado empliado = new Empleado("Albert", 22, 555, 1323, "West Elm", Empleado.Especialidad.VENDEDOR);
	
	// CREACIÓN DE TIENDA
	//t1 = new Tienda(empliado, sede1);
	Tienda t1 = new Tienda(empliado,sede1);
	
	// BUCLE QUE MANTIENE LA OPERACION DE LA TIENDA, DE ROMPERSE, SE TERMINA LA FUNCIONALIDAD
	
	boolean bucle = true; // VARIABLE PARA EL SEGUNDO MENÚ
	
	println("\n🐾🐕¡Bienvenido a la tienda de mascotas del Centro de cuidado Animal: UNamascota!🐾🐈"+"\n Aquí encontrarás los mejores productos para el cuidado y la diversión de tu compañero peludo."+"\n");
	
	while (true) { 
	
		println("¿Qué te trae por estos lares?");
		println("1. Ir de compras");
		println("2. Salir\n");
		println("Ingrese el número de la opción que desea [1-2]: ");
		
		int menu = 0; // ENTERO QUE EL USUARIO VA A INGREASAR, PARA ESCOGER OPCION 
		while (menu==0) { //MIENTRAS EL ENTERO SEA CERO (PARA CONTROLAR QUE EL USUARIO LE DÉ UN VALOR)
			try {//CONTROL DE ERRORES 
				menu = readInt(); //SE LEE EL ENTERO 
				if (menu>0 && menu<=2) { //SI ESTÁ ENTRE 1 Y 2 TERMINA 
					break;
				}
				else {
					println("🚫¡Oh no!, Ingrese un número válido por favor🚫");
					menu = 0;
					continue;
				}
			}
			catch(InputMismatchException e) {
				println("🚫Por favor ingrese un índice disponible (Pista: Entre 1 y 2)🚫");
			}
			finally {
					entrada.nextLine();//SALTO DE LINEA
				}
		}
		
	if (menu==1) {	// OPCION 1 DEL PRIMER MENÚ, ADQUIRIR PRODCUTO.		
		while (bucle==true) { //UTILIZAMOS LA VARIABLE BUCLE INICIADA ANTES DEL PRIMER WHILE
			
			println("\n--------------------------------------------------------");
			println("\n🐾🐕¿Cómo desea que se le muestren los productos?🐾🐈");
			println("1. Mostrar todo");
			println("2. Filtrar por tipo\n");
			print("Ingrese el número de la opción que desea [1-2]: \n");
			println("\n--------------------------------------------------------");
				
			int menuTienda = 0; // VOLVEMOS A RECIBIR UNA ENTRADA, ESTA VEZ PARA DECIDIR COMO FILTRAR LOS PRODUCTOS
			while (menuTienda==0) {
				try {
					menuTienda = readInt();
					if (menuTienda>0 && menuTienda<=2) { // SE CONTROLA QUE ESTÉ DENTRO DEL RANGO 
						break;
					}
					else {
						println("🚫Por favor ingrese un índice disponible (Pista: Entre 1 y 2)🚫");
						menuTienda = 0;
						continue;
					}
				}
				catch(InputMismatchException e) {
					println("🚫Por favor ingrese un índice disponible (Pista: Entre 1 y 2)🚫");
				}
				finally {
					entrada.nextLine();//SALTO DE LINEA
				}
			}
			
			if (menuTienda==1) { //EN CASO DE QUE SE QUIERA VISUALIZAR TODOO	
				println("\nProductos disponibles:");
				println(t1.inventario()); // SE LLAMA AL MÉTODO INVENTARIO DE TIENDA, PARA QUE DEVULVA TODOS LOS PRODUCTOS SIN MÁS
			}
			else { // DE LO CONTRARIO, SE LE VOLVERÁ A PEDIR UNA ENTRADA PARA QUE INDIQUE POR QUE TIPO DE ANIMAL QUIERE VER 
				print("\n🐈🐾¿Por qué tipo de animal te gustaría ver? [Perros, gatos, aves, hamsters o conejos]: 🐕🐾");
				while (true) { //BUCLE PARA CONTROLAR ÉSTE NUEVO MENÚ
					try {
						String tipo = readString(); // SE LEE EL STRING 
						tipo.toLowerCase(); // SE PONE EL TEXTO EN MINÚSCULAS
						
						//LUEGO LO COMPARAMOS EN ESTE GRUPO DE CONDICIONALES SIMPLES 
						
						if (tipo.equals("perros") || tipo.equals("perro")) { 
							println("\nProductos disponibles: 🐕\n");
							println(t1.filtrar("perros")); //DEPENDIENDO DEL TIPO QUE INGRESÓ EL USUARIO, SE FILTRA DE UNA FORMA U OTRA
							break;
						}
						else if (tipo.equals("gatos") || tipo.equals("gato")) {
							println("\nProductos disponibles: 🐈\n");
							println(t1.filtrar("gatos")); //DEPENDIENDO DEL TIPO QUE INGRESÓ EL USUARIO, SE FILTRA DE UNA FORMA U OTRA 
							break;
						}
						else if (tipo.equals("aves") || tipo.equals("ave")) {
							println("\nProductos disponibles: 🐦\n");
							println(t1.filtrar("aves"));//DEPENDIENDO DEL TIPO QUE INGRESÓ EL USUARIO, SE FILTRA DE UNA FORMA U OTRA
							break;
						}	
						else if (tipo.equals("hamsters") || tipo.equals("hamster")) {
							println("\nProductos disponibles: 🐹\n");
							println(t1.filtrar("hamsters"));//DEPENDIENDO DEL TIPO QUE INGRESÓ EL USUARIO, SE FILTRA DE UNA FORMA U OTRA
							break;
						}
						else if (tipo.equals("conejos") || tipo.equals("conejo")) {
							println("\nProductos disponibles: 🐇\n");
							println(t1.filtrar("conejos"));//DEPENDIENDO DEL TIPO QUE INGRESÓ EL USUARIO, SE FILTRA DE UNA FORMA U OTRA
							break;
						}
						else {
							println("🚫Por favor, ingrese el tipo del animal en minúsculas [Perros, gatos, aves o hamsters]🚫");
							continue;
						}
					}
					catch(InputMismatchException e) {
						println("🚫Por favor, coloque un tipo valido de animal🚫");
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
						int unidades = readInt(); //CANTIDAD DE UNIDADES QUE EL USUARIO VA A COMPRAR
						
						//  REGISTRO DEL USUARIO PARA REALIZAR LA COMPRA-------------------------------------
						
						if (unidades==1) { //SI SOLO VA A COMPRAR UNA UNIDAD
							println("\nSus datos serán tomados para registrar la compra.");
							print("Ingrese su cédula: ");
							long cedula = entrada.nextLong();
							print("Ingrese su edad: ");
							int edad = entrada.nextInt();
							print("Ingrese su nombre: ");
							entrada.nextLine();
							String nombre = readString();
							
							//SE REGISTA EL USUARIO, CREANDO UN OBJETO DEL TIPO CLIENTE Y PASANDOLO AL MÉTODO COMPRA DE TIENDA 
							Cliente cliente = new Cliente(nombre, edad, cedula);
							println("\n"+t1.compra(indice, cliente)); 
							//ESTE FILTRO DE: UNIDADES == 1, ES PORQUE EL MÉTODO COMPRA QUE RECIBE DOS PARÁMETROS RETORNA ALGO MÁS ADECUADO PARA ESTE CASO 
						}
						else { // CUANDO EL USUARIO VA A COMPRAR MÁS DE UNA UNIDAD 
							println("\nSus datos serán tomados para registrar la compra.");
							print("Ingrese su cédula: ");
							long cedula = entrada.nextLong();
							print("Ingrese su edad: ");
							int edad = entrada.nextInt();
							print("Ingrese su nombre: ");
							entrada.nextLine();
							String nombre = readString();
							
							//SE REGISTA EL USUARIO, CREANDO UN OBJETO DEL TIPO CLIENTE Y PASANDOLO AL MÉTODO COMPRA DE TIENDA
							// SE LE AGREGA TAMBIEN, LA CANTIDAD DE UNIDADES AL MÉTODO COMPRA 
							Cliente cliente = new Cliente(nombre, edad, cedula);
							println("\n"+t1.compra(indice, unidades, cliente));
						}
						
						// --------------------------------------------------------------------------------
						
						control = false; //SI SE COMPLETÓ EL BLOQUE TRY, SE CAMBIA EL ESTADO A FALSO PARA ROMPER EL CICLO 
					
				}
				catch(InputMismatchException e) {
					println("Por favor lea e ingrese correctamente los datos\n");
				}
				
			}
			
			// SE LE PIDE SI DESEA VOLVER A REINICIAR EL CICLO DESDE EL MENÚ DE COMPRA 
			print("\n¿Desea volver al catálogo? [si/no]: ");
			String respuesta = " ";
			while (true) {//CONTROL CON UN WHILE SOLAMENTE, HASTA QUE NO RECIBA UNA RESPUESTA VÁLIDA.
				respuesta = entrada.nextLine();
				respuesta.toLowerCase();
				if (respuesta.equals("si")||respuesta.equals("no")) {
					break; 
				}else {
					println("Por favor, ingrese una respuesta válida [si/no]");
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