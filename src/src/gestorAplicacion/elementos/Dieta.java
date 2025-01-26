package gestorAplicacion.elementos;

import java.io.PrintWriter;
import java.io.Serializable;


public class Dieta implements Serializable {
    Mascota mascota;
    double pesoIdeal;
    double gramosDiarios;
    double proteinas;
    double grasas;
    double carbohidratos;

    //Constructor
    public Dieta(Mascota mascota) {
        this.mascota = mascota;
        calcularPesoIdeal();
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
    
    public void menu() {
    try (PrintWriter writer = new PrintWriter("menu_dieta.txt")) {
        // Datos de la mascota
        writer.println("Nombre de la mascota: " + mascota.getNombre());
        writer.println("Peso Actual: " + mascota.getPeso() + " kg");
        writer.println("Edad: " + mascota.getEdad() + " años");
        writer.println("Tamaño: " + mascota.getTamano());
        writer.println("Peso ideal: " + this.pesoIdeal + " kg");
        writer.println("Cantidad de Gramos de alimento diarios: " + this.gramosDiarios + " g");

        // Estado de peso
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
        writer.println(estadoPeso);

        // Distribución de nutrientes
        writer.println("\nDistribución en porcentajes de nutrientes:");
        writer.println(" Proteínas: " + ((this.proteinas / this.gramosDiarios) * 100) + "%");
        writer.println(" Grasas: " +  ((this.grasas / this.gramosDiarios) * 100) + "%");
        writer.println(" Carbohidratos: " + ((this.carbohidratos / this.gramosDiarios) * 100) + "%");

        writer.println("\nDistribución en gramos de nutrientes:");
        writer.println(" Proteínas: " + this.proteinas);
        writer.println(" Grasas: " + this.grasas);
        writer.println(" Carbohidratos: " + this.carbohidratos);

        System.out.println("menu_dieta.txt creado con éxito.");
    } catch (Exception e) {
        System.out.println("Error al crear el archivo de menú: " + e.getMessage());
    }
}


}