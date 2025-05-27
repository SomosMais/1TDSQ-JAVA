package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.excecoes.ExcecoesCadastro;

import javax.swing.*;
import java.sql.SQLException;

public class TesteCadastrarUsuario {

    // String
    public static String text(String j) {
        return JOptionPane.showInputDialog(j);
    }

    // int
    public static int integer(String j){
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    // double
    public static double real(String j){
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ExcecoesCadastro {

        Usuario objUsuario = new Usuario();
        UsuarioDAO objUsuarioDao = new UsuarioDAO();

        objUsuario.setNome(text("Informe o nome: "));
        objUsuario.setEmail(text("Informe o email: "));
        objUsuario.setSenha(text("Informe a senha: "));
        objUsuario.setCpf(text("Informe o CPF: "));

        System.out.println(objUsuarioDao.cadastrarUsuario(objUsuario));

    }
}
