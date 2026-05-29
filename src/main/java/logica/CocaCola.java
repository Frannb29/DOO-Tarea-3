package logica;

/**
 * Clase que representa un producto de Coca Cola disponible en la maquina expendedora.
 * Extiende la clase Bebida e implementa el metodo consumir().
 * 
 * @author Tarea DOO
 * @version 1.0
 */
public class CocaCola extends Bebida {
    /**
     * Constructor que inicializa una Coca Cola con su numero de serie.
     * 
     * Numero de serie unico del producto
     */
    public CocaCola(){
        super();
    }
    
    /**
     * Devuelve el nombre del producto cuando se consume.
     * 
     * @return "Coca Cola"
     */
    @Override
    public String consumir(){
        return "Coca Cola";
    }
}