package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import java.net.URL;

import Logica.*;

/**
 * Clase encargada de crear la representaccion grafica de un producto con imagenes.
 */
public class DibujaProductos extends PosicionDibujo {
    private Producto producto;
    private Image imagenProducto;

    /**
     * Se crea la imagen del producto con sus respectivas coordenadas, tamaño.
     * @param producto producto a dibujar.
     * @param x coordenada x inicial.
     * @param y coordenada y inicial.
     * @param ancho ancho de la imagen.
     * @param alto alto de la imagen.
     */
    public DibujaProductos(Producto producto, int x, int y, int ancho, int alto){
        super(x,y);
        this.producto = producto;
        this.setToolTipText("Serie: " + producto.getSerie());
        this.setBounds(x, y, ancho, alto);

        String nombreArchivo = determinarProducto(producto);
        URL url = getClass().getClassLoader().getResource("imagenes/" + nombreArchivo);

        if (url != null) {
        this.imagenProducto = new ImageIcon(url).getImage();
        }
        else {
        System.err.println("Error: No se pudo encontrar la imagen - " + nombreArchivo);
        }
    }

    /**
     * Busca la subclase especifica de Producto con su respectivo archivo PNG.
     * @param p producto cualquiera a determinar
     * @return Nombre del archivo de la imagen del producto correspondiente.
     */
    private String determinarProducto(Producto p){
        if(p instanceof CocaCola){
            return "coca-cola.png";
        }
        else if (p instanceof Fanta){
            return "fanta.png";
        }
        else if (p instanceof Sprite){
            return "sprite.png";
        }
        else if (p instanceof Super8){
            return "super8.png";
        }
        else{
            return "snickers.png";
        }
    }

    /**
     * Se renderiza la imagen del producto.
     * @param g objeto Graphics utilizado para dibujar en la pantalla.
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        if(imagenProducto != null){
            g2d.drawImage(imagenProducto, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
