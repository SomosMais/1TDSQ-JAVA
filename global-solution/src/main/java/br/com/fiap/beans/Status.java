package br.com.fiap.beans;

public class Status {

    // visibility, data type and attributes
    private int id;
    private String nomeStatus;

    // constructor empty with superclass
    public Status() {
        super();
    }

    // full constructor with superclass
    public Status(int id, String nomeStatus) {
        super();
        this.id = id;
        this.nomeStatus = nomeStatus;
    }

    // getters (return) and setters (entries)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeStatus() {
        return nomeStatus;
    }

    public void setNomeStatus(String nomeStatus) {
        this.nomeStatus = nomeStatus;
    }

    // toString
    @Override
    public String toString() {
        return "=== Status ===" +
                "\nid: " + id +
                "\nnome Status: " + nomeStatus;
    }
}
