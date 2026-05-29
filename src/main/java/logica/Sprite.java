package logica;

/**
 * Clase que representa un producto de Sprite disponible en la maquina expendedora.
 * Extiende la clase Bebida e implementa el metodo consumir().
 * 
 * @author Tarea DOO
 * @version 1.0
 */
class Sprite extends Bebida {
    /**
     * Constructor que inicializa un Sprite con su numero de serie.
     * 
     * @param serie el numero de serie del producto
     */
    public Sprite(int serie){
        super(serie);
    }
    
    /**
     * Devuelve el nombre del producto cuando se consume.
     * 
     * @return "sprite"
     */
    @Override
    public String consumir(){
        return "sprite";
    }
}