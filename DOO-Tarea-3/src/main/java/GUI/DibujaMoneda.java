package GUI;

import javax.swing.JComponent;

import Logica.Moneda;

import java.awt.*;

public class DibujaMoneda extends PosicionDibujo {
    private Moneda moneda;
    public static final int diametro = 40;
    public DibujaMoneda (Moneda moneda, int x, int y){
        super(x,y);
        this.moneda = moneda;
        this.setToolTipText(moneda.toString());
        this.setSize(diametro,diametro);
        this.setBounds(x,y,diametro,diametro);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int diametroDibujo= diametro - 2;

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

        g2d.fillOval(1, 1, diametroDibujo, diametroDibujo);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(1, 1, diametroDibujo, diametroDibujo);

        g2d.setFont(new Font("Arial", Font.BOLD, 10));
        String serieStr = String.valueOf(moneda.getSerie());

        FontMetrics fm = g2d.getFontMetrics();
        int textX = (diametro - fm.stringWidth(serieStr))/2;
        int textY = ((diametro - fm.getHeight())/2) + fm.getAscent();

        g2d.drawString(serieStr, textX, textY);
    }
    public void setXY(int newX, int newY){
        this.x=newX;
        this.y=newY;
        this.setLocation(x, y);
    }
}
