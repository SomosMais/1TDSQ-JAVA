package br.com.fiap.main;

import br.com.fiap.model.EnderecoModel;
import br.com.fiap.service.ViaCepService;

import javax.swing.*;
import java.io.IOException;

public class TesteViaCep {

    // String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws IOException {

        ViaCepService objViaCep = new ViaCepService();

        String cep = texto("Informe o CEP para a busca");

        EnderecoModel endereco = objViaCep.getEndereco(cep);

        System.out.println(endereco);

    }
}