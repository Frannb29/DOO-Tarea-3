package GUI;

import javax.swing.*;
import java.awt.*;

import Logica.*;

public class PruebaProductos {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Prueba de Productos");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 400);
        JPanel contenedor = new JPanel();
        contenedor.setLayout(null);
        contenedor.setBackground(Color.WHITE);

        CocaCola cc = new CocaCola();
        DibujaProductos p1 = new DibujaProductos(cc, 50, 90, 30, 60);
        contenedor.add(p1);

        Fanta f1 = new Fanta();
        DibujaProductos p2 = new DibujaProductos(f1, 150, 90, 30, 60);
        contenedor.add(p2);

        Sprite sp = new Sprite();
        DibujaProductos p3 = new DibujaProductos(sp, 250, 90, 30, 60);
        contenedor.add(p3);

        Snickers sn = new Snickers();
        DibujaProductos p4 = new DibujaProductos(sn, 50, 200, 30, 60);
        contenedor.add(p4);

        Super8 su = new Super8();
        DibujaProductos p5 = new DibujaProductos(su, 150, 200, 30, 60);
        contenedor.add(p5);

        ventana.add(contenedor);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}