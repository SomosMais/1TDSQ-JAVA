package br.com.fiap;

import br.com.fiap.beans.DadosSenha;
import br.com.fiap.beans.Empresa;
import br.com.fiap.bo.EmpresaBO;
import br.com.fiap.excecoes.ExcecoesCadastro;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.print.attribute.standard.Media;
import java.sql.SQLException;

@Path("/empresa")
public class EmpresaResource {

    private EmpresaBO empresaBO;

    public EmpresaResource() throws SQLException, ClassNotFoundException {
        this.empresaBO = new EmpresaBO();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String cadastrar(Empresa empresa) throws SQLException, ClassNotFoundException {
        try {
            return empresaBO.validarEmpresa(empresa);
        } catch (SQLException e) {
            return "Erro no banco de dados: " + e.getMessage();
        } catch (ExcecoesCadastro e) {
            return "Erro de validação: "+ e.getMessage();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Empresa login(Empresa empresa) {
        try {
            return empresaBO.login(empresa.getEmail(), empresa.getSenha());
        } catch (IllegalArgumentException e) {
            return new Empresa();
        } catch (ExcecoesCadastro e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/atualizar-senha")
    public Response atualizarSenha(DadosSenha dados) {

        try {
            empresaBO.atualizarSenha(dados.getEmail(), dados.getNovaSenha());
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
