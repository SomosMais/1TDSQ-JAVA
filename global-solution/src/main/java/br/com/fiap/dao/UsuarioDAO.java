package br.com.fiap.dao;

import br.com.fiap.beans.Usuario;
import br.com.fiap.conexao.ConnectionFactory;
import br.com.fiap.excecoes.ExcecoesCadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        this.connection = new ConnectionFactory().conexao();
    }

    // cadastrar usuário
    public String cadastrarUsuario(Usuario usuario) throws SQLException, ExcecoesCadastro {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO GS_Usuario (nome_usuario, email_usuario, senha_usuario, cpf) VALUES (?, ?, ?, ?)"
            );

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getCpf());

            stmt.execute();
            stmt.close();

            return "Usuário cadastrado com sucesso!";
        } catch (SQLException e) {
            throw new ExcecoesCadastro("Erro ao cadastrar usuário: " + e.getMessage(), e);
        }
    }
}