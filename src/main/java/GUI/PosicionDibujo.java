package GUI;

import javax.swing.JComponent;

/**
 * Clase encargada del reposicionamiento de los elementos.
 */
public class PosicionDibujo extends JComponent {
    protected int x, y;

    /**
     * @param x coordenada x inicial del elemento.
     * @param y coordenada y inicial del elemento.
     */
    public PosicionDibujo(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Mueve el elemento a las nuevas coordenadas x,y con su tamaño respectivo.
     * Se fuerza el rediseño.
     * @param x nueva coordenada x
     * @param y nueva coordenada y
     */
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;

        this.setBounds(x, y, this.getWidth(), this.getHeight());
        this.repaint();
    }
}
