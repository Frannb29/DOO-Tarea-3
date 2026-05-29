package logica;

/**
 * Clase que representa un comprador que realiza una compra en la maquina expendedora.
 * Maneja el proceso de compra, incluyendo validacion de moneda, producto y vuelto.
 * 
 * @author Tarea DOO
 * @version 1.0
 */
class Comprador {
    private String sonido;
    private int vuelto;

    /**
     * Constructor que realiza una compra en la maquina expendedora.
     * Valida la moneda, obtiene el producto y calcula el vuelto.
     * 
     * @param m la moneda ingresada por el comprador
     * @param cual el tipo de producto a comprar
     * @param exp la maquina expendedora de donde obtener el producto
     * @throws PagoInsuficienteException si el valor de la moneda es menor al precio del producto
     * @throws PagoIncorrectoException si la moneda es nula
     * @throws NoHayProductoException si no hay producto disponible en el depósito
     */
    public Comprador(Moneda m, ValorProducto cual, Expendedor exp) throws PagoInsuficienteException, PagoIncorrectoException,
    NoHayProductoException {
            this.sonido=null;
            this.vuelto=0;

            try{
                exp.comprarProducto(m,cual);
                Producto b = exp.getProducto();
                if(b!=null){
                    this.sonido=b.consumir();
                }
            }
            catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoException e){
                Moneda mon;
                while((mon=exp.getVuelto())!=null){
                    this.vuelto+=mon.getValor();
                }
                throw e;
            }
            Moneda mon;
            while((mon=exp.getVuelto())!=null){
                this.vuelto+=mon.getValor();
            }
        }
    
    /**
     * Obtiene el monto de vuelto generado en la compra.
     * 
     * @return el vuelto en unidades de moneda
     */
    public int cuantoVuelto(){
        return vuelto;
    }
    
    /**
     * Obtiene el nombre del producto consumido.
     * 
     * @return el nombre del producto comprado y consumido
     */
    public String queConsumiste(){
        return sonido;
    }
}