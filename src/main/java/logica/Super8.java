package logica;

/**
 * Clase que representa un producto de Super8 disponible en la maquina expendedora.
 * Extiende la clase Dulce e implementa el metodo consumir().
 * 
 * @author Tarea DOO
 * @version 1.0
 */
public class Super8 extends Dulce{
    /**
     * Constructor que inicializa un Super8 con su numero de serie.
     * 
     * @param serie el numero de serie del producto
     */
    public Super8(int serie){
        super(serie);
    }
    
    /**
     * Devuelve el nombre del producto cuando se consume.
     * 
     * @return "Super8"
     */
    @Override
    public String consumir(){
        return "Super8";
    }
}
