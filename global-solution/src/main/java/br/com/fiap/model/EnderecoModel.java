package br.com.fiap.model;

public class EnderecoModel {

    private String logradouro;
    private int numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;

    public EnderecoModel() {
        super();
    }

    public EnderecoModel(String logradouro, int numero, String cep, String bairro, String cidade, String estado) {
        super();
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "=== Informações de Endereco ===" +
                "\nlogradouro: " + logradouro +
                "\nnumero: " + numero +
                "\ncep: " + cep +
                "\nbairro: " + bairro +
                "\ncidade: " + cidade +
                "\nestado: " + estado;
    }
}
