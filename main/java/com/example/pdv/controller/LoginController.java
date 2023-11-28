package com.example.pdv.controller;

import com.example.pdv.dao.UsuarioDAO;
import com.example.pdv.model.Usuario;

public class LoginController {
    private UsuarioDAO usuarioDAO;

    // Definição da enumeração para os erros de login
    public enum LoginError {
        EMPTY_FIELDS,
        INVALID_USER,
        INVALID_PASSWORD,
        NO_ERROR
    }

    public LoginController() {
        usuarioDAO = new UsuarioDAO(context);
    }

    public LoginError realizarLogin(String nome, String senha) {
        if (nome.isEmpty() || senha.isEmpty()) {
            return LoginError.EMPTY_FIELDS;
        }

        usuarioDAO.open();
        Usuario usuario = usuarioDAO.buscarUsuarioPorNome(nome);
        usuarioDAO.close();

        if (usuario == null) {
            return LoginError.INVALID_USER;
        }

        if (!usuario.getSenha().equals(senha)) {
            return LoginError.INVALID_PASSWORD;
        }

        return LoginError.NO_ERROR;
    }
}
