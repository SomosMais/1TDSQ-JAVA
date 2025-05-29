package br.com.fiap.dao;

import br.com.fiap.beans.Endereco;
import br.com.fiap.conexao.ConnectionFactory;

import java.sql.*;

public class EnderecoDAO {

    public int cadastrarEndereco(Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection connection = new ConnectionFactory().conexao();

        String sql = "INSERT INTO GS_ENDERECO (logradouro, numero, cep, bairro, cidade, estado) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, endereco.getLogradouro());
        System.out.println("Logradouro: " + endereco.getLogradouro());
        stmt.setInt(2, endereco.getNumero());
        System.out.println("Número do endereço: " + endereco.getNumero());
        stmt.setString(3, endereco.getCep().trim());
        System.out.println("CEP: " + endereco.getCep());
        stmt.setString(4, endereco.getBairro());
        System.out.println("Bairro: " + endereco.getBairro());
        stmt.setString(5, endereco.getCidade());
        stmt.setString(6, endereco.getEstado());

        stmt.executeUpdate();

        PreparedStatement stmtId = connection.prepareStatement("SELECT MAX(id_endereco) FROM GS_ENDERECO");
        ResultSet rs = stmtId.executeQuery();
        int id = 0;
        if (rs.next()) {
            id = rs.getInt(1);
        }

        stmt.close();
        connection.close();

        return id;
    }

}
