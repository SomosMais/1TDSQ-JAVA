package br.com.fiap.beans;

public class DadosSenha {

    // visibility, data type and attributes
    public String email;
    public String novaSenha;

    // constructor empty with superclass
    public DadosSenha() {
        super();
    }

    // full constructor with superclass
    public DadosSenha(String email, String novaSenha) {
        super();
        this.email = email;
        this.novaSenha = novaSenha;
    }

    // getters (return) and setters (entries)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    // toString
    @Override
    public String toString() {
        return "=== Dados Senha ===" +
                "\ne-mail: " + email +
                "\nNova Senha: " + novaSenha;
    }
}
