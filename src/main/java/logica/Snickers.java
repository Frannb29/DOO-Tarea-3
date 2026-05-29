package logica;

/**
 * Clase que representa un producto de Snickers disponible en la maquina expendedora.
 * Extiende la clase Dulce e implementa el metodo consumir().
 * 
 * @author Tarea DOO
 * @version 1.0
 */
public class Snickers extends Dulce{
    /**
     * Constructor que inicializa un Snickers con su numero de serie.
     * 
     * @param serie el numero de serie del producto
     */
    public Snickers(int serie){
        super(serie);
    }
    
    /**
     * Devuelve el nombre del producto cuando se consume.
     * 
     * @return "Snickers"
     */
    @Override
    public String consumir(){
        return "Snickers";
    }
}
