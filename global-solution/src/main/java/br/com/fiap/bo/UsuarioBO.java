package br.com.fiap.bo;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.excecoes.ExcecoesCadastro;

import java.sql.SQLException;

public class UsuarioBO {

    private UsuarioDAO usuarioDAO;

    public UsuarioBO() throws SQLException, ClassNotFoundException {
            this.usuarioDAO = new UsuarioDAO();
    }

    // regras de negócio para cadastro de usuário
    public String validarUsuario(Usuario usuario) throws SQLException, ExcecoesCadastro {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new ExcecoesCadastro("Campo obrigatório.");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new ExcecoesCadastro("Campo obrigatório");
        }
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new ExcecoesCadastro("Campo obrigatório");
        }
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new ExcecoesCadastro("Campo obrigatório");
        }

        return usuarioDAO.cadastrarUsuario(usuario);
    }

    // regras de negócio para login de usuário
    public Usuario login(String email, String senha) throws SQLException, ExcecoesCadastro {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Email e senha são obrigatórios.");
        }

        Usuario usuario = usuarioDAO.buscarPorEmailSenha(email, senha);

        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado ou credenciais inválidas.");
        }

        return usuario;
    }
}
