package br.com.fiap.main;

import br.com.fiap.beans.Empresa;
import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.excecoes.ExcecoesCadastro;

import javax.swing.*;
import java.sql.SQLException;

public class TesteSelecionarEmpresa {

    // String
    static String text(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws ExcecoesCadastro, SQLException, ClassNotFoundException {

        EmpresaDAO objEmpresaDao = new EmpresaDAO();

        String email = text("Digite o e-mail da empresa: ");
        String senha = text("Digite a senha da empresa: ");

        Empresa empresa = objEmpresaDao.buscarPorEmailSenha(email, senha);

        if (empresa != null) {
            System.out.println("Login realizado com sucesso!");
            System.out.println("Nome empresa: " + empresa.getNome() + " | Email: " + empresa.getEmail());
        } else {
            System.out.println("Email ou senha incorretos.");
        }
    }
}
