package logica;

/**
 * Clase abstracta que representa una bebida en la maquina expendedora.
 * Extiende la clase Producto e implementa el comportamiento base de las bebidas.
 * 
 * @author Tarea DOO
 * @version 1.0
 */
public abstract class Bebida extends Producto{
    /**
     * Constructor que inicializa una bebida con un numero de serie.
     * 
     * @param serie el numero de serie del producto
     */
    public Bebida(int serie){
        super(serie);
    }
    
    /**
     * Metodo abstracto para consumir la bebida.
     * 
     * @return una cadena que describe la bebida consumida
     */
    @Override
    public abstract String consumir();
}