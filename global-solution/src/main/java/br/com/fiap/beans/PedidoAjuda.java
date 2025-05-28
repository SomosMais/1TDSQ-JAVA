package br.com.fiap.beans;

import java.util.Date;

public class PedidoAjuda {

    // visibility, data type and attributes
    private int id;
    private String tipoPedido;
    private String descricao;
    private Date dataCriacao;
    private Date dataAceitacao;
    private String pedidoUrgente;

    // constructor empty with superclass
    public PedidoAjuda() {
        super();
    }

    // full constructor with superclass
    public PedidoAjuda(int id, String tipoPedido, String descricao, Date dataCriacao, Date dataAceitacao, String pedidoUrgente) {
        super();
        this.id = id;
        this.tipoPedido = tipoPedido;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataAceitacao = dataAceitacao;
        this.pedidoUrgente = pedidoUrgente;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAceitacao() {
        return dataAceitacao;
    }

    public void setDataAceitacao(Date dataAceitacao) {
        this.dataAceitacao = dataAceitacao;
    }

    public String getPedidoUrgente() {
        return pedidoUrgente;
    }

    public void setPedidoUrgente(String pedidoUrgente) {
        this.pedidoUrgente = pedidoUrgente;
    }

    // toString
    @Override
    public String toString() {
        return "=== Pedido Ajuda ===" +
                "\nid: " + id +
                "\ntipo de Pedido: " + tipoPedido +
                "\ndescrição: " + descricao +
                "\ndata Criacao: " + dataCriacao +
                "\ndata Aceitacao: " + dataAceitacao +
                "\npedido Urgente: " + pedidoUrgente;
    }
}
