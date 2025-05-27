package br.com.fiap.excecoes;

public class ExcecoesCadastro extends Exception{

    public ExcecoesCadastro(String mensagem) {
        super(mensagem);
    }

    public ExcecoesCadastro(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }

}
