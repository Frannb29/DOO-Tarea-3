package GUI;

import logica.*;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class PanelExpendedor extends JPanel {
    private Expendedor expendedor;
    private int x;
    private int y;

    public PanelExpendedor(Expendedor expendedor, int x, int y){
        this.expendedor=expendedor;
        this.x=x;
        this.y=y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        dibujarCarcasa(g);
        dibujarVidrio(g);
        dibujarRanuras(g);
        
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
}
