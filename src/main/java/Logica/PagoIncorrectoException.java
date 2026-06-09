package Logica;

/**
 * Excepcion lanzada cuando no se ha ingresado una moneda valida (moneda nula).
 */
public class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException(){
        super("No se ha ingresado una moneda");
    }
}
