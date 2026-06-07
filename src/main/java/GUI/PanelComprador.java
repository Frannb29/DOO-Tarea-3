package GUI;
import Logica.Comprador;
import Logica.Moneda;
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
    public void Click(int clickX,int clickY){
        if(clickX >= this.x + 20 && clickX <= this.x + 140 && clickY >= this.y + 150 && clickY <= this.y + 190){
            System.out.println("Moneda de 100 seleccionada");
            int tamaño=comprador.getMonedero().getSize();
            boolean encontrada=false;
            for(int i=0;i<tamaño;i++){
                Moneda m=comprador.getMonedero().get();
                if(!encontrada && m!=null && m.getValor()==100){
                    encontrada=true;
                    comprador.ingresarMoneda(m);
                }
                else if(m!=null){
                    comprador.getMonedero().add(m);
                }
            }
        }
        else if(clickX >= this.x + 20 && clickX <= this.x + 140 && clickY >= this.y + 200 && clickY <= this.y + 240){
            System.out.println("Moneda de 500 seleccionada");
            int tamaño=comprador.getMonedero().getSize();
            boolean encontrada=false;
            for(int i=0;i<tamaño;i++){
                Moneda m=comprador.getMonedero().get();
                if(!encontrada && m!=null && m.getValor()==500){
                    encontrada=true;
                    comprador.ingresarMoneda(m);
                }
                else if(m!=null){
                    comprador.getMonedero().add(m);
                }
            }
        }
        else if(clickX >= this.x + 20 && clickX <= this.x + 140 && clickY >= this.y + 250 && clickY <= this.y + 290){
            System.out.println("Moneda de 1000 seleccionada");
            int tamaño=comprador.getMonedero().getSize();
            boolean encontrada=false;
            for(int i=0;i<tamaño;i++){
                Moneda m=comprador.getMonedero().get();
                if(!encontrada && m!=null && m.getValor()==1000){
                    encontrada=true;
                    comprador.ingresarMoneda(m);
                }
                else if(m!=null){
                    comprador.getMonedero().add(m);
                }
            }
        }
        if (panelMonedero != null) {
            panelMonedero.sincronizarVistas();
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(70,130,180));
        g.fillRect(x,y,250,400);

        g.setColor(new Color(205, 127, 50));
        g.fillRect(x + 20, y + 150, 120, 40);
        g.setColor(Color.BLACK);
        g.drawString("Ingresar $100", x + 35, y + 175);

        g.setColor(new Color(192, 192, 192));
        g.fillRect(x + 20, y + 200, 120, 40);
        g.setColor(Color.BLACK);
        g.drawString("Ingresar $500", x + 35, y + 225);

        g.setColor(new Color(255, 215, 0));
        g.fillRect(x + 20, y + 250, 120, 40);
        g.setColor(Color.BLACK);
        g.drawString("Ingresar $1000", x + 30, y + 275);

        if (panelMonedero != null) {
            panelMonedero.paintComponent(g);
        }
    }
}
