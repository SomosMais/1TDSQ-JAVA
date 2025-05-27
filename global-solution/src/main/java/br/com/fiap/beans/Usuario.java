package br.com.fiap.beans;

public class Usuario {

    // visibility, data type and attributes
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;

    // constructor empty with super class
    public Usuario() {
        super();
    }

    // full constructor with super class
    public Usuario(int id, String nome, String email, String senha, String cpf) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "=== Informações do usuário ===" +
                "\nid: " + id +
                "\nnome: " + nome +
                "\nemail: " + email +
                "\nsenha: " + senha +
                "\ncpf: " + cpf;
    }
}
