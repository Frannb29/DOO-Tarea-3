package logica;

/**
 * Clase que representa una moneda de valor 1000.
 * Extiende la clase Moneda e implementa los metodos de valor y comparacion.
 * 
 * @author Tarea DOO
 * @version 1.0
 */
public class Moneda1000 extends Moneda {
    /**
     * Constructor que inicializa una moneda de valor 1000.
     */
    public Moneda1000(){
        super();
    }
    
    /**
     * Obtiene el valor de la moneda (1000).
     * 
     * @return 1000
     */
    @Override
    public int getValor(){
        return 1000;
    }

    /**
     * Compara esta moneda con otra.
     * 
     * @param m la moneda a comparar
     * @return un numero negativo, cero, o positivo si esta moneda es menor, igual o mayor
     */
    @Override
    public int compareTo(Moneda m){
        return Integer.compare(1000, m.getValor());
    }

}