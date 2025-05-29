package br.com.fiap.beans;

public class Endereco {

    // visibility, data type and attributes
    private int id;
    private String logradouro;
    private String numero;
    private String cep;
    private String bairro;
    private String localidade;
    private String uf;

    // constructor empty with superclass
    public Endereco() {
        super();
    }

    // full constructor with superclass
    public Endereco(int id, String logradouro, String numero, String cep, String bairro, String localidade, String uf) {
        super();
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    // getters (return) and setters (entries)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setLocalidade(String cidade) {
        this.localidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String estado) {
        this.uf = estado;
    }

    // 👉 Getters específicos para o banco
    public String getCidade() {
        return localidade;
    }

    public String getEstado() {
        return uf;
    }

    // toString
    @Override
    public String toString() {
        return "=== Informações de Endereco ===" +
                "\nid: " + id +
                "\nlogradouro: " + logradouro +
                "\nnumero: " + numero +
                "\ncep: " + cep +
                "\nbairro: " + bairro +
                "\ncidade: " + localidade +
                "\nestado: " + uf;
    }
}

