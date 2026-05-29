package logica;

/**
 * Enumeracion que define los productos disponibles en la maquina expendedora.
 * Cada producto tiene un numero de opcion y un precio asociado.
 * 
 * @author Tarea DOO
 * @version 1.0
 */
public enum ValorProducto {

    /** Coca Cola, precio $300 */
    COCA(1,300),
    /** Sprite, precio $200 */
    SPRITE(2,200),
    /** Fanta, precio $200 */
    FANTA(3,200),
    /** Super8, precio $500 */
    SUPER8(4,500),
    /** Snickers, precio $1000 */
    SNICKERS(5,1000);

    private int opcion;
    private int precio;

    /**
     * Constructor que inicializa una constante de enum con su opcion y precio.
     * 
     * @param opcion el numero de opcion del producto
     * @param precio el precio del producto
     */
    ValorProducto(int opcion, int precio){
        this.opcion = opcion;
        this.precio = precio;
    }
    
    /**
     * Obtiene el numero de opcion del producto.
     * 
     * @return el numero de opcion
     */
    public int getOpcion(){
        return opcion;
    }
    
    /**
     * Obtiene el precio del producto.
     * 
     * @return el precio del producto
     */
    public int getPrecio(){
        return precio;
    }

}
