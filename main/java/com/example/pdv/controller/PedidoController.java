package com.example.pdv.controller;

import android.content.Context;
import com.example.pdv.dao.PedidoDAO;
import com.example.pdv.model.Pedido;
import java.util.List;

import android.content.Context;

public class PedidoController {
    private PedidoDAO pedidoDAO;

    public PedidoController(Context context) {
        pedidoDAO = new PedidoDAO(context);
    }

    public long cadastrarPedido(int idCliente, String produto) {
        if (idCliente <= 0 || produto.trim().isEmpty()) {
            return -1;
        }

        pedidoDAO.open();
        long idInserido = pedidoDAO.adicionarPedido(new Pedido(idCliente, produto));
        pedidoDAO.close();

        return idInserido;
    }
}


