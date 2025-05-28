package br.com.fiap;

import br.com.fiap.beans.Empresa;
import br.com.fiap.bo.EmpresaBO;
import br.com.fiap.excecoes.ExcecoesCadastro;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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
}
