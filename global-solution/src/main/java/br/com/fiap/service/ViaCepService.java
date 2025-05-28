package br.com.fiap.service;

import br.com.fiap.model.EnderecoModel;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ViaCepService {

    public EnderecoModel getEndereco(String cep) throws IOException {
        EnderecoModel endereco = null;

        // Monta a URL da API ViaCEP
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        // Cria a requisição HTTP GET
        HttpGet request = new HttpGet(url);

        // Cria o client HTTP
        CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();

        // Executa a requisição e obtém a resposta
        try (CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                // Converte o conteúdo da resposta em String
                String result = EntityUtils.toString(entity);

                // Converte o JSON para objeto Endereco
                Gson gson = new Gson();
                endereco = gson.fromJson(result, EnderecoModel.class);
            }
        }

        return endereco;
    }
}
