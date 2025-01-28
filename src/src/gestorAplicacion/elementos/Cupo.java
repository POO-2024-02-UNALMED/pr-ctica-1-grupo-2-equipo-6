package gestorAplicacion.elementos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

    // LÓPEZ GONZÁLEZ, ALEJANDRO
    // BETANCUR URIBE, EMMANUEL
    // MARTÍNEZ RÍOS, SANTIAGO
    // BULA FUENTES, MELANIE
    // OSPINA GAVIRIA, TOMAS

    //DESCRIPCIÓN FUNCIONALIDAD:
    //Representa un bloque de tiempo disponible para citas por cada empleado.. Incluye información sobre el día, la hora de inicio y fin, y si está disponible.

public class Cupo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private LocalDate dia;
    private String horaInicio;
    private String horaFin;
    private boolean disponible;
    

    public Cupo(LocalDate dia, String horaInicio, String horaFin, boolean disponible) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponible = disponible;
    }

    // MÉTODOS GETTERS & ToString
    
    public LocalDate getDia() {
    	
    	return dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public boolean isDisponible() {
        return disponible;
    }
    
    public void setDisponible(boolean booleano) {
    	
    	this.disponible=booleano;
    }

    static public void actualizarCupo(ArrayList <Cupo> Array_dia){
        LocalDate fecha_Actual = LocalDate.now(); 
    		
    		//Se comprueba que la fecha sea anterior a la actual.
    		if (Array_dia.get(0).getDia().isBefore(fecha_Actual)) {
    			
    			
    			//Si el dia coincide con el actual, se habilian los cupos para hoy.
    			if (fecha_Actual.getDayOfWeek().getValue() == Array_dia.get(0).getDia().getDayOfWeek().getValue()) {
    				
					Array_dia.clear(); 
				
		    		Array_dia.add(new Cupo(fecha_Actual, "8:00","10:00", true));
		    		Array_dia.add(new Cupo(fecha_Actual, "10:00","12:00", true));
		    		Array_dia.add(new Cupo(fecha_Actual, "14:00","16:00", true));
		    		Array_dia.add(new Cupo(fecha_Actual, "16:00","18:00", true));	
		    		
    			}
    			
    			else {
    				
    				 fecha_Actual = LocalDate.now();
    							 
    				 int num_dia=Array_dia.get(0).getDia().getDayOfWeek().getValue();
    				
    				 boolean continuar = true;	
    			
    			    while(continuar) {
    			    	
    			    	//Si el dia no coincide, buscamos entre los proximos.
    			    		
    				      fecha_Actual = fecha_Actual.plusDays(1); //Pasamos al dia siguiente.
    				       				
     				     if (fecha_Actual.getDayOfWeek().getValue() == num_dia)  {	    				    	
    				    	
    				       Array_dia.clear();
    					
    					   //Llenamos el dia por delante
    		    		   Array_dia.add(new Cupo(fecha_Actual, "8:00","10:00", true));
    		    		   Array_dia.add(new Cupo(fecha_Actual, "10:00","12:00", true));
    		    		   Array_dia.add(new Cupo(fecha_Actual, "14:00","16:00", true));
    		    		   Array_dia.add(new Cupo(fecha_Actual, "16:00","18:00", true));
    		    		
    		    		   continuar = false;
    			        }
     				}
    			}
    		}
    	}

    @Override
    public String toString() {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "De "+ horaInicio + " a "  + horaFin;
    }
    
    public String fechaFormateada() {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    	
    	return getDia().format(formatter);
    }
    
}