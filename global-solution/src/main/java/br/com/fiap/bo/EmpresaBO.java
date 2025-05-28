package br.com.fiap.bo;

import br.com.fiap.beans.Empresa;
import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.excecoes.ExcecoesCadastro;

import java.sql.SQLException;

public class EmpresaBO {

    private EmpresaDAO empresaDAO;

    public EmpresaBO() throws SQLException, ClassNotFoundException {
        this.empresaDAO = new EmpresaDAO();
    }

    // regras de negócio para cadastro de empresa
    public String validarEmpresa(Empresa empresa) throws SQLException, ExcecoesCadastro {
        if (empresa.getNome() == null || empresa.getNome().isEmpty()) {
            throw new ExcecoesCadastro("Campo obrigatório.");
        }
        if (empresa.getEmail() == null || empresa.getEmail().isEmpty()) {
            throw new ExcecoesCadastro("Campo obrigatório.");
        }
        if (empresa.getSenha() == null || empresa.getSenha().isEmpty()) {
            throw new ExcecoesCadastro("Campo obrigatório.");
        }
        if (empresa.getCnpj() == null || empresa.getCnpj().isEmpty()) {
            throw new ExcecoesCadastro("Campo obrigatório.");
        }

        return empresaDAO.cadastrarEmpresa(empresa);
    }

    // regras de negócio para login de empresa

}
