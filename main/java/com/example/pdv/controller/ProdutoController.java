package com.example.pdv.controller;

import android.content.Context;

import com.example.pdv.dao.ProdutoDAO;
import com.example.pdv.model.Produto;

import android.content.Context;

public class ProdutoController {
    private ProdutoDAO produtoDAO;

    public ProdutoController(Context context) {
        produtoDAO = new ProdutoDAO(context);
    }

    public long cadastrarProduto(String nome, double preco) {
        if (nome.trim().isEmpty() || preco <= 0) {
            return -1; // Retorna -1 se os dados não forem válidos
        }

        produtoDAO.open();
        long idInserido = produtoDAO.adicionarProduto(new Produto(nome, preco));
        produtoDAO.close();

        return idInserido;
    }
}
