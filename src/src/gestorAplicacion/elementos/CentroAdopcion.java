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
	private List<Cliente> clientes;
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
		for (int i = 0 ; i < Sedes.values().length ; i++) {
			System.out.println(i+1 + "" + Sedes.values()[i]);
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
	
	public Empleado gestionarVeterinario() {
        for (Empleado veterinario : veterinarios) {
            if (veterinario.tieneCupos()) {
                return veterinario;
            }
        }
        return null;
    }
	
	public void agregarHospitalizado(Mascota mascota) {
		animalesHospitalizados.add(mascota);
	}
	
	public void mostrarOpcionesPago() {
        System.out.println("Opciones de pago disponibles: ");
        System.out.println("1. Tarjeta de crédito/débito");
        System.out.println("2. Efectivo");
        System.out.println("3. Puntos acumulados.");
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
	
}
