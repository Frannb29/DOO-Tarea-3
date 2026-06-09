package Logica;

/**
 * Excepcion lanzada cuando no hay producto disponible en el deposito.
 */
public class NoHayProductoException extends Exception{
    public NoHayProductoException(){
        super("No queda producto en el deposito");
    }
}