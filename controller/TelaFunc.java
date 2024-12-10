package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFunc extends TelaInicial{
    private JFormattedTextField telaFuncArea;
    private JButton visualizarLivros;
    private JButton adicionarLivro;
    private JButton removerLivro;
    private JPanel painelPrinc;

    public TelaFunc() {
        telaFuncArea.setText("Hub Funcionário");
        visualizarLivros.setText("Visualizar Livros");
        adicionarLivro.setText("Adicionar Livro");
        removerLivro.setText("Remover Livro");

        visualizarLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLivros();
            }
        });
        adicionarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarLivro();
            }
        });
        removerLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerLivro();
            }
        });
    }

    public JFormattedTextField getTelaFuncArea() {
        return telaFuncArea;
    }

    public JButton getVisualizarLivros() {
        return visualizarLivros;
    }

    public JButton getAdicionarLivro() {
        return adicionarLivro;
    }

    public JButton getRemoverLivro() {
        return removerLivro;
    }

    public JPanel getTelaFunc() {
        return painelPrinc;
    }
}
