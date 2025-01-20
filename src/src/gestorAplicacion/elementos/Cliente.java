package gestorAplicacion.elementos;

import gestorAplicacion.elementos.Mascota;

    //import java.io.Serializable;

	// LÓPEZ GONZÁLEZ, ALEJANDRO
	// BETANCUR URIBE, EMMANUEL
	// MARTÍNEZ RÍOS, SANTIAGO
	// BULA FUENTES, MELANIE
	// OSPINA GAVIRIA, TOMAS

//DESCRIPCIÓN DE LA CLASE:
//Representa a los usuarios que buscan adoptar animales y que pueden utilizar otros servicios del centro, como la tienda y citas.


public class Cliente extends Persona {

	//private static final long serialVersionUID = 1L;

	//ATRIBUTOS	

	private int puntos;
	private Mascota mascota;
	
	//CONSTRUCTOR
	
	public Cliente(String nombre,int edad, long cedula,long telefono, String direccion ) {
		
		super(nombre,edad,cedula,telefono,direccion);
	}
	
	public Cliente(String nombre, int edad, long cedula) {
		super(nombre, edad, cedula);
	}
	
	// - - - MÉTODOS - - -
		
	//MÉTODOS SETTER Y GETTER
	
	public void actualizar_datos(int edad, long telefono, String direccion) {
		this.setEdad(edad);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		
	}
	
	public void agregarPuntos(int puntos) {
		this.puntos+=puntos;
	}
	
	public void disminuirPuntos(int puntos) {
		this.puntos-=puntos;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	
	public void setMascota(Mascota mascota){
		this.mascota=mascota;
	}
	
	public Mascota getMascota() { 
		return mascota;
	}
	
	public String toString() {
		
		return "Nombre: " + getNombre() + ", Edad: "+ getEdad()+ ", Cedula: " + getCedula() +", Telefono: " 
				+ getTelefono() + ", Direccion "+ getDireccion() + "\n";	
	}
	
}

