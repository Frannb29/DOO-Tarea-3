package logica;

/**
 * Clase que representa una moneda de valor 100.
 * Extiende la clase Moneda e implementa los metodos de valor y comparacion.
 * 
 * @author Tarea DOO
 * @version 1.0
 */
public class Moneda100 extends Moneda {
    /**
     * Constructor que inicializa una moneda de valor 100.
     */
    public Moneda100(){
        super();
    }

    /**
     * Obtiene el valor de la moneda (100).
     * 
     * @return 100
     */
    @Override
    public int getValor(){
        return 100;
    }

    /**
     * Compara esta moneda con otra.
     * 
     * @param m la moneda a comparar
     * @return un numero negativo, cero, o positivo si esta moneda es menor, igual o mayor
     */
    @Override
    public int compareTo(Moneda m){
        return Integer.compare(100, m.getValor());
    }
}