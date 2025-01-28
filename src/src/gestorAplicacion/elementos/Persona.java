package gestorAplicacion.elementos;

import java.io.Serializable;

// BULA FUENTES, MELANIE
// OSPINA GAVIRIA, TOMAS

//Descripción De La Clase:
//Representa a las personas vinculadas con el centro de cuidado animal, ya sean clientes o empleados.En esta se almacena información basica de la persona.

public abstract class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
    //---> Atributos <---
	protected String nombre;
	protected int edad;
	protected long cedula;
	protected long telefono;
	protected String direccion;

	
	//---> Constructores <---
	public Persona(String nombre,int edad, long cedula,long telefono, String direccion) {
		this(nombre, edad, cedula);
		this.telefono= telefono;
		this.direccion= direccion;
	}
	
	public Persona(String nombre,int edad, long cedula) {
		this.nombre= nombre;
		this.edad= edad;
		this.cedula= cedula;
	}

	//---> Metodos Getters And Setters <---
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setEdad(int edad) {
		this.edad= edad;
	}
	public int getEdad() {
		return edad;
	}
	
	public void setCedula(long cedula) {
		this.cedula= cedula;
	}
	public long getCedula() {
		return cedula;
	}
	
	public void setDireccion(String direccion) {
		this.direccion= direccion;
	}
	public String getDireccion() {
		return direccion;
	}
	
	public void setTelefono(long telefono) {
		this.telefono= telefono;
	}
	
	public long getTelefono() {
		return telefono;
	}
	
	//---> Metodo ToString <---
	public String toString() {
		return "Nombre: " + getNombre() + "\nEdad: "+ getEdad()+ "\nCedula: " + getCedula() +"\nTelefono: " + getTelefono() + "\nDirección "+ getDireccion() + "\n";
	}	
}