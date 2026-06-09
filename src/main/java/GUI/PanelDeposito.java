package GUI;

import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Logica.*;

public class PanelDeposito extends JPanel {
    
    private Deposito<?> depo; 
    private ArrayList<PosicionDibujo> vistas; 
    private int xBase;
    private int yBase;
    private boolean esVertical;
    private int tipoElemento;
    private Expendedor expendedor;

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

    public void sincronizarVistas() {
        vistas.clear();
        // caso donde es el deposito unico
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
