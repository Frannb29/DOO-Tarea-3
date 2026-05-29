package logica;

/**
 * Clase abstracta que representa una moneda con la capacidad de ser comparada.
 * Implementa la interfaz Comparable para permitir comparaciones entre monedas.
 * 
 * @author Tarea DOO
 * @version 1.0
 */
abstract class Moneda implements Comparable<Moneda>{
    /**
     * Constructor por defecto para una moneda.
     */
    public Moneda(){
    }
    
    /**
     * Obtiene la serie de la moneda.
     * 
     * @return la moneda actual
     */
    public Moneda getSerie(){
        return this;
    }
    
    /**
     * Obtiene el valor numerico de la moneda.
     * 
     * @return el valor de la moneda
     */
    public abstract int getValor();

    
}