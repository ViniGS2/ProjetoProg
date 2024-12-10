package controller;

import model.User;
import service.Library;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial {
    private JPanel panelPrinc;
    private JFormattedTextField bemVindoArea;
    private JButton cadastroCliente;
    private JButton cadastroFuncionario;
    private JButton login;

    static Library library = new Library();
    static User user;

    String ACCOUNTTYPE = "";

    public TelaInicial() {
        bemVindoArea.setText("Seja Bem Vindo");
        cadastroCliente.setText("Cadastro de Cliente");
        cadastroFuncionario.setText("Cadastro funcionário");
        login.setText("Entrar");
        cadastroCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                BibliotecaCadastroClient interfaceClient = new BibliotecaCadastroClient();
                JFrame janela = new JFrame("Biblioteca");
                janela.setContentPane(interfaceClient.getPainelPrinc());
                janela.setSize(800,600);
                janela.setLocationRelativeTo(null);
                janela.setVisible(true);
            }
        });
        cadastroFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BibliotecaCadastroFunc interfaceFunc = new BibliotecaCadastroFunc();
                JFrame janela = new JFrame("Biblioteca");
                janela.setContentPane(interfaceFunc.getPainelPrinc());
                janela.setSize(800,600);
                janela.setLocationRelativeTo(null);
                janela.setVisible(true);

            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BibliotecaLogin interfaceLogin = new BibliotecaLogin();
                JFrame janela = new JFrame("Biblioteca");
                janela.setContentPane(interfaceLogin.getPainelPrinc());
                janela.setSize(800,600);
                janela.setLocationRelativeTo(null);
                janela.setVisible(true);

            }
        });
    }

    public boolean cadastroCliente(String nome, String email, String password) {
        ACCOUNTTYPE = "cliente";
        if(library.isEmailInUse(email)) {
            JOptionPane.showMessageDialog(null, "Email já cadastrado, tente novamente");
            return false;
        }
        else{
            library.signup(nome, email, password, ACCOUNTTYPE);
            return true;
        }
    }

    public boolean cadastroFuncionario(String nome, String email, String password) {
        ACCOUNTTYPE = "funcionario";
        if(library.isEmailInUse(email)) {
            JOptionPane.showMessageDialog(null, "Email já cadastrado, tente novamente");
            return false;
        }
        else{
            library.signup(nome, email, password, ACCOUNTTYPE);
            return true;
        }
    }

    public void pegarLivro(){
        String title = JOptionPane.showInputDialog("Digite o título do livro que deseja pegar emprestado: " + library.getCurrentUser().getName());
        library.borrowBook(title, library.getCurrentUser());
    }

    public void mostrarLivros() {
        if(!library.getBooks().isEmpty()){
            for(int i = 0; i < library.getBooks().size(); i++){
                JOptionPane.showMessageDialog(null, (i+1)+ "." + library.getBooks().get(i), "Livros Disponíveis:", JOptionPane.PLAIN_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Nenhum livro disponível.", "Livros Disponíveis:", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void devolverLivro(){
        String title = JOptionPane.showInputDialog("Digite o título do livro que deseja devolver: " + library.getCurrentUser().getName());
        library.returnBook(title, library.getCurrentUser());
    }

    public void adicionarLivro() {
        String titulo = JOptionPane.showInputDialog("Digite o Título do Livro:");
        String autor = JOptionPane.showInputDialog("Digite o nome do Autor:");
        library.addBook(titulo, autor);
    }

    public void removerLivro() {
        String titulo = JOptionPane.showInputDialog("Digite o Título do Livro:");
        library.removeBook(titulo);
    }

    public void verificarLogin(String email, String senha, String conta) {
        boolean logado = library.isLogged(email, senha);
        if (!logado) {
            JOptionPane.showMessageDialog(null, "Email ou senha incorretos.");
        } else{
            JOptionPane.showMessageDialog(null, "Olá, "+library.getCurrentUser().getName()+"! O que deseja fazer? ");
            if(conta.equals("cliente")) {
                TelaCliente telaCliente = new TelaCliente();
                JFrame janela = new JFrame("Biblioteca");
                janela.setContentPane(telaCliente.getTelaCliente());
                janela.setSize(800,600);
                janela.setLocationRelativeTo(null);
                janela.setVisible(true);
            }
            else{
                TelaFunc telaFuncionario = new TelaFunc();
                JFrame janela = new JFrame("Biblioteca");
                janela.setContentPane(telaFuncionario.getTelaFunc());
                janela.setSize(800,600);
                janela.setLocationRelativeTo(null);
                janela.setVisible(true);
            }
        }
    }

    public JPanel getPanelPrinc() {
        return panelPrinc;
    }

    public JFormattedTextField getBemVindoArea() {
        return bemVindoArea;
    }

    public JButton getCadastroCliente() {
        return cadastroCliente;
    }

    public JButton getCadastroFuncionario() {
        return cadastroFuncionario;
    }
}
