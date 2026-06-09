package Logica;

/**
 * Excepcion lanzada cuando el valor de la moneda ingresada es insuficiente para la compra.
 */
public class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException(){
        super("Pago insuficiente");
    }
}
