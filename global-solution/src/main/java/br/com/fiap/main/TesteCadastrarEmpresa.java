package br.com.fiap.main;

import br.com.fiap.beans.Empresa;
import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.excecoes.ExcecoesCadastro;

import javax.swing.*;
import java.sql.SQLException;

public class TesteCadastrarEmpresa {

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

        Empresa empresa = new Empresa();
        EmpresaDAO empresaDAO = new EmpresaDAO();

        empresa.setNome(text("Nome da Empresa: "));
        empresa.setEmail(text("Email da Empresa: "));
        empresa.setSenha(text("Senha da Empresa: "));
        empresa.setCnpj(text("Cnpj da Empresa: "));

        System.out.println(empresaDAO.cadastrarEmpresa(empresa));

    }

}
