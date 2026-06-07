package Logica;

public class Comprador {
    private String sonido;
    private int vuelto;
    private Moneda monedaElegida;
    private Estados estado;
    private Deposito <Moneda> monedero;
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
    public void ingresarMoneda(Moneda m){
        if(estado==Estados.SELECCION_MONEDA){
            monedaElegida=m;
            estado=Estados.SELECCION_PRODUCTO;
        }
    }
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