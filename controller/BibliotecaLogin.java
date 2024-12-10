package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BibliotecaLogin extends TelaInicial {
    private JFormattedTextField loginArea;
    private JTextArea emailArea;
    private JTextField inserirEmail;
    private JTextArea senhaArea;
    private JTextField inserirSenha;
    private JPanel painelPrinc;
    private JButton entrar;
    private JTextArea tipoContaArea;
    private JTextField tipoConta;

    public BibliotecaLogin() {
        loginArea.setText("Login de Usuário");
        emailArea.setText("Inserir E-mail:");
        senhaArea.setText("Inserir Senha:");
        entrar.setText("Entrar");
        tipoContaArea.setText("Inserir o tipo de conta:");
        entrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = inserirEmail.getText();
                String senha = inserirSenha.getText();
                String conta = tipoConta.getText();
                if(conta.equalsIgnoreCase("cliente")||conta.equalsIgnoreCase("funcionario")||conta.equalsIgnoreCase("funcionário")){
                    if(conta.equals("funcionário")){
                        verificarLogin(email, senha, "funcionario");
                    }
                    else{
                        verificarLogin(email, senha, conta);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Preencha corretamente os campos de login");
                }
            }
        });
    }

    public JFormattedTextField getLoginArea() {
        return loginArea;
    }

    public JTextArea getEmailArea() {
        return emailArea;
    }

    public JTextField getInserirEmail() {
        return inserirEmail;
    }

    public JTextArea getSenhaArea() {
        return senhaArea;
    }

    public JTextField getInserirSenha() {
        return inserirSenha;
    }

    public JPanel getPainelPrinc() {
        return painelPrinc;
    }
}
