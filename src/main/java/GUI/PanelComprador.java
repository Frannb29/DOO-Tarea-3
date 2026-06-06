package GUI;
import Logica.Comprador;
import javax.swing.*;
import java.awt.*;


public class PanelComprador extends JPanel{
    private Comprador comprador;
    private int x;
    private int y;
    private PanelDeposito panelMonedero;
    public PanelComprador(Comprador comp,int x,int y){
        comprador=comp;
        this.x=x;
        this.y=y;
        panelMonedero=new PanelDeposito(comprador.getMonedero(),x+20,y+100,false,2);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(70,130,180));
        g.fillRect(x,y,250,400);
        if (panelMonedero != null) {
            panelMonedero.paintComponent(g);
        }
    }
}
