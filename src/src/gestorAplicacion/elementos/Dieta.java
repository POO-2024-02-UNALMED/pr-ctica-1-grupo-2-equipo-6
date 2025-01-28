package gestorAplicacion.elementos;

import java.io.PrintWriter;
import java.io.Serializable;


public class Dieta implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Mascota mascota;
    private double pesoIdeal;
    private double gramosDiarios;
    private double proteinas;
    private double grasas;
    private double carbohidratos;

    //Constructor
    public Dieta(Mascota mascota) {
        this.mascota = mascota;
    }

    //metodos Get

    public Mascota getMascota() {
        return this.mascota;
    }

    public double getPesoIdeal() {
        return this.pesoIdeal;
    }

    public double getGramosDiarios() {
        return this.gramosDiarios;
    }

    public double getProteinas() {
        return this.proteinas;
    }

    public double getGrasas() {
        return this.grasas;
    }

    public double getCarbohidratos() {
        return this.carbohidratos;
    }

    //Metodos de la clase

    public void calcularPesoIdeal(){
         int tamano = mascota.getTamano();
        int edad = mascota.getEdad();
        double pesoActual = mascota.getPeso();
        this.pesoIdeal = ((tamano * 10.0) / (edad + 1)) + (pesoActual / 2);
    }

    public int comparacionPeso() {
        if (mascota.getPeso() == this.pesoIdeal) {
            return 1; // Esta en su peso ideal
        } else if (mascota.getPeso() < this.pesoIdeal) {
            return 2; // Necesita subir de peso
        } else {
            return 3; // Necesita bajar de peso
        }
    }

    public void planDieta() {
        this.gramosDiarios = this.pesoIdeal * mascota.getTamano() * 10;
        switch (comparacionPeso()) {
            case 1: //Esta en su peso ideal
                this.grasas = this.gramosDiarios * 0.20;
                this.proteinas = this.gramosDiarios * 0.30;
                this.carbohidratos = this.gramosDiarios * 0.50;
                break;
            case 2: //Subir de peso
                this.grasas = this.gramosDiarios * 0.30;
                this.proteinas = this.gramosDiarios * 0.40;
                this.carbohidratos = this.gramosDiarios * 0.30;
                break;
            case 3: //Bajar de peso
                this.grasas = this.gramosDiarios * 0.15;
                this.proteinas = this.gramosDiarios * 0.50;
                this.carbohidratos = this.gramosDiarios * 0.35;
                break;
        }
    }
    
   @Override
public String toString() {
    // Determinar el estado de peso
    String estadoPeso;
    switch (comparacionPeso()) {
        case 1:
            estadoPeso = "Está en su peso ideal.";
            break;
        case 2:
            estadoPeso = "Debe subir de peso.";
            break;
        case 3:
            estadoPeso = "Debe bajar de peso.";
            break;
        default:
            estadoPeso = "Estado no definido.";
    }

    return "Nombre de la mascota: " + mascota.getNombre() + "\n" +
           "Peso Actual: " + mascota.getPeso() + " kg\n" +
           "Edad: " + mascota.getEdad() + " años\n" +
           "Tamaño: " + mascota.getTamanoString() + "\n" +
           "Peso ideal: " + Math.round(this.pesoIdeal * 100) / 100d + " kg\n" +
           "Cantidad de Gramos de alimento diarios: " + Math.round(this.gramosDiarios * 100) / 100d + " g\n" +
           estadoPeso + "\n\n" +
           "Distribución en porcentajes de nutrientes:\n" +
           " Proteínas: " + ((this.proteinas / this.gramosDiarios) * 100) + "%\n" +
           " Grasas: " + ((this.grasas / this.gramosDiarios) * 100) + "%\n" +
           " Carbohidratos: " + ((this.carbohidratos / this.gramosDiarios) * 100) + "%\n\n" +
           "Distribución en gramos de nutrientes:\n" +
           " Proteínas: " + Math.round(this.proteinas * 100) / 100d + " g\n" +
           " Grasas: " + Math.round(this.grasas * 100) / 100d + " g\n" +
           " Carbohidratos: " + Math.round(this.carbohidratos * 100) / 100d + " g";
}


    public void menu() {
    try (PrintWriter writer = new PrintWriter("./src/src/basedatos/dieta_" + mascota.getNombre() + ".txt")) {
        // Datos de la mascota
        writer.println(this.toString());

        System.out.println("Archivo de texto creado con éxito.\nAbrelo en la carpeta basedatos.");
    } catch (Exception e) {
        System.out.println("Error al crear el archivo de menú: " + e.getMessage());
    }
}


}