import javax.swing.*;
import GUI.*;

public class MainGUIPrincipal extends JFrame{
    PanelPrincipal panel;
    public MainGUIPrincipal(){
        this.setTitle("Maquina Expendedora");
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel=new PanelPrincipal();
        this.add(panel);
        this.setVisible(true);
    }
    public static void main(String[] args){
        MainGUIPrincipal main = new MainGUIPrincipal();
    }
}
