package br.com.fiap.beans;

public class AreaAtuacao {

    // visibility, data type and attributes
    private int id;
    private String areaAtuacao;

    // constructor empty with superclass
    public AreaAtuacao() {
        super();
    }

    // getters (return) and setters (entries)
    public AreaAtuacao(int id, String areaAtuacao) {
        super();
        this.id = id;
        this.areaAtuacao = areaAtuacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    // toString
    @Override
    public String toString() {
        return "=== Area de Atuação ===" +
                "\nid: " + id +
                "\narea de atuação: " + areaAtuacao;
    }
}
