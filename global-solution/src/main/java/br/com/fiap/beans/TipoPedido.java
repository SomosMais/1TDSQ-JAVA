package br.com.fiap.beans;

public class TipoPedido {

    // visibility, data type and attributes
    private int id;
    private String tipoPedido;

    // constructor empty with superclass
    public TipoPedido() {
        super();
    }

    // full constructor with superclass
    public TipoPedido(int id, String tipoPedido) {
        super();
        this.id = id;
        this.tipoPedido = tipoPedido;
    }

    // getters (return) and setters (entries)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    // toString
    @Override
    public String toString() {
        return "=== Tipo de Pedido ===" +
                "\nid: " + id +
                "\ntipo de Pedido: " + tipoPedido;
    }
}
