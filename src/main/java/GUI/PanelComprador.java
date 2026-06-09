package GUI;
import Logica.Comprador;
import Logica.Expendedor;
import Logica.Moneda;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Clase encargada de gestionar y mostrar los botones de monedas.
 */
public class PanelComprador extends JPanel{
    private Comprador comprador;
    private int x;
    private int y;
    private PanelDeposito panelMonedero;
    private Expendedor expendedor;

    /**
     * Constructor del PanelComprador.
     * @param comp Instancia de comprador.
     * @param x coordenada x inicial del panel.
     * @param y coordenada y inicial del panel.
     */
    public PanelComprador(Comprador comp,int x,int y){
        comprador=comp;
        this.x=x;
        this.y=y;
        panelMonedero=new PanelDeposito(expendedor,comprador.getMonedero(),x+20,y+100,false,2);
    }

    /**
     * Metodo para manejar los clicks sobre los botones de seleccionar y agregar monedas del comprador.
     * @param clickX coordendada x del click.
     * @param clickY coordenada y del click.
     */
    public void click(int clickX, int clickY){
        if(clickX >= this.x+20 && clickX<=this.x+140 && clickY>=this.y+150 && clickY<=this.y+190){
            int tamano=comprador.getMonedero().getSize();
            boolean encontrada=false;
            for(int i=0;i<tamano;i++){
                Moneda m=comprador.getMonedero().get();
                if(!encontrada && m!=null && m.getValor()==100){
                    encontrada=true;
                    if(comprador.ingresarMoneda(m)){
                        System.out.println("Moneda de 100 seleccionada");
                    }
                }
                else if(m!=null){
                    comprador.getMonedero().add(m);
                }
            }
        }
        else if(clickX>=this.x+20 && clickX<=this.x+140 && clickY>=this.y+200 && clickY<=this.y+240){
            int tamano=comprador.getMonedero().getSize();
            boolean encontrada=false;
            for(int i=0;i<tamano;i++){
                Moneda m=comprador.getMonedero().get();
                if(!encontrada && m!=null && m.getValor()==500){
                    encontrada=true;
                    if(comprador.ingresarMoneda(m)){
                        System.out.println("Moneda de 500 seleccionada");
                    }
                }
                else if(m!=null){
                    comprador.getMonedero().add(m);
                }
            }
        }
        else if(clickX>=this.x+20 && clickX <= this.x+140 && clickY>=this.y+250 && clickY<=this.y+290){
            int tamano=comprador.getMonedero().getSize();
            boolean encontrada=false;
            for(int i=0;i<tamano;i++){
                Moneda m=comprador.getMonedero().get();
                if(!encontrada && m!=null && m.getValor()==1000){
                    encontrada=true;
                    if(comprador.ingresarMoneda(m)){
                        System.out.println("Moneda de 1000 seleccionada");
                    }
                }
                else if(m!=null){
                    comprador.getMonedero().add(m);
                }
            }
        }
        else if(clickX>=this.x+150 && clickX<=this.x+230 && clickY>=this.y+150 && clickY<=this.y+190){
            comprador.getMonedero().add(new Logica.Moneda100());
            System.out.println("Se ha añadido una moneda de $100");
        }
        else if(clickX>=this.x+150 &&clickX<=this.x+230 && clickY>=this.y+200 && clickY<=this.y+240){
            comprador.getMonedero().add(new Logica.Moneda500());
            System.out.println("Se ha añadido una moneda de $500");
        }
        else if(clickX>=this.x+150 && clickX<=this.x+230 && clickY>=this.y+250 && clickY<=this.y+290){
            comprador.getMonedero().add(new Logica.Moneda1000());
            System.out.println("Se ha añadido una moneda de $1000");
        }
        if (panelMonedero!=null) {
            actualizarVisuales();
        }
    }

    /**
     *  Ordena las monedas segun su valor.
     */
    private void ordenarMonedero(){
        ArrayList<Moneda> listaTemporal=new ArrayList<>();
        Moneda m;
        while((m=comprador.getMonedero().get())!=null){
            listaTemporal.add(m);
        }
        int n=listaTemporal.size();
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(listaTemporal.get(j).compareTo(listaTemporal.get(j+1))<0){
                    Moneda temp=listaTemporal.get(j);
                    listaTemporal.set(j,listaTemporal.get(j+1));
                    listaTemporal.set(j+1,temp);
                }
            }
        }
        for(int i=0;i<listaTemporal.size();i++){
            comprador.getMonedero().add(listaTemporal.get(i));
        }
    }
    public void actualizarVisuales(){
        if (panelMonedero != null){
            ordenarMonedero();
            panelMonedero.sincronizarVistas();
        }
    }
    public PanelDeposito getPanelMonedero(){
        return panelMonedero;
    }

    /**
     *  Dibuja panel del comprador y botones para seleccionar y agregar monedas.
     * @param g g objeto Graphics utilizado para dibujar en la pantalla.
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(70,130,180));
        g.fillRect(x-100,y+20,650,450);

        g.setColor(new Color(205, 127, 50));
        g.fillRect(x+20, y+150, 120, 40);
        g.setColor(Color.BLACK);
        g.drawString("Seleccionar $100", x + 35, y + 175);

        g.setColor(new Color(192, 192, 192));
        g.fillRect(x+20, y+200, 120, 40);
        g.setColor(Color.BLACK);
        g.drawString("Seleccionar $500", x + 35, y + 225);

        g.setColor(new Color(255, 215, 0));
        g.fillRect(x+20, y+250, 120, 40);
        g.setColor(Color.BLACK);
        g.drawString("Seleccionar $1000", x+30, y+275);

        g.setColor(new Color(46, 204, 113));

        g.fillRect(x + 150, y + 150, 80, 40);
        g.setColor(Color.BLACK);
        g.drawString("+$100", x+165, y+175);

        g.setColor(new Color(46, 204, 113));
        g.fillRect(x + 150, y+200, 80, 40);
        g.setColor(Color.BLACK);
        g.drawString("+$500", x+165, y+225);

        g.setColor(new Color(46, 204, 113));
        g.fillRect(x+150, y+250, 80, 40);
        g.setColor(Color.BLACK);
        g.drawString("+$1000", x+160, y+275);

        if (panelMonedero!=null) {
            panelMonedero.paintComponent(g);
        }
    }
}
