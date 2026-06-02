package GUI;

import javax.swing.JComponent;

public class PosicionDibujo extends JComponent {
    protected int x, y;

    public PosicionDibujo(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;

        //Mueve el elemento a la posicion x,y con su tamaño definido
        this.setBounds(x, y, this.getWidth(), this.getHeight());
        this.repaint();
    }
}
