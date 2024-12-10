package controller;

import model.Book;
import service.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCliente extends BibliotecaCadastroClient{
    private JFormattedTextField hubClienteArea;
    private JButton verLivros;
    private JButton pegarLivro;
    private JButton devolverLivro;
    private JPanel painelPrinc;


    public JPanel getTelaCliente() {
        return painelPrinc;
    }

    public TelaCliente() {
        hubClienteArea.setText("Hub Cliente");
        verLivros.setText("Ver Livros");
        pegarLivro.setText("Pegar Livros");
        devolverLivro.setText("Devolver Livros");
        verLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLivros();
            }
        });
        pegarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pegarLivro();
            }
        });
        devolverLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                devolverLivro();
            }
        });
    }
}
