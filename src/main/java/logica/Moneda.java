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
    private static int serie = 1000;
    private int serieUnica;

    public Moneda(){
        this.serieUnica=serie;
        serie++;
    }
    
    /**
     * Obtiene la serie de la moneda.
     * 
     * @return la moneda actual
     */
    public int getSerie(){
        return this.serieUnica;
    }
    
    /**
     * Obtiene el valor numerico de la moneda.
     * 
     * @return el valor de la moneda
     */
    public abstract int getValor();

    @Override
    public String toString(){
        return "Valor: " + this.getValor() + "Serie: " + this.getSerie();
    }
    
}