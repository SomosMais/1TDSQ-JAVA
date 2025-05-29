package br.com.fiap.main;

import br.com.fiap.beans.Empresa;
import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.excecoes.ExcecoesCadastro;
import br.com.fiap.model.EnderecoModel;
import br.com.fiap.service.ViaCepService;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class TesteCadastrarEmpresa {

    // String
    public static String text(String j) {
        return JOptionPane.showInputDialog(j);
    }

    // int
    public static int integer(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    // double
    public static double real(String j) {
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ExcecoesCadastro {

        try {
            Empresa empresa = new Empresa();
            EmpresaDAO empresaDAO = new EmpresaDAO();

            empresa.setNome(text("Nome da Empresa:"));
            empresa.setEmail(text("Email da Empresa:"));
            empresa.setSenha(text("Senha da Empresa:"));
            empresa.setCnpj(text("CNPJ da Empresa:"));

            String cep = text("Informe o CEP:");

            ViaCepService viaCepService = new ViaCepService();
            EnderecoModel enderecoViaCep = viaCepService.getEndereco(cep);

            if (enderecoViaCep == null || enderecoViaCep.getCep() == null) {
                JOptionPane.showMessageDialog(null, "CEP inválido ou não encontrado.");
                return;
            }

            String numero = text("Informe o número do endereço:");

            Endereco endereco = new Endereco(
                    0,
                    enderecoViaCep.getLogradouro(),
                    numero,
                    enderecoViaCep.getCep(),
                    enderecoViaCep.getBairro(),
                    enderecoViaCep.getLocalidade(),
                    enderecoViaCep.getUf()
            );

            // 🔸 Cadastrar endereço
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            int idEndereco = enderecoDAO.cadastrarEndereco(endereco);
            endereco.setId(idEndereco);

            JOptionPane.showMessageDialog(null, "Endereço cadastrado com sucesso! ID: " + idEndereco);

            // 🔸 Vincular endereço à empresa
            empresa.setEndereco(endereco);

            // 🔸 Cadastrar empresa
            String msg = empresaDAO.cadastrarEmpresa(empresa);
            JOptionPane.showMessageDialog(null, msg);

        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
