package logica;

/**
 * Clase abstracta que representa un dulce en la maquina expendedora.
 * Extiende la clase Producto e implementa el comportamiento base de los dulces.
 * 
 * @author Tarea DOO
 * @version 1.0
 */
public abstract class Dulce extends Producto{
    /**
     * Constructor que inicializa un dulce con un numero de serie.
     * Numero de serie unico otorgado por Producto
     */
    public Dulce(){
        super();
    }
    
    /**
     * Metodo abstracto para consumir el dulce.
     * 
     * @return una cadena que describe el dulce consumido
     */
    @Override
    public abstract String consumir();
}
