package GUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import Logica.*;


public class PanelPrincipal extends JPanel implements MouseListener{
    private PanelExpendedor exp;
    private PanelComprador comp;
    public PanelPrincipal(){
        exp=new PanelExpendedor(new Expendedor(6), 50, 50);
        comp=new PanelComprador(new Comprador(),450,50);
        this.addMouseListener(this);
        this.setBackground(Color.white);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        exp.paintComponent(g);
        comp.paintComponent(g);
    }

    @Override
    public void mousePressed(MouseEvent e){
        int x=e.getX();
        int y=e.getY();
        comp.Click(x,y);
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}
}