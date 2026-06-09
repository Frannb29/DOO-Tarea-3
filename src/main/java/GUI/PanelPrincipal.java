package GUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.net.URL;
import Logica.*;


public class PanelPrincipal extends JPanel implements MouseListener{
    private PanelExpendedor exp;
    private PanelComprador comp;
    private Expendedor expLogica;
    private Comprador compLogica;
    private Image logoCoca;
    private Image logoSprite;
    private Image logoFanta;
    private Image logoSuper8;
    private Image logoSnickers;
    public PanelPrincipal(){
        expLogica=new Expendedor(10);
        compLogica=new Comprador();
        exp=new PanelExpendedor(expLogica, 50, 50);
        comp=new PanelComprador(compLogica,600,50);
        logoCoca = cargarImagen("imagenes/logoCoca.png");
        logoSprite = cargarImagen("imagenes/logoSprite.png");
        logoFanta = cargarImagen("imagenes/logoFanta.png");
        logoSuper8 = cargarImagen("imagenes/logoSuper8.png");
        logoSnickers = cargarImagen("imagenes/logoSnickers.png");
        this.addMouseListener(this);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int xClic=e.getX();
                int yClic=e.getY();
                exp.procesarClick(xClic, yClic);
            }
        });
        this.setBackground(Color.white);
        this.setToolTipText("");
        javax.swing.ToolTipManager.sharedInstance().registerComponent(this);
    }

    public Image cargarImagen(String ruta){
        URL url = getClass().getClassLoader().getResource(ruta);
        if (url != null) {
            return new ImageIcon(url).getImage();
        } else {
            System.err.println("No se encontró la imagen: " + ruta);
            return null;
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        exp.paintComponent(g);
        comp.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawString("Elegir Producto", 520, 80);
        int imagenX=530;
        int imagenAncho=60;
        int imagenAlto=60;
        if (logoCoca != null) g.drawImage(logoCoca,imagenX,90,imagenAncho,imagenAlto,this);
        if (logoSprite != null) g.drawImage(logoSprite,imagenX,165,imagenAncho,imagenAlto,this);
        if (logoFanta != null) g.drawImage(logoFanta,imagenX,240,imagenAncho,imagenAlto,this);
        if (logoSuper8 != null) g.drawImage(logoSuper8,imagenX,315,imagenAncho,imagenAlto,this);
        if (logoSnickers != null) g.drawImage(logoSnickers,imagenX,390,imagenAncho,imagenAlto,this);
    }

    @Override
    public void mousePressed(MouseEvent e){
        int x=e.getX();
        int y=e.getY();
        comp.Click(x,y);
        if(x>=530 && x<=590){
            try{
                if(y>=90 && y<=150){
                    compLogica.comprar(ValorProducto.COCA,expLogica);
                    System.out.println("¡Compraste una CocaCola!");
                    exp.actualizarVista();
                }
                else if(y>=165 && y<=225) {
                    compLogica.comprar(ValorProducto.SPRITE, expLogica);
                    System.out.println("¡Compraste una Sprite!");
                    exp.actualizarVista();
                }
                else if(y>=240 && y<=300) {
                    compLogica.comprar(ValorProducto.FANTA, expLogica);
                    System.out.println("¡Compraste una Fanta!");
                    exp.actualizarVista();
                }
                else if(y>=315 && y<=375) {
                    compLogica.comprar(ValorProducto.SUPER8, expLogica);
                    System.out.println("¡Compraste un Super8!");
                    exp.actualizarVista();
                }
                else if(y>=390 && y<=450) {
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