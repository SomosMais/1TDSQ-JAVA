package br.com.fiap.bo;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.excecoes.ExcecoesCadastro;
import br.com.fiap.excecoes.ExcecoesUsuarioNaoEncontrado;

import java.sql.SQLException;

public class UsuarioBO {

    private UsuarioDAO usuarioDAO;

    public UsuarioBO() throws SQLException, ClassNotFoundException {
        this.usuarioDAO = new UsuarioDAO();
    }

    public UsuarioBO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public String validarUsuario(Usuario usuario) throws SQLException, ExcecoesCadastro {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new ExcecoesCadastro("O campo nome é obrigatório.");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new ExcecoesCadastro("O campo e-mail é obrigatório.");
        }
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new ExcecoesCadastro("O campo senha é obrigatório.");
        }

        return usuarioDAO.cadastrarUsuario(usuario);
    }

    public Usuario login(String email, String senha) throws SQLException, ExcecoesCadastro, ExcecoesUsuarioNaoEncontrado {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            throw new ExcecoesCadastro("Email e senha são obrigatórios.");
        }

        Usuario usuario = usuarioDAO.buscarPorEmailSenha(email, senha);

        if (usuario == null) {
            throw new ExcecoesUsuarioNaoEncontrado("Usuário não encontrado ou credenciais inválidas.");
        }

        return usuario;
    }

    public String atualizarSenha(String email, String novaSenha) throws ExcecoesCadastro, SQLException {
        if (email == null || email.isEmpty()) {
            throw new ExcecoesCadastro("O campo e-mail é obrigatório.");
        }

        if (novaSenha == null || novaSenha.isEmpty()) {
            throw new ExcecoesCadastro("O campo senha é obrigatório.");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(novaSenha);

        return usuarioDAO.atualizar(usuario);
    }

}