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

    public PanelDeposito(Deposito<?> depo, int xBase, int yBase, boolean esVertical, int tipoElemento) {
        this.depo = depo;
        this.xBase = xBase;
        this.yBase = yBase;
        this.esVertical = esVertical;
        this.tipoElemento = tipoElemento;
        this.vistas = new ArrayList<>();
        
        this.setOpaque(false); 
        sincronizarVistas();
    }

    public void sincronizarVistas() {
        vistas.clear();
        for (int i = 0; i < depo.getSize(); i++) {
            Object item = depo.getElemento(i);
            // tamaño de producto reducido para caber en la ventana de vidrio
            int prodW = 55;
            int prodH = 100;

            if (tipoElemento == 1 && item instanceof Producto) {
                vistas.add(new DibujaProductos((Producto) item, 0, 0, prodW, prodH));
            } else if (tipoElemento == 2 && item instanceof Moneda) {
                vistas.add(new DibujaMoneda((Moneda) item, 0, 0));
            }
        }
        actualizarPosiciones();
    }

    public void actualizarPosiciones() {
        int espacio=10; 
        
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
}