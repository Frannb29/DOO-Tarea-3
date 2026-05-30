package logica;

/**
 * Clase que representa una moneda de valor 500.
 * Extiende la clase Moneda e implementa los metodos de valor y comparacion.
 * 
 * @author Tarea DOO
 * @version 1.0
 */
public class Moneda500 extends Moneda {
    /**
     * Constructor que inicializa una moneda de valor 500.
     */
    public Moneda500(){
        super();
    }
    
    /**
     * Obtiene el valor de la moneda (500).
     * 
     * @return 500
     */
    @Override
    public int getValor(){
        return 500;
    }

    /**
     * Compara esta moneda con otra.
     * 
     * @param m la moneda a comparar
     * @return un numero negativo, cero, o positivo si esta moneda es menor, igual o mayor
     */
    @Override
    public int compareTo(Moneda m){
        return Integer.compare(500, m.getValor());
    }

}