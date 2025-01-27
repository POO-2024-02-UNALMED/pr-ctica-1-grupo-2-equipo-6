package gestorAplicacion.gestion;
import java.io.Serializable;
import java.util.ArrayList;
import gestorAplicacion.elementos.CentroAdopcion;
import gestorAplicacion.elementos.Fallecido;

public class Memorial implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private CentroAdopcion centro;
	public static ArrayList<Fallecido> sepulcros = new ArrayList<> ();
	public static ArrayList<Fallecido> osarios = new ArrayList<> ();
	public static ArrayList<Fallecido> arboles = new ArrayList<> ();
	public static ArrayList<Fallecido> cenizas = new ArrayList<> ();
	
	public Memorial (CentroAdopcion centro) {
		this.centro = centro;
	}
	
	public CentroAdopcion getCentro() {
		return this.centro;
	}
	
	public String getNombre() {
		return centro.getNombre();
	}
	
	public void setCentro (CentroAdopcion centro) {
		this.centro = centro;
	}
	
	public ArrayList<Fallecido> getSepulcros() {
		return sepulcros;
	}
	public ArrayList<Fallecido> getOsarios() {
		return osarios;
	}
	
	public ArrayList<Fallecido> getArboles() {
		return arboles;
	}
	
	public ArrayList<Fallecido> getCenizas() {
		return cenizas;
	}
	
	public boolean cupoSepulcro() {
		return sepulcros.size() <= 20;
		}
		
	public boolean cupoOsario() {
		return osarios.size() <= 20;
		}
	
	public boolean cupoArboles() {
		return arboles.size() <= 30;
	}
	
	public boolean cupoSenizas() {
		return cenizas.size() <= 30;
	} 
	
	 /*public String visita(String tipo) {
	    String resultado = "";
	    ArrayList<Fallecido> lista = (tipo.equals("Sepulcro")) ? sepulcros : restos;

	    for (int i = 0; i < lista.size(); i++) {
	        int indice = i + 1;
	        resultado += indice + ", " + lista.get(i).toString() + '\n';
	    }

	    return resultado;
	} */
	
	public String visita(String tipo) {
		String resultado = "";
		if (tipo.equals("Sepulcro")) {
			resultado = visitaMemorial(sepulcros);
		}
		else if (tipo.equals("Restos")) {
			resultado = visitaMemorial(osarios);
		}
		else if (tipo.equals("Arbol")) {
			resultado = visitaMemorial(arboles);
		}
		else if (tipo.equals("Cenizas")) {
			resultado = visitaMemorial(cenizas);
		}
		return resultado;
	}
	
	private String visitaMemorial(ArrayList<Fallecido> lista) {
		String resultado = "";
		for (int i = 0; i < lista.size(); i++) {
			int indice = i + 1;
			resultado += indice + ", " + lista.get(i).toString() + '\n';
		}
		return resultado;
	}
	
	public void anadirSepulcro (Fallecido sepulcro) {
		sepulcro.setTipo("Sepulcro");
		sepulcros.add(sepulcro);
	}
	
	public void anadirOsario (Fallecido huesos) {
		huesos.setTipo("Osario");
		osarios.add(huesos);
	}
	
	public void anadirArbol (Fallecido arbol) {
		arbol.setTipo("Arbol");
		arboles.add(arbol);
	}
	
	public void anadirCenizas (Fallecido ceniza) {
		ceniza.setTipo("Cenizas");
		cenizas.add(ceniza);
	}
	
	public String florOsarios (int indice, String flor) {
		indice -= 1;
		return osarios.get(indice).ponerFlor(flor);
	}
	
	public String florSepulcro (int indice, String flor) {
		indice -= 1;
		return sepulcros.get(indice).ponerFlor(flor);
	}
	
	public String florArboles (int indice, String flor) {
		indice -= 1;
		return arboles.get(indice).ponerFlor(flor);
	}
	
	public String florCenizas (int indice, String flor) {
	indice -= 1;
	return cenizas.get(indice).ponerFlor(flor);
	}
	
	public ArrayList<Fallecido> obtenerFallecidosPorTipo(String tipo) {
		ArrayList<Fallecido> lista = new ArrayList<>();
		switch (tipo) {
		case "Sepulcro":
			lista.addAll(sepulcros);
			break;
		case "Osario":
			lista.addAll(osarios);
			break;
		case "Cenizas":
			lista.addAll(cenizas);
			break;
		case "Arbol":
			lista.addAll(arboles);
			break;
		}
		return lista;
	}
}