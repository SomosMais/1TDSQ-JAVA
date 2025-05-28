package br.com.fiap.beans;

public class DadosSenha {

    public String email;
    public String novaSenha;

    public DadosSenha() {
        super();
    }

    public DadosSenha(String email, String novaSenha) {
        super();
        this.email = email;
        this.novaSenha = novaSenha;
    }

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

    @Override
    public String toString() {
        return "=== Dados Senha ===" +
                "\ne-mail: " + email +
                "\nNova Senha: " + novaSenha;
    }
}
