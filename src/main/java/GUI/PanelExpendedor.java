package GUI;

import javax.swing.JPanel;

import Logica.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Administra los panales graficos del Expendedor,
 * manteniendo actualizadas las vistas de los paneles de los productos, vuelto
 * y producto comprado,
 * cuando algun panel queda vacio procesa el click para rellenarlo.
 * Dibuja el expendedor.
 */
public class PanelExpendedor extends JPanel {
    private Expendedor expendedor;
    private PanelDeposito panelCoca;
    private PanelDeposito panelSprite;
    private PanelDeposito panelFanta;
    private PanelDeposito panelSuper8;
    private PanelDeposito panelSnickers;
    private PanelDeposito panelMonedas;
    private PanelDeposito panelCompra;

    private int x;
    private int y;

    /**
     * Inicializa los paneles de los elementos.
     * @param expendedor utilizado para acceder al producto comprado.
     * @param x coordenada x inicial.
     * @param y coordenada y inicial.
     */
    public PanelExpendedor(Expendedor expendedor, int x, int y){
        this.expendedor=expendedor;
        this.x=x;
        this.y=y;

        this.panelCoca = new PanelDeposito(expendedor, expendedor.getDepoCoca(), x + 15, y + 20, false, 1);
        this.panelSprite = new PanelDeposito(expendedor, expendedor.getDepoSprite(), x + 15, y + 100, false, 1);
        this.panelFanta = new PanelDeposito(expendedor, expendedor.getDepoFanta(), x + 15, y + 180, false, 1);
        this.panelSuper8 = new PanelDeposito(expendedor, expendedor.getDepoSuper8(), x + 15, y + 260, false, 1);
        this.panelSnickers = new PanelDeposito(expendedor, expendedor.getDepoSnickers(), x + 15, y + 340, false, 1);
        this.panelCompra = new PanelDeposito(expendedor, null, x + 25, y + 448, false, 1);
        this.panelMonedas = new PanelDeposito(expendedor, expendedor.getMonedasVuelto(), x+232, y+485, false, 3);
    }

    /**
     * Actualiza y repinta todos los paneles del expendedor.
     */
    public void actualizarVista(){
        if(panelCoca != null){
            panelCoca.sincronizarVistas();
            panelCoca.repaint();
        }
        if(panelFanta != null){
            panelFanta.sincronizarVistas();
            panelFanta.repaint();
        }
        if(panelSprite != null){
            panelSprite.sincronizarVistas();
            panelSprite.repaint();
        }
        if(panelSnickers != null){
            panelSnickers.sincronizarVistas();
            panelSnickers.repaint();
        }
        if(panelSuper8 != null){
            panelSuper8.sincronizarVistas();
            panelSuper8.repaint();
        }
        if(panelCompra != null){
            panelCompra.sincronizarVistas();
            panelCompra.repaint();
        }
        if(panelMonedas!=null){
            panelMonedas.sincronizarVistas();
            panelMonedas.repaint();
        }
        this.repaint();
    }

    /**
     * Detecta clicks sobre los depositos y los rellena cuando se vacian.
     * @param mouseX coordenada x del mouse.
     * @param mouseY coordenada y del mouse.
     */
    public void procesarClick(int mouseX, int mouseY) {
        if (mouseX>=x+20 && mouseX<=x+292) {
            if (mouseY>=y+20 && mouseY<=y+80) {
                if (expendedor.getDepoCoca().getSize()==0) {
                    for(int i=0; i<10; i++) expendedor.getDepoCoca().add(new CocaCola());
                }
            } 
            
            else if (mouseY>y+80 && mouseY<=y+161) {
                if (expendedor.getDepoSprite().getSize()==0) {
                    for(int i=0; i<10; i++) expendedor.getDepoSprite().add(new Sprite());
                }
            } 
           
            else if (mouseY>y+161 && mouseY<=y+243) {
                if (expendedor.getDepoFanta().getSize()==0) {
                    for(int i=0; i<10; i++) expendedor.getDepoFanta().add(new Fanta());
                }
            } 
            
            else if (mouseY>y+243 && mouseY<=y+320) {
                if (expendedor.getDepoSuper8().getSize()==0) {
                    for(int i=0; i<10; i++) expendedor.getDepoSuper8().add(new Super8());
                }
            } 
           
            else if (mouseY> y+320 && mouseY<=y+403) {
                if (expendedor.getDepoSnickers().getSize()==0) {
                    for(int i=0; i<10; i++) expendedor.getDepoSnickers().add(new Snickers());
                }
            }

            actualizarVista();
        }
    }

