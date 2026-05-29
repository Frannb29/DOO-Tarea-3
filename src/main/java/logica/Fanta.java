package logica;

/**
 * Clase que representa un producto de Fanta disponible en la maquina expendedora.
 * Extiende la clase Bebida e implementa el metodo consumir().
 * 
 * @author Tarea DOO
 * @version 1.0
 */
public class Fanta extends Bebida{
    /**
     * Constructor que inicializa una Fanta con su numero de serie.
     * 
     * @param serie el numero de serie del producto
     */
    public Fanta(int serie){
        super(serie);
    }
    
    /**
     * Devuelve el nombre del producto cuando se consume.
     * 
     * @return "Fanta"
     */
    @Override
    public String consumir(){
        return "Fanta";
    }
}
