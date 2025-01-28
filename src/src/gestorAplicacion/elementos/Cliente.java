package gestorAplicacion.elementos;

import java.io.Serializable;
import java.util.ArrayList;
import uiMain.Main;

// LÓPEZ GONZÁLEZ, ALEJANDRO
	// BETANCUR URIBE, EMMANUEL
	// MARTÍNEZ RÍOS, SANTIAGO
	// BULA FUENTES, MELANIE
	// OSPINA GAVIRIA, TOMAS

//DESCRIPCIÓN DE LA CLASE:
//Representa a los usuarios que buscan adoptar animales y que pueden utilizar otros servicios del centro, como la tienda y citas.


public class Cliente extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int EDAD_MINIMA = 18;

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
		
	public void actualizar_Datos(int edad, long telefono, String direccion) {
		this.setEdad(edad);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		
	}
	//MÉTODOS SETTER Y GETTER
	public void agregarPuntos(int puntos) {
		this.puntos+=puntos;
	}
	
	public void disminuir_Puntos(int puntos) {
		this.puntos-=puntos;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	public static Cliente registro(){
		ArrayList<Object> datos = Main.capturarDatosCliente();
		Cliente cliente = new Cliente((String) datos.get(0), (int) datos.get(1), (long) datos.get(2));
		cliente.agregarPuntos(0);

		return cliente;

	}
	
	public void setMascota(Mascota mascota){
		this.mascota=mascota;
	}
	
	public Mascota getMascota() { 
		return mascota;
	}
	
	public String toString() {
		
		return "Nombre: " + getNombre() + ", Edad: "+ getEdad()+ ", Cedula: " + getCedula() +", Telefono: " 
				+ getTelefono() + ", Direccion "+ getDireccion();	
	}
	
}

