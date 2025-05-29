package br.com.fiap.dao;

import br.com.fiap.beans.Endereco;
import br.com.fiap.conexao.ConnectionFactory;
import br.com.fiap.model.EnderecoModel;
import br.com.fiap.service.ViaCepService;
import oracle.jdbc.internal.OraclePreparedStatement;

import java.io.IOException;
import java.sql.*;

public class EnderecoDAO {

    public int cadastrarEndereco(Endereco endereco) throws SQLException, ClassNotFoundException {
        ViaCepService viaCepService = new ViaCepService();
        try {
            EnderecoModel enderecoViaCep = viaCepService.getEndereco(endereco.getCep());

            if (enderecoViaCep.getCep() == null) {
                throw new RuntimeException("CEP não encontrado.");
            }

            endereco.setLogradouro(enderecoViaCep.getLogradouro());
            endereco.setBairro(enderecoViaCep.getBairro());
            endereco.setLocalidade(enderecoViaCep.getLocalidade());
            endereco.setUf(enderecoViaCep.getUf());

        } catch (IOException e) {
            throw new RuntimeException("Erro ao consultar o CEP: " + e.getMessage(), e);
        }

        Connection connection = new ConnectionFactory().conexao();

        String sql = "INSERT INTO GS_ENDERECO (logradouro, numero, cep, bairro, cidade, estado) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING id_endereco INTO ?";

        // Precisa fazer cast para OraclePreparedStatement
        OraclePreparedStatement stmt = (OraclePreparedStatement) connection.prepareStatement(sql);

        stmt.setString(1, endereco.getLogradouro());
        stmt.setString(2, endereco.getNumero());
        stmt.setString(3, endereco.getCep());
        stmt.setString(4, endereco.getBairro());
        stmt.setString(5, endereco.getCidade());
        stmt.setString(6, endereco.getEstado());

        // Registrar o parâmetro de retorno
        stmt.registerReturnParameter(7, java.sql.Types.INTEGER);

        stmt.executeUpdate();

        ResultSet rs = stmt.getReturnResultSet();
        int id = 0;
        if (rs.next()) {
            id = rs.getInt(1);
        }

        rs.close();
        stmt.close();

        return id;
    }

    // Metodo auxiliar para setar string ou null no PreparedStatement
    private void setNullableString(PreparedStatement stmt, int index, String value) throws SQLException {
        if (value != null) {
            stmt.setString(index, value);
        } else {
            stmt.setNull(index, Types.VARCHAR);
        }
    }

}
