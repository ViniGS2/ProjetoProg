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

    public BibliotecaLogin() {
        loginArea.setText("Login de Usuário");
        emailArea.setText("Inserir E-mail:");
        senhaArea.setText("Inserir Senha:");
        entrar.setText("Entrar");
        entrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = inserirEmail.getText();
                String senha = inserirSenha.getText();
                if(email.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha corretamente os campos de login");
                }
                else {
                    verificarLogin(email, senha);
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
