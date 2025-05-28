package br.com.fiap.bo;

import br.com.fiap.beans.Empresa;
import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.excecoes.ExcecoesCadastro;

import java.sql.SQLException;

public class EmpresaBO {

    private EmpresaDAO empresaDAO;

    public EmpresaBO() throws SQLException, ClassNotFoundException {
        this.empresaDAO = new EmpresaDAO();
    }

    public EmpresaBO(EmpresaDAO empresaDAO) {
        this.empresaDAO = empresaDAO;
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
    public Empresa login(String email, String senha) throws ExcecoesCadastro {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Email e senha são obrigatórios.");
        }

        Empresa empresa = empresaDAO.buscarPorEmailSenha(email, senha);

        if (empresa == null) {
            throw new IllegalArgumentException("Empresa não encontrada.");
        }

        return empresa;
    }

    public String atualizarSenha(String email, String novaSenha) throws ExcecoesCadastro, SQLException {
        if (email == null || email.isEmpty()) {
            throw new ExcecoesCadastro("O campo e-mail é obrigatório.");
        }

        if (novaSenha == null || novaSenha.isEmpty()) {
            throw new ExcecoesCadastro("O campo senha é obrigatório.");
        }

        Empresa empresa = new Empresa();
        empresa.setEmail(email);
        empresa.setSenha(novaSenha);

        String resultado = empresaDAO.atualizar(empresa);

        if (resultado.equals("Nenhum usuário foi atualizado!")) {
            throw new RuntimeException("Empresa não encontrada para o e-mail informado.");
        }

        return resultado;
    }

}
