package br.com.fiap;

import br.com.fiap.beans.DadosSenha;
import br.com.fiap.beans.Empresa;
import br.com.fiap.bo.EmpresaBO;
import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.excecoes.ExcecoesCadastro;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.print.attribute.standard.Media;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Path("/empresa")
public class EmpresaResource {

    EmpresaDAO empresaDAO = new EmpresaDAO();
    EnderecoDAO enderecoDAO = new EnderecoDAO();

    private EmpresaBO empresaBO;

    public EmpresaResource() throws SQLException, ClassNotFoundException {
        this.empresaBO = new EmpresaBO();
    }

//    @POST
//    @Path("/cadastrar")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_PLAIN)
//    public String cadastrar(Empresa empresa) throws SQLException, ClassNotFoundException {
//        try {
//            return empresaBO.validarEmpresa(empresa);
//        } catch (SQLException e) {
//            return "Erro no banco de dados: " + e.getMessage();
//        } catch (ExcecoesCadastro e) {
//            return "Erro de validação: "+ e.getMessage();
//        }
//    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String cadastrarEmpresa(Empresa empresa) {
        try {
            // 1. Cadastra o endereço primeiro
            int idEndereco = enderecoDAO.cadastrarEndereco(empresa.getEndereco());
            empresa.getEndereco().setId(idEndereco);

            // 2. Cadastra a empresa
            String resultado = empresaDAO.cadastrarEmpresa(empresa);

            return resultado;
        } catch (SQLIntegrityConstraintViolationException e) {
            return "Erro de integridade: " + e.getMessage();
        } catch (SQLException e) {
            return "Erro no banco de dados: " + e.getMessage();
        } catch (ExcecoesCadastro e) {
            return "Erro de cadastro: " + e.getMessage();
        } catch (ClassNotFoundException e) {
            return "Erro de conexão com o banco: " + e.getMessage();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Empresa empresa) {
        try {
            Empresa resultado = empresaBO.login(empresa.getEmail(), empresa.getSenha());
            return Response.ok(resultado).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"erro\": \"" + e.getMessage() + "\"}")
                    .build();
        } catch (ExcecoesCadastro e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"erro\": \"" + e.getMessage() + "\"}")
                    .build();
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
