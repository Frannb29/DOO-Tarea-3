package GUI;

import javax.swing.*;
import java.awt.*;
import Logica.Moneda100;
import Logica.Moneda500;
import Logica.Moneda1000;

public class PruebaMonedas {
    public static void main(String[] args){
        JFrame ventana = new JFrame("Prueba de Monedas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 300);
        JPanel contenedor = new JPanel();
        contenedor.setLayout(null);
        contenedor.setBackground(Color.WHITE);

        Moneda100 m1 = new Moneda100();
        DibujaMoneda v1 = new DibujaMoneda(m1, 50, 50);
        contenedor.add(v1);

        Moneda100 m2 = new Moneda100();
        DibujaMoneda v2 = new DibujaMoneda(m2, 110, 50);
        contenedor.add(v2);

        Moneda100 m3 = new Moneda100();
        DibujaMoneda v3 = new DibujaMoneda(m3, 170, 50);
        contenedor.add(v3);

        Moneda500 m4 = new Moneda500();
        DibujaMoneda v4 = new DibujaMoneda(m4, 50, 100);
        contenedor.add(v4);

        Moneda500 m5 = new Moneda500();
        DibujaMoneda v5 = new DibujaMoneda(m5, 110, 100);
        contenedor.add(v5);

        Moneda500 m6 = new Moneda500();
        DibujaMoneda v6 = new DibujaMoneda(m6, 170, 100);
        contenedor.add(v6);

        Moneda1000 m7 = new Moneda1000();
        DibujaMoneda v7 = new DibujaMoneda(m7, 50, 150);
        contenedor.add(v7);

        Moneda1000 m8 = new Moneda1000();
        DibujaMoneda v8 = new DibujaMoneda(m8, 110, 150);
        contenedor.add(v8);

        Moneda1000 m9 = new Moneda1000();
        DibujaMoneda v9 = new DibujaMoneda(m9, 170, 150);
        contenedor.add(v9);

        ventana.add(contenedor);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
