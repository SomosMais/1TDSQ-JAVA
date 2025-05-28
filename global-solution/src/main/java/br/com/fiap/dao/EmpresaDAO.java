package br.com.fiap.dao;

import br.com.fiap.beans.Empresa;
import br.com.fiap.conexao.ConnectionFactory;
import br.com.fiap.excecoes.ExcecoesCadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class EmpresaDAO {

    private Connection connection;

    public EmpresaDAO() throws SQLException, ClassNotFoundException {
        this.connection = new ConnectionFactory().conexao();
    }

    // cadastrar empresa
    public String cadastrarEmpresa(Empresa empresa) throws ExcecoesCadastro {
        try {
            PreparedStatement stmt = connection.prepareStatement(
              "INSERT INTO GS_Empresa (nome_empresa, email_empresa, senha_empresa, cnpj) VALUES (?, ?, ?, ?)"
            );

            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getEmail());
            stmt.setString(3, empresa.getSenha());
            stmt.setString(4, empresa.getCnpj());

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
    public Empresa buscarPorEmailSenha(String email, String senha) {
        Empresa empresa = null;



    }

}
