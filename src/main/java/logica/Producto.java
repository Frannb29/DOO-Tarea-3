package logica;

/**
 * Clase abstracta que representa un producto generico en la maquina expendedora.
 * Define el comportamiento base que todos los productos deben cumplir.
 * 
 * @author Tarea DOO
 * @version 1.0
 */
abstract class Producto {
    private static int nroSerie=100;
    private int serie;
    /**
     * Constructor que inicializa un producto con un numero de serie.
     * 
     * @param serie el numero de serie del producto
     */
    public Producto(){
        this.serie=nroSerie;
        nroSerie++;
    }

    /**
     * Obtiene el numero de serie del producto.
     * 
     * @return el numero de serie
     */
    public int getSerie() {
        return serie;
    }
    
    /**
     * Metodo abstracto que debe ser implementado por las subclases.
     * Define el comportamiento de consumir el producto.
     * 
     * @return una cadena que describe el producto consumido
     */
    public abstract String consumir();
}
