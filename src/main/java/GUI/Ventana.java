package GUI;

import javax.swing.*;

public class Ventana extends JFrame{
    PanelPrincipal panel;
    public Ventana(){
        this.setTitle("Maquina Expendedora");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel=new PanelPrincipal();
        this.add(panel);
        this.setVisible(true);
    }
    public static void main(String[] args){
        Ventana v=new Ventana();
    }
}
