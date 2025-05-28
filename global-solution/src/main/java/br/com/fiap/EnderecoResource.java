package br.com.fiap;

import br.com.fiap.beans.Endereco;
import br.com.fiap.model.EnderecoModel;
import br.com.fiap.service.ViaCepService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

@Path("/endereco")
public class EnderecoResource {

    private ViaCepService viaCepService = new ViaCepService();

    @GET
    @Path("/buscar/{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarEndereco(@PathParam("cep") String cep) {
        try {
            EnderecoModel endereco = viaCepService.getEndereco(cep);

            if (endereco.getCep() == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("CEP não encontrado").build();
            }

            return Response.ok(endereco).build();

        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao consultar o endereço: " + e.getMessage()).build();
        }

    }

}
