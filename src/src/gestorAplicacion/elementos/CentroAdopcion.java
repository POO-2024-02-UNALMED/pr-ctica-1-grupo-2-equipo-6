package gestorAplicacion.elementos;

import java.util.List;

import gestorAplicacion.elementos.Mascota.EstadoSalud;

import java.util.ArrayList;

public class CentroAdopcion {
	
	public static enum Sedes {
		MEDELLIN, BOGOTA, CALI, CARTAGENA
	}

	private String nombre;
	private List<Mascota> animalesHospitalizados;
	private List<Empleado> veterinarios;
	private static List<Cliente> clientes;
	private String sede;
	
	public CentroAdopcion(String nombre) {
		this.nombre = nombre;
		this.animalesHospitalizados = new ArrayList<>();
		this.veterinarios = new ArrayList<>();
		this.clientes = new ArrayList<>();
	}
	
	//GETTERS Y SETTERS
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setAnimalesHospitalizados(List<Mascota> animalesHospitalizados) {
		this.animalesHospitalizados = animalesHospitalizados;
	}
	
	public List<Mascota> getAnimalesHospitalizados(){
		return animalesHospitalizados;
	}
	
	public void setVeterinarios(List<Empleado> veterinarios) {
		this.veterinarios = veterinarios;
	}
	
	public List<Empleado> getVeterinarios(){
		return veterinarios;
	}
	
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public List<Cliente> getClientes(){
		return clientes;
	}
	
	public void setSede(String sede) {
		this.sede = sede;
	}
	
	public String getSede() {
		return sede;
	}
	
	
	//Otros métodos
	
	public void agregarVeterinario(Empleado veterinario) {
		veterinarios.add(veterinario);
	}
	
	public void registrarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void mostrarSedes() {
		System.out.println("Sedes:\n");
		for (int i = 0 ; i < Sedes.values().length ; i++) {
			String nombreSede  = Sedes.values()[i].toString(); 
			nombreSede = nombreSede.substring(0,1).toUpperCase() + nombreSede.substring(1).toLowerCase();
			System.out.println(i+1 + ". " + nombreSede);
		}
	}
	
	public boolean verificarHospitalizacion(Mascota mascota) {
		if (!hayCapacidad()) {
			return false;
		}
		
		for (Mascota hospitalizado : animalesHospitalizados) {
			if (!mascota.esCompatible(hospitalizado)) {
				return false;
			}
		}
		return true;
	}
	
	public List<Empleado> gestionarVeterinario() {
		List <Empleado> disponibles = new ArrayList<>();
        for (Empleado veterinario : veterinarios) {
            if (veterinario.tieneCupos()) {
                disponibles.add(veterinario);
            	return disponibles;
            }
        }
        return null;
    }
	
	public void agregarHospitalizado(Mascota mascota) {
		animalesHospitalizados.add(mascota);
	}
	
	public String[] mostrarOpcionesPago() {
        /*System.out.println("Opciones de pago disponibles: ");
        System.out.println("1. Tarjeta de crédito/débito");
        System.out.println("2. Efectivo");
        System.out.println("3. Puntos acumulados.");*/
		String[] opciones = {"Tarjeta de crédito", "Efectivo", "Puntos acumulados"};
		return opciones;
    }
	
	public boolean procesarPago(int metodo, Cliente cliente, int monto) {
        switch (metodo) {
            case 1:
                System.out.println("Pago procesado con tarjeta por un monto de: $" + monto);
                return true;
            case 2:
                System.out.println("Pago procesado en efectivo por un monto de: $" + monto);
                return true;
            case 3:
                if (cliente != null && monto <= cliente.getPuntos()) {
                	cliente.disminuirPuntos(monto);
                    System.out.println("Pago procesado con puntos acumulados.");
                    return true;
                } else {
                    System.out.println("No tiene suficientes puntos.");
                    return false;
                }
            default:
                System.out.println("Método de pago no válido.");
                return false;
        }
    }
	
	public void generarFactura(Cliente cliente, Mascota mascota, int monto) {
        System.out.println("\n--- Factura ---");
        System.out.println("Cliente: " + (cliente != null ? cliente : "No registrado"));
        System.out.println("Animal: " + mascota);
        System.out.println("Monto total: $" + monto);
        System.out.println("-----------------\n");
    }
	
	public void asignarVeterinario(Mascota mascota, Empleado veterinario) {
		mascota.setVeterinario(veterinario);
		veterinario.setMascota(mascota);
	}
	
	public void registrarAlta(Mascota mascota) {
		mascota.setEstadoSalud(EstadoSalud.SANO);
		animalesHospitalizados.remove(mascota);
		mascota.getVeterinario().setMascota(null);
		mascota.setVeterinario(null);
	}
	
	public boolean hayCapacidad() {
		if (animalesHospitalizados.size() >= 10) {
			return false;
		}
		return true;
	}
	
//Metodo para verificar si es un cliente nuevo o ya esta registrado.
	public static Cliente EsCliente(Cliente cliente){
		
		Cliente clienteNuevo = null; 
		
		for (Cliente  existe : clientes) {
			if (existe!=null) {
				if (existe.getCedula()== cliente.getCedula()) { //Se comprueba si ya existe.
					clienteNuevo = existe;
					break;
					}
				}
			}
		
		if (cliente == null) {	
			
			//Si no existe se agrega como nuevo cliente.
			cliente = clienteNuevo;
			clientes.add(clienteNuevo);
		}
		else {
			//Si existe, entonces se actualizan los datos.
			clienteNuevo.actualizar_datos(cliente.getEdad(),cliente.getTelefono(), cliente.getDireccion());	
		}
		
		return clienteNuevo;
	}
	
}
