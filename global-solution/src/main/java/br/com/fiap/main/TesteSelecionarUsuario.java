package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.excecoes.ExcecoesCadastro;

import javax.swing.*;
import java.sql.SQLException;

public class TesteSelecionarUsuario {

    // String
    static String text(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ExcecoesCadastro {

        // Instanciar DAO
        UsuarioDAO objUsuarioDao = new UsuarioDAO();

        // Coletar dados de login
        String email = text("Digite seu email:");
        String senha = text("Digite sua senha:");

        // Buscar usuário no banco
        Usuario usuario = objUsuarioDao.buscarPorEmailSenha(email, senha);

        // Verificar se encontrou
        if (usuario != null) {
            System.out.println("Login realizado com sucesso!");
            System.out.println("Usuário: " + usuario.getNome() + " | Email: " + usuario.getEmail());
        } else {
            System.out.println("Email ou senha incorretos.");
        }
    }

}
