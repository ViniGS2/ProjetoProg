package controller;

import model.User;
import service.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class BibliotecaCadastroClient extends TelaInicial{
    private JFormattedTextField cadastroArea;
    private JTextField inserirEmail;
    private JTextField inserirSenha;
    private JTextArea senhaArea;
    private JPanel painelPrinc;
    private JTextField nome;
    private JTextArea inserirEmailArea;
    private JTextArea nomeArea;
    private JButton entrar;

    String name;
    String email;
    String password;


    BibliotecaCadastroClient() {
        cadastroArea.setText("Cadastro de Cliente");
        senhaArea.setText("Inserir Senha:");
        inserirEmailArea.setText("Inserir Email:");
        nomeArea.setText("Inserir Nome:");
        entrar.setText("Entrar");
        entrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = nome.getText();
                email = inserirEmail.getText();
                password = inserirSenha.getText();
                if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    boolean seCadastrou = cadastroCliente(name, email, password);
                        if (seCadastrou) {
                            JOptionPane.showMessageDialog(null, name + ", seu cadastro efetuado com sucesso!");
                            TelaCliente telaCliente = new TelaCliente();
                            JFrame janela = new JFrame("Biblioteca");
                            janela.setContentPane(telaCliente.getTelaCliente());
                            janela.setSize(800, 600);
                            janela.setLocationRelativeTo(null);
                            janela.setVisible(true);
                        }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos para prosseguir!");
                }
            }
        });
    }
    public JPanel getPainelPrinc() {
        return painelPrinc;
    }

    public JFormattedTextField getCadastroArea() {
        return cadastroArea;
    }

    public JTextField getInserirEmail() {
        return inserirEmail;
    }

    public JTextField getInserirSenha() {
        return inserirSenha;
    }

    public JTextArea getSenhaArea() {
        return senhaArea;
    }

    public JTextField getNome() {
        return nome;
    }
}
