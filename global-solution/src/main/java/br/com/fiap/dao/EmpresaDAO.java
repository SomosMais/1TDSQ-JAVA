package br.com.fiap.dao;

import br.com.fiap.beans.Empresa;
import br.com.fiap.beans.Usuario;
import br.com.fiap.conexao.ConnectionFactory;
import br.com.fiap.excecoes.ExcecoesCadastro;

import java.sql.*;

public class EmpresaDAO {

    private Connection connection;

    public EmpresaDAO() throws SQLException, ClassNotFoundException {
        this.connection = new ConnectionFactory().conexao();
    }

    public String cadastrarEmpresa(Empresa empresa) throws ExcecoesCadastro {
        try {

            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO GS_Empresa (nome_empresa, email_empresa, senha_empresa, cnpj, id_endereco) VALUES (?, ?, ?, ?, ?)"
            );

            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getEmail());
            stmt.setString(3, empresa.getSenha());
            stmt.setString(4, empresa.getCnpj());
            stmt.setInt(5, empresa.getEndereco().getId());

            stmt.execute();
            stmt.close();

            return "Empresa cadastrada com sucesso!";
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new ExcecoesCadastro("Erro de integridade: algum campo obrigatório não foi preenchido corretamente.", e);
        } catch (SQLException e) {
            throw new ExcecoesCadastro("Erro ao cadastrar empresa: " + e.getMessage(), e);
        }
    }

    // login
    public Empresa buscarPorEmailSenha(String email, String senha) throws ExcecoesCadastro {
        Empresa empresa = null;

        try {
            String sql = "SELECT ID_EMPRESA, NOME_EMPRESA, EMAIL_EMPRESA, SENHA_EMPRESA, CNPJ FROM GS_EMPRESA WHERE EMAIL_EMPRESA = ? AND SENHA_EMPRESA = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                empresa = new Empresa();
                empresa.setId(rs.getInt("ID_EMPRESA"));
                empresa.setNome(rs.getString("NOME_EMPRESA"));
                empresa.setEmail(rs.getString("EMAIL_EMPRESA"));
                empresa.setSenha(rs.getString("SENHA_EMPRESA"));
                empresa.setCnpj(rs.getString("CNPJ"));
            }

            rs.close();
            stmt.close();

            return empresa;
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new ExcecoesCadastro("Erro de integridade: algum campo não foi preenchido corretamente.", e);
        } catch (SQLException e) {
            throw new ExcecoesCadastro("Erro ao fazer login: " + e.getMessage(), e);
        }
    }

    public String atualizar(Empresa empresa) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "UPDATE GS_EMPRESA SET SENHA_EMPRESA = ? WHERE EMAIL_EMPRESA = ?"
        );

        stmt.setString(1, empresa.getSenha());
        stmt.setString(2, empresa.getEmail());


        int linhasAfetadas = stmt.executeUpdate();
        stmt.close();

        return linhasAfetadas > 0 ? "Empresa atualizada com sucesso!" : "Nenhuma empresa foi atualizada!";
    }
}
