package gestorAplicacion.elementos;

import java.io.Serializable;

// BULA FUENTES, MELANIE
// OSPINA GAVIRIA, TOMAS

//Descripción De La Clase:
//Representa los arti­culos en venta en la tienda, incluyendo nombre, precio, tipo de animal, tipo de Uso y cantidad disponible. 

public class Producto implements Serializable {
	//---> Atributos <---
    private static final long serialVersionUID = 1L;
    private String nombre; //Nombre del producto.
    private float precio; //Precio individual del producto.
    private String tipoAnimal; //Tipo de animal que puede usar el producto.
    private int cantidadUnidades; //Cantidad de unidades disponibles.
    private String tipoUso; //Uso al que va orientado el producto.

    //---> Constructores <---
    public Producto(String nombre, float precio, String tipoAnimal, String tipoUso, int cantidadUnidades){
        this(nombre, precio, tipoUso, cantidadUnidades);
        this.tipoAnimal = tipoAnimal;
    }
    
    public Producto(String nombre, float precio, String tipoUso, int cantidadUnidades){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadUnidades = cantidadUnidades;
    }

    //---> Metodos Getters And Setters <---
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }

    public void setPrecio(float precio){
        this.precio = precio;
    }
    public float getPrecio(){
        return this.precio;
    }

    public void setTipoAnimal(String tipo){
        this.tipoAnimal = tipo;
    }
    public String getTipoAnimal(){
        return this.tipoAnimal;
    }

    public void setTipoUso(String tipo){
        this.tipoUso = tipo;
    }
    public String getTipoUso(){
        return this.tipoUso;
    }

    public void setCantidadUnidades(int cantidad){
        this.cantidadUnidades = cantidad;
    }
    public int getCantidadUnidades(){
        return this.cantidadUnidades;
    }

    //---> Metodo ToString <---
    public String toString(){
        return "\nProducto: "+getNombre()+"\n"+"Precio: "+getPrecio()+"\n"+"Destinado a: "+getTipoAnimal()+"\n"+"Tipo del Producto: "+getTipoUso()+"\n"+ "Cantidad unidades: "+getCantidadUnidades()+"\n";        
    }
}
