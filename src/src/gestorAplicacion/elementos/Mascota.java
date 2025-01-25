package gestorAplicacion.elementos;
    
// LÓPEZ GONZÁLEZ, ALEJANDRO
// BETANCUR URIBE, EMMANUEL
// MARTÍNEZ RÍOS, SANTIAGO
// BULA FUENTES, MELANIE
// OSPINA GAVIRIA, TOMAS

//DESCRIPCIÓN DE LA CLASE:
//Representa a los animales disponibles para adopción, incluye atributos como nombre, tipo, edad, sexo y estado de salud, 
//de igual forma representa a las mascotas que un usuario registre para recibir un servicio o agendar una cita.

public class Mascota {

	// private static final long serialVersionUID = 1L;
	 public static enum EstadoSalud {
		SANO, ENFERMO, ENTRATAMIENTO
	 }
	
	private String nombre;
	private String tipo;
	private int edad;
	private String sexo;
	private EstadoSalud estadoSalud;
	private Empleado veterinario;

	//CONSTRUCTOR
	
	public Mascota(String nombre, String tipo, int edad, String sexo, EstadoSalud estadoSalud) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.edad = edad;
		this.sexo = sexo;
		this.estadoSalud = estadoSalud;
	}
	
	public Mascota(String nombre, String tipo, int edad, String sexo) {
		this(nombre, tipo, edad, sexo, null);
	}
	

	
	//MÉTODOS SETTER Y GETTER
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setEspecie(String tipo) {
		this.tipo = tipo;
	}
	
	public String getEspecie() {
		return tipo;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	
	public void setEstadoSalud(EstadoSalud estadoSalud) {
		this.estadoSalud = estadoSalud;
	}
	
	public EstadoSalud getEstadoSalud() {
		return estadoSalud;
	}
	
	public void setVeterinario(Empleado veterinario) {
		this.veterinario = veterinario;
	}
	
	public Empleado getVeterinario() {
		return veterinario;
	}
	
	
	//OTROS MÉTODOS
	
	public String toString() {
		if (estadoSalud!=null) {
		return "Nombre: " + getNombre() + ", Especie: " + getEspecie() + ", Edad (meses): " + getEdad() + ", Sexo: " + getSexo() + ", Estado de salud: " + getEstadoSalud();
		}
		else {
			return "Nombre: " + getNombre() + ", Especie: " + getEspecie() + ", Edad (meses): " + getEdad() + ", Sexo: " + getSexo();
			
		}
	}
	
	public boolean esCompatible(Mascota mascota) {
		if (this.tipo != mascota.tipo && this.estadoSalud != mascota.estadoSalud) {
			return false;
		}
		return true;
	}
	
	public double indiceEmergencia(int gravedad, int compatibilidad) {
		double vulnerabilidad = 10/(1+Math.abs(edad-4));
		double ie = (gravedad*0.7) + (vulnerabilidad*0.3) + (compatibilidad*0.1);
		
		return ie;
	}
	
}