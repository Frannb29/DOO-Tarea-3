package Logica;

/**
 * Simula un comprador que ingresa una moneda, selecciona un producto,
 * realiza la compra y retira el producto junto con el vuelto.
 */
public class Comprador {
    private String sonido;
    private int vuelto;
    private Moneda monedaElegida;
    private Estados estado;
    private Deposito <Moneda> monedero;

    /**
     * Inicializa el estado del comprador y su monedero con monedas disponibles.
     */
    public Comprador(){
        monedero=new Deposito<>();
        this.sonido=null;
        this.vuelto=0;
        this.estado=Estados.SELECCION_MONEDA;
        for(int i=0;i<5;i++){
            monedero.add(new Moneda1000());
        }
        for(int i=0;i<5;i++){
            monedero.add(new Moneda500());
        }
        for(int i=0;i<3;i++){
            monedero.add(new Moneda100());
        }
    }

    /**
     * Al ingresar una moneda permite seleccionar un producto.
     * @param m moneda a ingresar.
     * @return true si la moneda fue aceptada o false si ya tenia una moneda seleccionada.
     */
    public boolean ingresarMoneda(Moneda m){
        if(estado==Estados.SELECCION_MONEDA){
            monedaElegida=m;
            estado=Estados.SELECCION_PRODUCTO;
            return true;
        }
        else{
            monedero.add(m);
            return false;
        }
    }

    /**
     * Procesa la seleccion de moneda y producto, maneja excepciones en
     * el proceso de compra y retiro de producto.
     * @param val valor del producto seleccionado.
     * @param exp expendedor asociado.
     * @throws PagoInsuficienteException compra con una moneda inferior al valor del producto.
     * @throws PagoIncorrectoException moneda no valida
     * @throws NoHayProductoException deposito vacio del producto seleccionado.
     */
    public void comprar(ValorProducto val,Expendedor exp)throws PagoInsuficienteException,PagoIncorrectoException,NoHayProductoException {
        if(estado==Estados.SELECCION_PRODUCTO){
            try{
                exp.comprarProducto(monedaElegida,val);
                estado=Estados.VUELTO;
            }
            catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoException e){
                Moneda mon;
                vuelto=0;
                while((mon=exp.getVuelto())!=null){
                    monedero.add(mon);
                    vuelto+=mon.getValor();
                }
                estado = Estados.SELECCION_MONEDA;
                monedaElegida = null;
                vuelto=0;
                sonido=null;
                throw e;
            }

        }
        else{
            throw new PagoIncorrectoException();
        }
    }

    /**
     * Retiro del producto y vuelto en monedas.
     * @param exp expendedor asociado.
     */
    public void retirarProducto(Expendedor exp){
        if(estado==Estados.VUELTO){
            Producto p= exp.getProducto();
            if(p!=null){
                sonido=p.consumir();
            }
            Moneda mon;
            vuelto=0;
            while((mon=exp.getVuelto())!=null){
                monedero.add(mon);
                vuelto+=mon.getValor();
            }
            estado=Estados.SELECCION_MONEDA;
        }
        else{
            vuelto=0;
            sonido=null;
        }
    }
    public Deposito<Moneda> getMonedero(){
        return monedero;
    }
    public int cuantoVuelto(){
        return vuelto;
    }
    public String queConsumiste(){
        return sonido;
    }
}