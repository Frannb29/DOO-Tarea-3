package GUI;

import javax.swing.JComponent;

import Logica.Moneda;

import java.awt.*;

/**
 * Clase encargada de crear la representaccion grafica de una moneda.
 */
public class DibujaMoneda extends PosicionDibujo {
    private Moneda moneda;
    private int diametro;

    /**
     * Se define la posicion y tamaño de la moneda.
     * @param moneda Moneda de la parte logica.
     * @param x coordenada x donde se creara la moneda.
     * @param y coordenada y donde se creara la moneda.
     * @param diametro diametro visual de la moneda.
     */
    public DibujaMoneda (Moneda moneda, int x, int y, int diametro){
        super(x,y);
        this.moneda = moneda;
        this.diametro=diametro;
        this.setSize(diametro, diametro);
        this.setBounds(x,y,diametro,diametro);
    }

    public Moneda getMoneda() {
        return moneda;
    }

    /**
     * Renderiza los elementos graficos de la moneda
     * @param g objeto Graphics utilizado para dibujar en la pantalla.
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        int valor = moneda.getValor();
        if(valor==1000){
            g2d.setColor(new Color(220, 160, 40));
        }
        else if(valor==500){
            g2d.setColor(new Color(180, 180, 180));
        }
        else{
            g2d.setColor(new Color(191, 137, 48));
        }

        if (diametro >= 30) {
            int diametroDibujo = diametro - 2;
            g2d.fillOval(1, 1, diametroDibujo, diametroDibujo);

            g2d.setColor(Color.BLACK);
            g2d.drawOval(1, 1, diametroDibujo, diametroDibujo);

            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 10));
            String valorStr = "$" + moneda.getValor();
            FontMetrics fm = g2d.getFontMetrics();
            int textX = (diametro - fm.stringWidth(valorStr))/2;
            int textY = ((diametro - fm.getHeight())/2) + fm.getAscent();
            g2d.drawString(valorStr, textX, textY);

        } else {
            int grosor=5;
            
            g2d.fillRoundRect(0, 0, diametro, grosor, 2, 2);
    
            g2d.setColor(new Color(40, 40, 40));
            g2d.drawRoundRect(0, 0, diametro, grosor, 2, 2);
        }
    }
}
