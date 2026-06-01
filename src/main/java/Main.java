import GUI.*;
import logica.*;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        PanelPrincipal panel = new PanelPrincipal();
        JFrame frame = new JFrame("Expendedor de Bebidas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.add(panel);
        frame.setVisible(true);
        
    }
}
