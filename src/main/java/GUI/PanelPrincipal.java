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

        this.setToolTipText("");
        javax.swing.ToolTipManager.sharedInstance().registerComponent(this);
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
                    exp.actualizarVista();
                }
                else if(y >= 140 && y <= 200) {
                    compLogica.comprar(ValorProducto.SPRITE, expLogica);
                    System.out.println("¡Compraste una Sprite!");
                    exp.actualizarVista();
                }
                else if(y >= 210 && y <= 270) {
                    compLogica.comprar(ValorProducto.FANTA, expLogica);
                    System.out.println("¡Compraste una Fanta!");
                    exp.actualizarVista();
                }
                else if(y >= 280 && y <= 340) {
                    compLogica.comprar(ValorProducto.SUPER8, expLogica);
                    System.out.println("¡Compraste un Super8!");
                    exp.actualizarVista();
                }
                else if(y >= 350 && y <= 410) {
                    compLogica.comprar(ValorProducto.SNICKERS, expLogica);
                    System.out.println("¡Compraste un Snickers!");
                    exp.actualizarVista();
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
        exp.actualizarVista();
        comp.actualizarVisuales();
        this.repaint();
    }

    @Override
    public String getToolTipText(java.awt.event.MouseEvent event) {
        int mX = event.getX();
        int mY = event.getY();

        //productos de los estantes
        if(mX >= 70 && mX <= 250){
            PanelDeposito estanteSeleccionado = null;

            if(mY >= 70 && mY <= 130){
                estanteSeleccionado = exp.getPanelCoca();
            }
            else if(mY >= 140 && mY <= 200){
                estanteSeleccionado = exp.getPanelSprite();
            }
            else if(mY >= 210 && mY <= 270){
                estanteSeleccionado = exp.getPanelFanta();
            }
            else if(mY >= 280 && mY <= 340){
                estanteSeleccionado = exp.getPanelSuper8();
            }
            else if(mY >= 350 && mY <= 410){
                estanteSeleccionado = exp.getPanelSnickers();
            }

            if(estanteSeleccionado != null){
                java.util.ArrayList<PosicionDibujo> vistas = estanteSeleccionado.getVistas();
                for(int j = 0; j < vistas.size(); j++){
                    PosicionDibujo vista = vistas.get(j);

                    int vX = vista.getX()-20;
                    int vY = vista.getY();

                    if(mX >= vX && mX <= (vX + vista.getWidth()) && mY >= vY && mY <= (vY + vista.getHeight())){

                        if(vista instanceof DibujaProductos){
                            return "Serie: " + ((DibujaProductos) vista).getProducto().getSerie();
                        } else if (vista instanceof DibujaMoneda) {
                            return ((DibujaMoneda) vista).getMoneda().toString();
                        }
                    }
                }
            }
        }

        //producto en deposito del vuelto
        if(mX >= 70 && mX <= 250 && mY >= 470 && mY <= 530) {
            Producto p = this.expLogica.revisaProductoComprado();
            if(p != null){
                return "Serie: " + p.getSerie();
            }
        }

        return super.getToolTipText(event);
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