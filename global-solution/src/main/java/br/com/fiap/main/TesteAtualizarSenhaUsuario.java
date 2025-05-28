package br.com.fiap.main;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.excecoes.ExcecoesCadastro;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarSenhaUsuario {


    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) {

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            UsuarioBO usuarioBO = new UsuarioBO(usuarioDAO);

            String email = texto("Informe o e-mail do usuário que deseja atualizar a senha:");
            String novaSenha = texto("Informe a nova senha:");

            String resultado = usuarioBO.atualizarSenha(email, novaSenha);
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
