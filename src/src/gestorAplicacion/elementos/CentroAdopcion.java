package gestorAplicacion.elementos;

import java.util.List;
import java.util.ArrayList;

public class CentroAdopcion {
	
	public static enum Sedes {
		MEDELLIN, BOGOTA, CALI, CARTAGENA
	}

	private String nombre;
	private List<Mascota> animalesHospitalizados;
	private List<Empleado> veterinarios;
	private List<Cliente> clientes;
	private Sedes sede;
	
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
	
	public void setSede(Sedes sede) {
		this.sede = sede;
	}
	
	public Sedes getSede() {
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
		for (Sedes sede : Sedes.values()) {
			System.out.println(sede);
		}
	}
	
	public boolean verificarHospitalizacion(Mascota mascota) {
		if (animalesHospitalizados.size() >= 10) {
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
	
}
