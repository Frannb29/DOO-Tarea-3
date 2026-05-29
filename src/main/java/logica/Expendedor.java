package logica;

/**
 * Clase que representa la maquina expendedora.
 * Gestiona los depositos de productos y monedas, valida compras y calcula vuelto.
 * 
 * @author Tarea DOO
 * @version 1.0
 */
class Expendedor {
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Bebida> fanta;
    private Deposito<Dulce> super8;
    private Deposito<Dulce> snickers;
    private Deposito<Moneda> monVu;

    /**
     * Constructor que inicializa la maquina expendedora con depositos de productos y monedas.
     * Llena cada deposito con una cantidad especificada de productos.
     * 
     * @param cant la cantidad de cada tipo de producto a llenar en los depositos
     */
    public Expendedor(int cant) {
        coca=new Deposito<Bebida>();
        sprite=new Deposito<Bebida>();
        fanta=new Deposito<Bebida>();
        super8=new Deposito<Dulce>();
        snickers=new Deposito<Dulce>();
        monVu=new Deposito<Moneda>();

        for (int i = 0; i < cant; i++) {

            coca.add(new CocaCola(100+i));
            sprite.add(new Sprite(200+i));
            fanta.add(new Fanta(300+i));
            super8.add(new Super8(400+i));
            snickers.add(new Snickers(500+i));
        }
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
    public Producto comprarProducto(Moneda m, ValorProducto select) throws PagoIncorrectoException,
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
            return p;
        }
    }



    /**
     * Obtiene y extrae una moneda de vuelto del deposito de monedas.
     * 
     * @return una moneda de vuelto o null si no hay mas vuelto disponible
     */
    public Moneda getVuelto(){
        return monVu.get();
    }
}
