package logica;

/**
 * Excepcion lanzada cuando no hay producto disponible en el deposito.
 * 
 * @author Tarea DOO
 * @version 1.0
 */
class NoHayProductoException extends Exception{
    public NoHayProductoException(){
        super("No queda producto en el deposito");
    }
}

/**
 * Excepcion lanzada cuando el valor de la moneda ingresada es insuficiente para la compra.
 * 
 * @author Tarea DOO
 * @version 1.0
 */
class PagoInsuficienteException extends Exception{
    public PagoInsuficienteException(){
        super("Pago insuficiente");
    }
}

/**
 * Excepcioñn lanzada cuando no se ha ingresado una moneda valida (moneda nula).
 * 
 * @author Tarea DOO
 * @version 1.0
 */
class PagoIncorrectoException extends Exception{
    public PagoIncorrectoException(){
        super("No se ha ingresado una moneda");
    }
}