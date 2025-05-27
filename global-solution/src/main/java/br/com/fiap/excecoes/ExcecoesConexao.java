package br.com.fiap.excecoes;

public class ExcecoesConexao extends Exception {

    public ExcecoesConexao() {
        super();
    }

    public ExcecoesConexao(Exception e) {
        super();
        if (e.getClass().toString().equals("class java.lang.ClassNotFoundException")) {
            System.out.println("Erro no driver. Sem comunicação com o banco de dados.");
            e.printStackTrace();
        } else if (e.getClass().toString().equals("class java.sql.SQLException")) {
            System.out.println("Informações de acesso incorreto. Tente novamente.");
            e.printStackTrace();
        } else {
            System.out.println("Falha desconhecida. Tente novamente mais tarde.");
            e.printStackTrace();
        }
    }
}
