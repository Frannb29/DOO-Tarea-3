package GUI;

import javax.swing.JPanel;

import Logica.*;

import java.awt.Color;
import java.awt.Graphics;

public class PanelExpendedor extends JPanel {
    private Expendedor expendedor;
    private PanelDeposito panelCoca;
    private PanelDeposito panelSprite;
    private PanelDeposito panelFanta;
    private PanelDeposito panelSuper8;
    private PanelDeposito panelSnickers;
    private PanelDeposito panelMonedas;
    private PanelDeposito panelVuelto;

    private int x;
    private int y;

    public PanelExpendedor(Expendedor expendedor, int x, int y){
        this.expendedor=expendedor;
        this.x=x;
        this.y=y;

        this.panelCoca = new PanelDeposito(expendedor, expendedor.getDepoCoca(), x + 20, y + 20, false, 1);
        this.panelSprite = new PanelDeposito(expendedor, expendedor.getDepoSprite(), x + 20, y + 90, false, 1);
        this.panelFanta = new PanelDeposito(expendedor, expendedor.getDepoFanta(), x + 20, y + 160, false, 1);
        this.panelSuper8 = new PanelDeposito(expendedor, expendedor.getDepoSuper8(), x + 20, y + 230, false, 1);
        this.panelSnickers = new PanelDeposito(expendedor, expendedor.getDepoSnickers(), x + 20, y + 300, false, 1);
        this.panelVuelto = new PanelDeposito(expendedor, null, x + 20, y + 420, false, 1);

    }

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
        if(panelVuelto != null){
            panelVuelto.sincronizarVistas();
            panelVuelto.repaint();
        }
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        dibujarCarcasa(g);
        dibujarVidrio(g);
        dibujarRanuras(g);

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
        if(panelVuelto != null){
            panelVuelto.paintComponent(g);
        }
    }
    
    
    private void dibujarCarcasa(Graphics g) {
        g.setColor(new Color(220, 50, 50)); 
        g.fillRect(x, y, 300, 500); 

        g.setColor(Color.BLACK);
        g.drawRect(x, y, 300, 500); 
    }
    
    private void dibujarVidrio(Graphics g) {
        g.setColor(new Color(173, 216, 230, 150)); 
        g.fillRect(x + 20, y + 20, 180, 350); 
        
        g.setColor(Color.DARK_GRAY);
        g.drawRect(x + 20, y + 20, 180, 350);
    }
    
    private void dibujarRanuras(Graphics g) {
        // Ranura para ingresar monedas
        g.setColor(Color.BLACK);
        g.fillRect(x + 240, y + 150, 10, 40); 
        
        // Depósito especial para retirar el producto comprado
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x + 20, y + 420, 180, 60); 
        
        // Depósito para el vuelto
        g.setColor(Color.GRAY);
        g.fillRect(x + 230, y + 420, 40, 40);
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
