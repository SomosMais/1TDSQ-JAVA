package br.com.fiap.model;

public class EnderecoModel {

    private String logradouro;
    private String numero;
    private String cep;
    private String bairro;
    private String localidade;
    private String uf;

    public EnderecoModel() {
        super();
    }

    public EnderecoModel(String logradouro, String numero, String cep, String bairro, String localidade, String uf) {
        super();
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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

    public String getLocalidade() {
        return localidade;
    }

    public void setCidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String estado) {
        this.uf = estado;
    }

    @Override
    public String toString() {
        return "=== Informações de Endereco ===" +
                "\nlogradouro: " + logradouro +
                "\nnumero: " + numero +
                "\ncep: " + cep +
                "\nbairro: " + bairro +
                "\ncidade: " + localidade +
                "\nestado: " + uf;
    }
}
