package GUI;

import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Logica.*;

/**
 * Clase encargada de gestionar y actualizar la posicion de los elementos (productos y monedas).
 */
public class PanelDeposito extends JPanel {
    
    private Deposito<?> depo; 
    private ArrayList<PosicionDibujo> vistas; 
    private int xBase;
    private int yBase;
    private boolean esVertical;
    private int tipoElemento;
    private Expendedor expendedor;

    /**
     * Constructor de PanelDeposito que inicializa variables.
     * @param expendedor instancia del Expendedor utilizada para acceder al prodcuto comprado.
     * @param depo deposito de los elementos a representar.
     * @param xBase coordenada x inicial.
     * @param yBase coordenada y inicial.
     * @param esVertical determina el orden vertical u horizontal de los elementos.
     * @param tipoElemento identifica si el elemento es un producto o una moneda.
     */
    public PanelDeposito(Expendedor expendedor, Deposito<?> depo, int xBase, int yBase, boolean esVertical, int tipoElemento) {
        this.depo = depo;
        this.xBase = xBase;
        this.yBase = yBase;
        this.esVertical = esVertical;
        this.tipoElemento = tipoElemento;
        this.vistas = new ArrayList<>();
        this.expendedor = expendedor;
        
        this.setOpaque(false); 
        sincronizarVistas();
        this.actualizarPosiciones();

    }

    /**
     * Sincroniza las vistas con los elementos en el deposito.
     */
    public void sincronizarVistas() {
        vistas.clear();
        // caso donde es el deposito unico (producto comprado)
        if (this.depo == null){
            Producto p = this.expendedor.revisaProductoComprado();
            if (p != null){
                int prodW = 65;
                int prodH = 65;
                vistas.add(new DibujaProductos(p, 0, 0, prodW, prodH));
            }
        }
        else{
            for (int i = 0; i < depo.getSize(); i++) {
                if (tipoElemento == 1 && i >= 6) {
                    break; 
                }

                Object item = depo.getElemento(i);
                // tamaño de producto reducido para caber en la ventana de vidrio
                int prodW = 65;
                int prodH = 65;

                if (tipoElemento == 1 && item instanceof Producto) {
                    vistas.add(new DibujaProductos((Producto) item, 0, 0, prodW, prodH));
                } else if (tipoElemento == 2 && item instanceof Moneda) {
                    vistas.add(new DibujaMoneda((Moneda) item, 0, 0, 40));
                } else if (tipoElemento==3 && item instanceof Moneda){
                    vistas.add(new DibujaMoneda((Moneda) item, 0, 0, 10));
                }
            }
        }
        actualizarPosiciones();
    }

    /**
     * Calcula y actualiza las posiciones de los elementos segun su tipo.
     */
    public void actualizarPosiciones() {
        if (tipoElemento == 3) {

            int numColumnas = 11; 
            int anchoColumna = 5; 
            int altoMoneda = 6;  
            int centroColumna = numColumnas / 2; 

            
            int[] conteoPorColumna = new int[numColumnas];

            for (int i = 0; i < vistas.size(); i++) {
                PosicionDibujo vista = vistas.get(i);
                java.util.Random rand = new java.util.Random(12345 + i);
                double gauss = rand.nextGaussian(); 
                int offset = (int) Math.round(gauss * 1.8); 

                int col = centroColumna + offset;
                if (col < 0) col = 0;
                if (col >= numColumnas) col = numColumnas - 1;
                int nuevoX = xBase + (col * anchoColumna);
                int nuevoY = yBase - (conteoPorColumna[col] * altoMoneda);
                conteoPorColumna[col]++; 
                vista.setXY(nuevoX, nuevoY);
            }
        }
        else if (tipoElemento == 2) {

            int contador1000 = 0;
            int contador500 = 0;
            int contador100 = 0;

            for(int i = 0;i < vistas.size();i++){
                PosicionDibujo vista = vistas.get(i);

                if(vista instanceof DibujaMoneda){

                    DibujaMoneda dm = (DibujaMoneda) vista;
                    int valor = dm.getMoneda().getValor();

                    if(valor == 1000){
                        vista.setXY(xBase + contador1000 * 45, yBase + 200);
                        contador1000++;
                    }
                    else if(valor == 500){
                        vista.setXY(xBase + contador500 * 45, yBase + 250);
                        contador500++;
                    }
                    else if(valor == 100){
                        vista.setXY(xBase + contador100 * 45, yBase + 300);
                        contador100++;
                    }
                }
            }
        }
        else {
            int espacio = (tipoElemento == 1) ? -22 : -35;
            
            for (int i = 0; i < vistas.size(); i++) {
                PosicionDibujo vista = vistas.get(i);
                int nuevoX = xBase;
                int nuevoY = yBase;
                
                if (esVertical) {
                    nuevoY += i * (vista.getHeight() + espacio); 
                } else {
                    nuevoX += i * (vista.getWidth() + espacio); 
                }
                
                vista.setXY(nuevoX, nuevoY); 
            }
            this.revalidate();
            this.repaint();
        }
    }

    /**
     * Dibuja las vistas almacenadas en sus posiciones actuales.
     * @param g objeto Graphics utilizado para dibujar en la pantalla.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (PosicionDibujo vista : vistas) {
            Graphics gVista = g.create(vista.getX(), vista.getY(), vista.getWidth(), vista.getHeight());
            vista.paint(gVista);
            gVista.dispose(); 
        }
    }

    public java.util.ArrayList<PosicionDibujo> getVistas(){
        return this.vistas;
    }
}
