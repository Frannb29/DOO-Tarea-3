package GUI;

import logica.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class PanelPrincipal extends JPanel {
    private PanelExpendedor exp;
    public PanelPrincipal(){
        
        exp = new PanelExpendedor (new Expendedor(10), 50, 50);
    
        this.setBackground(Color.white);
    }

    @Override
    public void paintComponent(Graphics g){ 
        super.paintComponent(g); 
    
        exp.paintComponent(g); 
       
    }
}