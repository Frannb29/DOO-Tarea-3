package GUI;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import Logica.*;


public class PanelPrincipal extends JPanel {
    private PanelExpendedor exp;
    private PanelComprador comp;
    public PanelPrincipal(){
        exp=new PanelExpendedor(new Expendedor(6), 50, 50);
        comp=new PanelComprador(new Comprador(),450,50);
        this.setBackground(Color.white);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        exp.paintComponent(g);
        comp.paintComponent(g);

    }
}