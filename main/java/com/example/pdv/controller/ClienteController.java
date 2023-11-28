package com.example.pdv.controller;

import android.content.Context;

import com.example.pdv.dao.ClienteDAO;
import com.example.pdv.model.Cliente;

import android.content.Context;

public class ClienteController {
    private ClienteDAO clienteDAO;

    public ClienteController(Context context) {
        clienteDAO = new ClienteDAO(context);
    }

    public long cadastrarCliente(String nome, String email) {
        if (nome.trim().isEmpty() || !isValidEmail(email)) {
            return -1;
        }

        clienteDAO.open();
        long idInserido = clienteDAO.adicionarCliente(new Cliente(nome, email));
        clienteDAO.close();

        return idInserido;
    }

    private boolean isValidEmail(String email) {
        // Simples validação de email usando expressão regular
        String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regexEmail);
    }
}

