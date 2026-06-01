package logica;

/**
 * Clase que representa la maquina expendedora.
 * Gestiona los depositos de productos y monedas, valida compras y calcula vuelto.
 * 
 * @author Tarea DOO
 * @version 1.0
 */
public class Expendedor {
    private Deposito<CocaCola> coca;
    private Deposito<Sprite> sprite;
    private Deposito<Fanta> fanta;
    private Deposito<Super8> super8;
    private Deposito<Snickers> snickers;
    private Deposito<Moneda> monVu;
    private Deposito<Moneda> monedasPago;
    private Producto DepositoVuelto;

    /**
     * Constructor que inicializa la maquina expendedora con depositos de productos y monedas.
     * Llena cada deposito con una cantidad especificada de productos.
     * 
     * @param cant la cantidad de cada tipo de producto a llenar en los depositos
     */
    public Expendedor(int cant) {
        coca=new Deposito<>();
        sprite=new Deposito<>();
        fanta=new Deposito<>();
        super8=new Deposito<>();
        snickers=new Deposito<>();
        monVu=new Deposito<>();
        monedasPago=new Deposito<>();

        for (int i = 0; i < cant; i++) {

            coca.add(new CocaCola());
            sprite.add(new Sprite());
            fanta.add(new Fanta());
            super8.add(new Super8());
            snickers.add(new Snickers());
        }
        this.DepositoVuelto=null;
    }

    /**
     * Procesa la compra de un producto segun la moneda ingresada.
     * Valida el pago, obtiene el producto del deposito y calcula el vuelto.
     * 
     * @param m la moneda ingresada para la compra
     * @param select el tipo de producto a comprar
     * @return el producto si la compra es exitosa
     * @throws PagoIncorrectoException si la moneda es nula
     * @throws PagoInsuficienteException si el valor de la moneda es menor al precio
     * @throws NoHayProductoException si no hay producto disponible en el deposito
     */
    public void comprarProducto(Moneda m, ValorProducto select) throws PagoIncorrectoException,
        PagoInsuficienteException, NoHayProductoException{

        Producto p=null;
        int precioProducto=select.getPrecio();

        if (m == null) {
            throw new PagoIncorrectoException();

        }
        else if (m.getValor() < precioProducto) {
            monVu.add(m);
            throw new PagoInsuficienteException();
        }

        else{
            switch (select) {
                case COCA:
                    p=coca.get();
                    if (p==null){
                        monVu.add(m);
                        throw new NoHayProductoException();
                    }
                    break;
                
                case SPRITE:
                    p=sprite.get();
                    if (p==null){
                        monVu.add(m);
                        throw new NoHayProductoException();
                    }
                    break;

                case FANTA:
                    p=fanta.get();
                    if (p==null){
                        monVu.add(m);
                        throw new NoHayProductoException();
                    }
                    break;
                
                case SUPER8:
                    p=super8.get();
                    if (p==null){
                        monVu.add(m);
                        throw new NoHayProductoException();
                    }
                    break;
                case SNICKERS:
                    p=snickers.get();
                    if (p==null){
                        monVu.add(m);
                        throw new NoHayProductoException();
                    }
                    break;

                default:
                    monVu.add(m);
                    throw new NoHayProductoException();
            }
            
            int dif = (m.getValor() - precioProducto) / 100;

            for (int i = 0; i < dif; i++) {
                monVu.add(new Moneda100());
            }
        }
        DepositoVuelto=p;
    }

    public Producto getProducto(){
        return DepositoVuelto;
    }

    /**
     * Obtiene y extrae una moneda de vuelto del deposito de monedas.
     * 
     * @return una moneda de vuelto o null si no hay mas vuelto disponible
     */
    public Moneda getVuelto(){
        return monVu.get();
    }

    public Deposito<CocaCola> getDepoCoca(){
        return coca;
    }

    public Deposito<Sprite> getDepoSprite(){
        return sprite;
    }

    public Deposito<Fanta> getDepoFanta(){
        return fanta;
    }

    public Deposito<Super8> getDepoSuper8(){
        return super8;
    }

    public Deposito<Snickers> getDepoSnickers(){
        return snickers;
    }
}
