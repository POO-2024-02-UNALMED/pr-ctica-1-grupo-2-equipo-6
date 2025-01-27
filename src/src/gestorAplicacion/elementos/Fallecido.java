package gestorAplicacion.elementos;

import java.util.ArrayList;

// BULA FUENTES, MELANIE
// OSPINA GAVIRIA, TOMAS

//DESCRIPCIÓN DE LA CLASE:
//Representa a los animales que han fallecido,Incluyendo datos sobre el dueño, fecha de fallecimiento y mensajes de recuerdo.
	
public class Fallecido{

    //---> Atributos <---
	private Mascota mascota;
	private String fecha;
	private String mensaje;
	private Cliente dueño;
	private String tiempo; 
	private String tipo;  
    private ArrayList<String> flores = new ArrayList<> (); // Lista de flores existentes.
    
    //---> Constructor <---
    public Fallecido() {
		flores.add("Sin Flores."); //Inician sin flores
    }
    
	public Fallecido(Mascota mascota, String fecha, String mensaje, Cliente dueño, String tiempo, String tipo) {
		this.mascota = mascota;
		this.dueño = dueño;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.tiempo = tiempo;
		this.tipo = tipo;
		flores.add("Sin Flores."); //Inician sin flores
	}
	
	//---> Metodos Getters And Setters <---
	
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	public Mascota getMascota() {
		return this.mascota;
	}
	
	public ArrayList<String> getFlores() {
		return flores;
	}
	
	public void setFlores(ArrayList<String> flores) {
		this.flores = flores;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFecha() {
		return this.fecha;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return this.mensaje;
	}
	
	public void setDueño(Cliente cliente) {
		this.dueño = cliente;
	}
	public Cliente getDueño() {
		return this.dueño;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getTiempo() {
		return this.tiempo;
	}
	
	
	// ---> Metodos <---
	public String ponerFlor(String flor) {
		
		if (flores.get(0).equals("Sin Flores.")) { //Verifica si ya hay flores puestas.
			
			flores.clear(); // Cambia el "Sin Flores" por la flor que entra como parametro.
			flores.add(flor);
			return "Pronto tendra las flores: "+flor+"."; 
		}
		else if(flores.size()<=5) { // Si ya tiene una flor, se confirma que no execeda el maximo de 5.
			flores.add(flor); // Se añade una flor al arreglo de flores. 
			return "Pronto tendra las flores: "+flor+".";
		}
		else {// Si excede el maximo de 5
			return "Solo puede tener 5 tipos de flores.";
		}	
	}
	
	public String mostrarFlores() { 
		
		if (flores.get(0).equals("Sin Flores")) { //Se pregunta si el primer elemento es "Sin Flores."
			return flores.get(0); // Se retorna el primer elemento, es decir "Sin Flores."
		}
		else if(flores.size()==1) { //Se pregunta si solo hay una flor en la lista.
			return "Hay una flor: "+flores.get(0);//Se devuelve el primer parametro, es decir la flor existente.
		}
		else {  
			String acomulador = "Flores que hay: ";
		
			for(int i = 0; i<flores.size();i++) {	
				acomulador += flores.get(i)+" "; //Se acumulan las flores existentes 
			}
			return acomulador;//Se retornan las flores acumuladas.
		}
	}
	
	
	//---> Metodo ToString <---
	public String toString() {
		return mascota.getNombre()+"\n"+fecha+"\n"+mensaje+"\n"+this.mostrarFlores()+"\n";
	}
	
}