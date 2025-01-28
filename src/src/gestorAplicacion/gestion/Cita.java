package gestorAplicacion.gestion;

import gestorAplicacion.elementos.Cliente;
import gestorAplicacion.elementos.Cupo;
import gestorAplicacion.elementos.Empleado;
import gestorAplicacion.elementos.Mascota;
import java.io.Serializable;

//DESCRIPCIÓN DE LA CLASE:
//Almacena información sobre las citas agendadas para servicios como veterinaria, entrenamiento o peluquería, incluyendo el Mascota, cliente, empleado y costo.

public class Cita implements Serializable{

	private static final long serialVersionUID = 1L;

    private Mascota Mascota;
    private Cupo cupo;
    private Empleado empleado;
    private Cliente cliente;
    private double costo;
    
    public Cita(Cliente cliente, Mascota Mascota,Empleado empleado, Cupo cupo, int servicio ) {
    	
    	this.cliente=cliente;
    	this.Mascota=Mascota;
    	this.empleado=empleado;
    	
    	cupo.setDisponible(false);//PARA MARCAR QUE EL CUPO YA NO ESTARÁ DISPONIBLE 	
    	this.cupo=cupo;
    	
    	if (servicio==1) {
    		this.costo= 80000;//Costo de una cita de Entrenamiento
    		this.cliente.agregarPuntos(10); //Por cita de entrenamiento gana 10 puntos
    	}
    	
        if (servicio==2) {
        	this.costo=50000; //COSTO DE UNA CITA DE VETERINARIA
        	this.cliente.agregarPuntos(8);//Por cita de veterinaria gana 8 puntos
    		}
        
        if (servicio==3) {
        	this.costo=25000; //COSTO DE UNA CITA DE PELUQUERÍA
        	this.cliente.agregarPuntos(5);//Por cita de peluqueria se gana 5 puntos.
        }
    		
    	
    	
    }
    public void aplicarDescuento() {
    	this.costo -= (this.costo *0.1);
    }
    

    public Mascota getMascota() {
        return Mascota;
    }
    
    
    public String toString() {
    	
    	String profesion="";
    	
    	if (this.empleado.getProfesion()== Empleado.Especialidad.VETERINARIO) {
    		profesion = "Veterinario";
    	}
      	if (this.empleado.getProfesion()== Empleado.Especialidad.ENTRENADOR) {
    		profesion = "Veterinario";
    	}
      	if (this.empleado.getProfesion()== Empleado.Especialidad.PELUQUERO) {
    		profesion = "Veterinario";
    	}
    		
    	return "Cliente: " + this.cliente.getNombre() +"\n"
    			+ "Mascota: " + this.Mascota.getNombre()+ "\n"
    			+ profesion +": " + this.empleado.getNombre() + "\n"
    			+ "Costo cita: " + this.costo + " pesos \n"
    			+ "Fecha de la cita: " + this.cupo.fechaFormateada() +"\n"
    			+ "Hora: " + this.cupo.getHoraInicio() + " - "+ this.cupo.getHoraFin(); 			
    }
    
}