    /**
     * Dibuja el expendedor con los paneles de productos.
     * @param g objeto Graphics utilizado para dibujar en la pantalla.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 

        Graphics2D g2d=(Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        dibujarCarcasa(g2d);
        dibujarVidrio(g2d);
        dibujarRepisa(g2d);
        dibujarRanuras(g2d);
        

        if(panelCoca != null){
            panelCoca.paintComponent(g);
        }
        if(panelSprite != null){
            panelSprite.paintComponent(g);
        }
        if(panelFanta != null){
            panelFanta.paintComponent(g);
        }
        if(panelSuper8 != null){
            panelSuper8.paintComponent(g);
        }
        if(panelSnickers != null){
            panelSnickers.paintComponent(g);
        }
        if(panelCompra != null){
            panelCompra.paintComponent(g);
        }
        if(panelMonedas!=null){
            panelMonedas.paintComponent(g);
        }
    }
    
    /**
     * Dibuja las vistas de los paneles en sus posiciones correspondientes.
     * @param g2d objeto Graphics2D utilizado para dibujar en la pantalla.
     */
    private void dibujarCarcasa(Graphics2D g2d) {
        
        Color colorCarcasa=new Color(12,12,12);
        Color reflejo=new Color(55,55,60);

        GradientPaint gpCarcasa=new GradientPaint(x, y, reflejo, x+360, y+525, colorCarcasa);
        g2d.setPaint(gpCarcasa);
        g2d.fillRect(x, y, 360, 535);
        
        g2d.setColor(new Color(255, 255, 255, 30)); 
        g2d.drawLine(x+1, y+1, x+348, y+1);
        g2d.drawLine(x+1, y+1, x+1, y+523);

        g2d.setColor(Color.BLACK);
        g2d.drawLine(x+1, y+524, x+349, y+524);
        g2d.drawLine(x+349, y+1, x+349, y+524);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, 350, 535);
    }
    
    /**
     * Dibuja el vidrio del expendedor.
     * @param g2d objeto Graphics2D utilizado para dibujar en la pantalla.
     */
    private void dibujarVidrio(Graphics2D g2d) {
        int ancho=272;
        int alto=400;

        g2d.setColor(new Color(173, 216, 230, 80)); 
        g2d.fillRect(x + 20, y + 20, ancho, alto); 

        g2d.setColor(new Color(40, 40, 40));
        g2d.drawRect(x+19, y+19, ancho+2, alto+2);

        g2d.setColor(new Color(15, 15, 15));
        g2d.drawRect(x+20, y+20, ancho, alto);
        
        g2d.setColor(new Color(255, 255, 255, 20));
        int[] xReflejos = {x+20, x+150, x+20};
        int[] yReflejos = {y+20, y+20, y+250};
        g2d.fillPolygon(xReflejos, yReflejos, 3);
    }
    
    /**
     * Dibuja las ranuras del expendedor.
     * @param g2d objeto Graphics2D utilizado para dibujar en la pantalla.
     */
    private void dibujarRanuras(Graphics2D g2d) {
        Color interiorOscuro = new Color(5, 5, 5);
        Color bordeMarco = new Color(70, 70, 75);

        // Ranura para ingresar monedas
        int ranuraX=x+304; 
        int ranuraY=y+130; 
        int ranuraW=33;      
        int ranuraH=71;     
        
        Color metalClaro=new Color(210, 210, 215);
        Color metalBase=new Color(160, 160, 165);
        Color metalOscuro=new Color(100, 100, 105);

        GradientPaint gpPlaca=new GradientPaint(ranuraX, ranuraY, metalClaro, ranuraX+ranuraW, ranuraY+ranuraH, metalOscuro);
        g2d.setPaint(gpPlaca);
        g2d.fillRoundRect(ranuraX, ranuraY, ranuraW, ranuraH, 6, 6);
        g2d.setColor(Color.BLACK);
        g2d.drawRoundRect(ranuraX, ranuraY, ranuraW, ranuraH, 6, 6);
        
        g2d.setColor(metalOscuro.darker());
        g2d.fillOval(ranuraX+4, ranuraY+4, 4, 4);
        g2d.fillOval(ranuraX+ranuraW-8, ranuraY+4, 4, 4);
        g2d.fillOval(ranuraX+4, ranuraY+ranuraH-8, 4, 4);
        g2d.fillOval(ranuraX+ranuraW-8, ranuraY+ranuraH-8, 4, 4);

        int circD=19;
        int circX=ranuraX+(ranuraW-circD)/2;
        int circY=ranuraY+10;
        
        GradientPaint gpCirculo=new GradientPaint(circX, circY, metalOscuro, circX, circY+circD, metalClaro);
        g2d.setPaint(gpCirculo);
        g2d.fillOval(circX, circY, circD, circD);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(circX, circY, circD, circD);
        
        g2d.setColor(interiorOscuro);
        g2d.fillRoundRect(circX+8, circY , 3, 19, 2, 2);

        int placaY = ranuraY+35;
        g2d.setPaint(new GradientPaint(ranuraX+5, placaY, metalBase, ranuraX+5, placaY+25, metalOscuro));
        g2d.fillRect(ranuraX+6, placaY, ranuraW-12, 25);
        g2d.setColor(metalOscuro.darker());
        g2d.drawRect(ranuraX+6, placaY, ranuraW-12, 25);

        // Depósito especial para retirar el producto comprado
        GradientPaint gpRetiro = new GradientPaint(x+25, y+450, interiorOscuro, x+25, y+520, new Color(0, 15, 30));
        g2d.setPaint(gpRetiro);
        g2d.fillRect(x+25, y+450, 180, 60); 

        GradientPaint gpMarco = new GradientPaint(x+20, y+445, metalClaro, x+15, y+515, metalOscuro);
        g2d.setPaint(gpMarco);
        g2d.fillRoundRect(x+20, y+445, 190, 70, 5, 5);

        g2d.setPaint(gpRetiro);
        g2d.fillRect(x+25, y+450, 180, 60);
        g2d.setColor(Color.BLACK); 
        g2d.drawRect(x+25, y+450, 180, 60); 
        g2d.drawRoundRect(x+20, y+445, 190, 70, 5, 5);
        
        // Depósito para el vuelto
        g2d.setPaint(gpMarco);
        g2d.fillRoundRect(x+225, y+445, 50, 50, 5, 5);
        
        g2d.setPaint(gpRetiro); 
        g2d.fillRect(x+230, y+450, 40, 40);
        g2d.setColor(Color.BLACK); 
        g2d.drawRect(x+230, y+450, 40, 40);
        g2d.drawRoundRect(x+225, y+445, 50, 50, 5, 5);
    }

    /**
     * Dibuja las repisas del expendedor.
     * @param g2d objeto Graphics2D utilizado para dibujar en la pantalla.
     */
    private void dibujarRepisa(Graphics2D g2d) {
        int alto=10;
        int[] yPosiciones = {80, 161, 243, 320, 403};

        String[] preciosFilas={
            "$"+ValorProducto.COCA.getPrecio(),
            "$"+ValorProducto.SPRITE.getPrecio(),
            "$"+ValorProducto.FANTA.getPrecio(),
            "$"+ValorProducto.SUPER8.getPrecio(),
            "$"+ValorProducto.SNICKERS.getPrecio()
        };

        Color metalRepisaCentro = new Color(160, 160, 165);
        Color metalRepisaSombra = new Color(50, 50, 50);

        for (int i=0; i<yPosiciones.length; i++) {
            int yPos=yPosiciones[i];
            GradientPaint gpRepisa=new GradientPaint(x+21, y+yPos, metalRepisaCentro, x+21, y+yPos+alto, metalRepisaSombra);
            g2d.setPaint(gpRepisa);
            g2d.fillRect(x+21, y+yPos, 271, alto);
            
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x+21, y+yPos, 271, alto);

            int stock = 0;
            switch(i) {
                case 0: stock=expendedor.getDepoCoca().getSize(); break;
                case 1: stock=expendedor.getDepoSprite().getSize(); break;
                case 2: stock=expendedor.getDepoFanta().getSize(); break;
                case 3: stock=expendedor.getDepoSuper8().getSize(); break;
                case 4: stock=expendedor.getDepoSnickers().getSize(); break;
            }

            Color colorLed;
            Color brilloLed;
            if (stock>6) {
                colorLed=new Color(0, 150, 0);       
                brilloLed=new Color(100, 255, 100);  
            } else if (stock>=1) {
                colorLed=new Color(200, 160, 0);     
                brilloLed=new Color(255, 255, 160);  
            } else {
                colorLed=new Color(160, 0, 0);       
                brilloLed=new Color(255, 100, 100);  
            }

            int ledX=x+26;
            int ledY=y+yPos+2;
            int ledDim=6;

            g2d.setColor(colorLed);
            g2d.fillOval(ledX, ledY, ledDim, ledDim);
            g2d.setColor(brilloLed);
            g2d.fillOval(ledX+1, ledY+1, ledDim-3, ledDim-3); 
            g2d.setColor(Color.BLACK);
            g2d.drawOval(ledX, ledY, ledDim, ledDim);

            int anchoTag=38;
            int altoTag=11;
            int tagX=x+245;         
            int tagY=y+yPos+1;     

            g2d.setColor(new Color(20, 20, 20));
            g2d.fillRect(tagX, tagY, anchoTag, altoTag);
            
            g2d.setColor(new Color(75, 75, 75));
            g2d.drawRect(tagX, tagY, anchoTag, altoTag);

            g2d.setColor(new Color(255, 45, 45)); 
            g2d.setFont(new Font("Monospaced", Font.BOLD, 9));

            FontMetrics fm=g2d.getFontMetrics();
            int textoX=tagX+(anchoTag-fm.stringWidth(preciosFilas[i]))/2;
            int textoY=tagY+((altoTag-fm.getHeight())/2)+fm.getAscent();

            g2d.drawString(preciosFilas[i], textoX, textoY);
        }
    

    }

    public PanelDeposito getPanelCoca(){
        return this.panelCoca;
    }

    public PanelDeposito getPanelSprite(){
        return this.panelSprite;
    }

    public PanelDeposito getPanelFanta(){
        return this.panelFanta;
    }

    public PanelDeposito getPanelSuper8(){
        return this.panelSuper8;
    }

    public PanelDeposito getPanelSnickers(){
        return this.panelSnickers;
    }
}
