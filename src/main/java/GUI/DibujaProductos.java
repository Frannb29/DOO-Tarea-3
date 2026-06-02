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

public class DibujaProductos extends PosicionDibujo {
    private Producto producto;
    private Image imagenProducto;

    public DibujaProductos(Producto producto, int x, int y, int ancho, int alto){
        super(x,y);
        this.producto = producto;
        this.setToolTipText("Serie: " + producto.getSerie());
        this.setSize(ancho, alto);
        this.setBounds(x, y, ancho, alto);

        String nombreArchivo = determinarProducto(producto);
        URL url = getClass().getClassLoader().getResource("imagenes/" + nombreArchivo);

        if (url != null) {
        this.imagenProducto = new ImageIcon(url).getImage();
            } 
        else {
        System.err.println("Error: No se pudo encontrar la imagen - " + nombreArchivo);
            }
        this.imagenProducto = new ImageIcon(url).getImage();
    }

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
