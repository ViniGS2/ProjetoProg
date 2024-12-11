package controller;

import javax.swing.*;

public class MainInterf {
    public static void main(String[] args) {
        TelaInicial telaInicial = new TelaInicial();
        JFrame janela = new JFrame("Biblioteca");
        janela.setContentPane(telaInicial.getPanelPrinc());
        janela.setSize(800,600);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
