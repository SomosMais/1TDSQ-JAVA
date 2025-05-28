package br.com.fiap.main;

import br.com.fiap.bo.EmpresaBO;
import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.excecoes.ExcecoesCadastro;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarSenhaEmpresa {

    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) {

        try {
            EmpresaDAO empresaDAO = new EmpresaDAO();
            EmpresaBO empresaBO = new EmpresaBO(empresaDAO);

            String email = texto("Informe o e-mail da empresa que deseja atualizar a senha:");
            String novaSenha = texto("Informe a nova senha:");

            String resultado = empresaBO.atualizarSenha(email, novaSenha);
            JOptionPane.showMessageDialog(null, resultado);


        } catch (ExcecoesCadastro e) {
            JOptionPane.showMessageDialog(null, "Erro de cadastro: " + e.getMessage());
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
        } finally {
            System.out.println("Atualizado com sucesso!");
        }
    }

}
