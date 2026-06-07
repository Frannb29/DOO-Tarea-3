package GUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import Logica.*;


public class PanelPrincipal extends JPanel implements MouseListener{
    private PanelExpendedor exp;
    private PanelComprador comp;
    private Expendedor expLogica;
    private Comprador compLogica;
    public PanelPrincipal(){
        expLogica=new Expendedor(6);
        compLogica=new Comprador();
        exp=new PanelExpendedor(expLogica, 50, 50);
        comp=new PanelComprador(compLogica,450,50);
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
        if(x>=70 && x<=250){
            try{
                if(y>=70 && y<=130){
                    compLogica.comprar(ValorProducto.COCA,expLogica);
                    System.out.println("¡Compraste una CocaCola!");
                }
                else if(y >= 140 && y <= 200) {
                    compLogica.comprar(ValorProducto.SPRITE, expLogica);
                    System.out.println("¡Compraste una Sprite!");
                }
                else if(y >= 210 && y <= 270) {
                    compLogica.comprar(ValorProducto.FANTA, expLogica);
                    System.out.println("¡Compraste una Fanta!");
                }
                else if(y >= 280 && y <= 340) {
                    compLogica.comprar(ValorProducto.SUPER8, expLogica);
                    System.out.println("¡Compraste un Super8!");
                }
                else if(y >= 350 && y <= 410) {
                    compLogica.comprar(ValorProducto.SNICKERS, expLogica);
                    System.out.println("¡Compraste un Snickers!");
                }
            }
            catch(Exception excepcion){
                JOptionPane.showMessageDialog(this,excepcion.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(x >= 70 && x <= 250 && y >= 470 && y <= 530) {
            compLogica.retirarProducto(expLogica);
            String consumido = compLogica.queConsumiste();
            if(consumido!=null){
                System.out.println("Has retirado tu producto: " + consumido);
                System.out.println("Vuelto total recogido: $" + compLogica.cuantoVuelto());
            }
        }
        comp.actualizarVisuales();
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