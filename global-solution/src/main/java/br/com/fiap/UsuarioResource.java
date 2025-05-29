package br.com.fiap;

import br.com.fiap.beans.DadosSenha;
import br.com.fiap.beans.Usuario;
import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.excecoes.ExcecoesCadastro;
import br.com.fiap.excecoes.ExcecoesUsuarioNaoEncontrado;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/usuario")
public class UsuarioResource {

    private UsuarioBO usuarioBO;

    public UsuarioResource() throws SQLException, ClassNotFoundException {
        this.usuarioBO = new UsuarioBO();
    }

//    @POST
//    @Path("/cadastrar")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_PLAIN)
//    public String cadastrar(Usuario usuario) {
//        try {
//            return usuarioBO.validarUsuario(usuario);
//        } catch (SQLException e) {
//            return "Erro no banco de dados: " + e.getMessage();
//        } catch (ExcecoesCadastro e) {
//            return "Erro de validação: " + e.getMessage();
//        }
//    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String cadastrar(Usuario usuario) {
        try {
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            int idEndereco = enderecoDAO.cadastrarEndereco(usuario.getEndereco());
            usuario.getEndereco().setId(idEndereco);

            UsuarioDAO dao = new UsuarioDAO();
            return dao.cadastrarUsuario(usuario);
        } catch (SQLException | ClassNotFoundException e) {
            return "Erro no banco de dados: " + e.getMessage();
        } catch (ExcecoesCadastro e) {
            return "Erro de validação: " + e.getMessage();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario login(Usuario usuario) {
        try {
            return usuarioBO.login(usuario.getEmail(), usuario.getSenha());
        } catch (IllegalArgumentException | SQLException e) {
            return new Usuario();
        } catch (ExcecoesCadastro e) {
            throw new RuntimeException(e);
        } catch (ExcecoesUsuarioNaoEncontrado e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/atualizar-senha")
    public Response atualizarSenha(DadosSenha dados) {

        try {
            usuarioBO.atualizarSenha(dados.getEmail(), dados.getNovaSenha());
            return Response.ok("Senha atualizada com sucesso!").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage()).build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ExcecoesCadastro e) {
            throw new RuntimeException(e);
        }
    }
}
