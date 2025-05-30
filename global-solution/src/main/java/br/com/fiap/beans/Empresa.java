package br.com.fiap.beans;

public class Empresa {

    // visibility, data type and attributes
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cnpj;
    private Endereco endereco;

    // constructor empty with superclass
    public Empresa() {
        super();
    }

    // full constructor with superclass
    public Empresa(int id, String nome, String email, String senha, String cnpj, Endereco endereco) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    // getters (return) and setters (entries)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    // toString
    @Override
    public String toString() {
        return "=== Informações da Empresa ===" +
                "\nid: " + id +
                "\nnome: " + nome +
                "\nemail: " + email +
                "\nsenha: " + senha +
                "\ncnpj: " + cnpj +
                "\nEndereco: " + endereco;
    }
}
