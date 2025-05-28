package br.com.fiap.beans;

public class Endereco {

    // visibility, data type and attributes
    private String id;
    private String logradouro;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;

    // constructor empty with superclass
    public Endereco() {
        super();
    }

    // full constructor with superclass
    public Endereco(String id, String logradouro, String numero, String cep, String bairro, String cidade, String estado) {
        super();
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    // getters (return) and setters (entries)
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    // toString
    @Override
    public String toString() {
        return "=== Informações de Endereco ===" +
                "\nid: " + id +
                "\nlogradouro: " + logradouro +
                "\nnumero: " + numero +
                "\ncep: " + cep +
                "\nbairro: " + bairro +
                "\ncidade: " + cidade +
                "\nestado: " + estado;
    }
}

