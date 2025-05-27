package br.com.fiap;

import br.com.fiap.beans.Usuario;
import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.excecoes.ExcecoesCadastro;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;

@Path("/usuario")
public class UsuarioResource {

    private UsuarioBO usuarioBO;

    public UsuarioResource() throws SQLException, ClassNotFoundException {
        this.usuarioBO = new UsuarioBO();
    }

    // ✅ Cadastro
    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String cadastrar(Usuario usuario) {
        try {
            return usuarioBO.validarUsuario(usuario);
        } catch (SQLException e) {
            return "Erro no banco de dados: " + e.getMessage();
        } catch (ExcecoesCadastro e) {
            return "Erro de validação: " + e.getMessage();
        }
    }

    // 🔐 Login
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario login(Usuario usuario) {
        try {
            return usuarioBO.login(usuario.getEmail(), usuario.getSenha());
        } catch (IllegalArgumentException | SQLException e) {

            return new Usuario();
        }
    }
}
