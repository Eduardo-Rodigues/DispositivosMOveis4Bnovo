package com.example.pdv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.pdv.helper.SQLiteDataHelper;
import com.example.pdv.model.Usuario;

public class UsuarioDAO {
    private SQLiteDatabase database;
    private SQLiteDataHelper dbHelper;

    public UsuarioDAO(Context context) {
        dbHelper = new SQLiteDataHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long adicionarUsuario(Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("senha", usuario.getSenha());
        return database.insert("usuarios", null, values);
    }

    public Usuario buscarUsuarioPorNome(String nome) {
        Cursor cursor = database.query("usuarios", null, "nome = ?", new String[]{nome}, null, null, null);
        Usuario usuario = null;
        if (cursor != null && cursor.moveToFirst()) {
            usuario = cursorToUsuario(cursor);
            cursor.close();
        }
        return usuario;
    }

    private Usuario cursorToUsuario(Cursor cursor) {
        Usuario usuario = new Usuario();
        usuario.setId(cursor.getInt(cursor.getColumnIndex("id")));
        usuario.setNome(cursor.getString(cursor.getColumnIndex("nome")));
        usuario.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
        return usuario;
    }
}
