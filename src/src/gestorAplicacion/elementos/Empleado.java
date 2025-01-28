package gestorAplicacion.elementos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

// BULA FUENTES, MELANIE
// OSPINA GAVIRIA, TOMAS

//DESCRIPCIÓN DE LA CLASE
//Representa al personal del centro, que puede ser veterinario, peluquero, cuidador o Vendedor, y gestiona la atención a los clientes y mascotas.

public class Empleado extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
    public static enum Especialidad {
        VETERINARIO,PELUQUERO,ENTRENADOR,VENDEDOR;
    }
	
	//---> Atributos <---
    private Mascota mascota;
    private Especialidad profesion; 
    ArrayList<ArrayList<Cupo>> agenda_dias = new ArrayList<>();
    

    //---> Constructor <---
    public Empleado( String nombre,int edad, long cedula,long telefono, String direccion,Especialidad profesion) {
    	super (nombre,edad,cedula,telefono,direccion);
        this.profesion = profesion;
        
        if (profesion!= Especialidad.VENDEDOR) { //El vendedor no tiene citas.
        	this.llenar_agenda();
        }  
    }
    

    // ---> Metodos <---
	private void llenar_agenda() {
    	
    	//Son la caltidad de ciclos.
    	int [] ciclos = {6,5,4,3,2,1};
    	
    	LocalDate fechaActual = LocalDate.now();
    	
    	int dia_semana = fechaActual.getDayOfWeek().getValue();//Numero del dia de la semana.
    	
    	
        //Si es domingo, se habilitan los cupos de lunes a sabado.
    	if (dia_semana==7) {
    		
    		fechaActual = fechaActual.plusDays(1);
    		
    		int j=0; 		
    		while(j < 6) {
    			
    			ArrayList<Cupo> cupos_dia= new ArrayList<>();
    			
	    		cupos_dia.add(new Cupo(fechaActual, "8:00","10:00", true));
	    		cupos_dia.add(new Cupo(fechaActual, "10:00","12:00", true));
	    		cupos_dia.add(new Cupo(fechaActual, "14:00","16:00", true));
	    		cupos_dia.add(new Cupo(fechaActual, "16:00","18:00", true));
	    		
	    		j++;
	    		
	    		this.agenda_dias.add(cupos_dia);
	    		fechaActual = fechaActual.plusDays(1);
    		}	
    	}
    	else {
    		
    	//Cuando es un dia diferente a domingo, se habilitan los cupos restantes de la semana.
    	int i=0;
    	while ( i < ciclos[dia_semana-1]) {
    		
    		ArrayList<Cupo> cupos_dia= new ArrayList<>();
	
    		cupos_dia.add(new Cupo(fechaActual, "8:00","10:00", true));
    		cupos_dia.add(new Cupo(fechaActual, "10:00","12:00", true));
    		cupos_dia.add(new Cupo(fechaActual, "14:00","16:00", true));
    		cupos_dia.add(new Cupo(fechaActual, "16:00","18:00", true));
    		
    		i++;
    		
    		this.agenda_dias.add(cupos_dia);
    		
    		fechaActual = fechaActual.plusDays(1);
    
    	}
    	
    	
    	//Se llenan los dias que faltaron de las proximas semanas.
    	
    	if (dia_semana != 1 && dia_semana!=7) { //Se excluye el domingo.
    		
    		fechaActual = fechaActual.plusDays(1); 
    		
    		int j=0;  		
    		while(j < (dia_semana-1)){
    			
	    		ArrayList<Cupo> cupos_dia= new ArrayList<>();
    			
	    		cupos_dia.add(new Cupo(fechaActual, "8:00","10:00", true));
	    		cupos_dia.add(new Cupo(fechaActual, "10:00","12:00", true));
	    		cupos_dia.add(new Cupo(fechaActual, "14:00","16:00", true));
	    		cupos_dia.add(new Cupo(fechaActual, "16:00","18:00", true));
	    		
	    		j++;
	    		
	    		this.agenda_dias.add(cupos_dia);	
	    		fechaActual = fechaActual.plusDays(1);			
	    		
    		}
    	}
    }
}
    
    
    public void actualizar_Datos() {
		
    	for(ArrayList <Cupo> Array_dia : this.agenda_dias) {
    		Cupo.actualizarCupo(Array_dia);
		}
    }
    
    
    //Se comprueba si tiene cupos dispponibles.
    public boolean tieneCupos() {

    	Boolean booleano = false;
    	this.actualizar_Datos();
    	
    	for(ArrayList <Cupo> cupos_por_dia: this.agenda_dias) {
    		
    		for(Cupo cupo: cupos_por_dia) {
    			
    			if (cupo.isDisponible()==true) {
    				booleano=true;
    				break;
    			}
    		}
    	}
    	return booleano;
    }
    
    public ArrayList<Cupo> cupos_disponibles(int i){
    	
    	ArrayList<Cupo> cupos_disponibles= new ArrayList<>();
    	
    	for(ArrayList <Cupo> Array_dia : this.agenda_dias) {
    		
    		if (Array_dia.get(0).getDia().getDayOfWeek().getValue()==i) {
    			
    			for(Cupo cupo: Array_dia) {
    				
    				if(cupo.isDisponible()) {
    				cupos_disponibles.add(cupo);
    				}
    			}	
    			break;
    		}
    	}
    	
    	return cupos_disponibles;
    }
    

    //---> Metodos Getters And Setters <---
        public Especialidad getProfesion(){
            return profesion;
        }
        
        public ArrayList<ArrayList<Cupo>> getCupo(){
    		return agenda_dias;
    	}
        
        public void setMascota(Mascota mascota) {
        	this.mascota = mascota;
        }
        
        public Mascota getMascota() {
        	return mascota;
        }

        
    //---> Metodo ToString <---    
    public String toString() {
    	return "Nombre: "+ getNombre() + ", Edad: " + getEdad() + " años.";
    }
}
