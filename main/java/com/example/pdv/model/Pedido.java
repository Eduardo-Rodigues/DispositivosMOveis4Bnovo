package com.example.pdv.model;

public class Pedido {
    private int id;
    private int idCliente;
    private String produto;

    public Pedido(int id, int idCliente, String produto) {
        this.id = id;
        this.idCliente = idCliente;
        this.produto = produto;
    }

    public Pedido() {

    }

    public Pedido(int idCliente, String produto) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }


}
