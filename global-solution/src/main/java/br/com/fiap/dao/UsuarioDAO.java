package br.com.fiap.dao;

import br.com.fiap.beans.Usuario;
import br.com.fiap.conexao.ConnectionFactory;
import br.com.fiap.excecoes.ExcecoesCadastro;
import java.sql.*;


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
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new ExcecoesCadastro("Erro de integridade: algum campo obrigatório não foi preenchido corretamente.", e);
        } catch (SQLException e) {
            throw new ExcecoesCadastro("Erro ao cadastrar usuário: " + e.getMessage(), e);
        }
    }

    // login
    public Usuario buscarPorEmailSenha(String email, String senha) throws SQLException {
        Usuario usuario = null;

        String sql = "SELECT ID_USUARIO, NOME_USUARIO, EMAIL_USUARIO, SENHA_USUARIO, CPF " +
                "FROM GS_USUARIO WHERE EMAIL_USUARIO = ? AND SENHA_USUARIO = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt("ID_USUARIO"));
            usuario.setNome(rs.getString("NOME_USUARIO"));
            usuario.setEmail(rs.getString("EMAIL_USUARIO"));
            usuario.setSenha(rs.getString("SENHA_USUARIO"));
            usuario.setCpf(rs.getString("CPF"));
        }

        rs.close();
        stmt.close();

        return usuario;
    }
}