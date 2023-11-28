package com.example.pdv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.pdv.helper.SQLiteDataHelper;
import com.example.pdv.model.Cliente;

public class ClienteDAO {
    private SQLiteDatabase database;
    private SQLiteDataHelper dbHelper;

    public ClienteDAO(Context context) {
        dbHelper = new SQLiteDataHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long adicionarCliente(Cliente cliente) {
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("email", cliente.getEmail());
        return database.insert("clientes", null, values);
    }

    public Cliente buscarClientePorNome(String nome) {
        Cursor cursor = database.query("clientes", null, "nome = ?", new String[]{nome}, null, null, null);
        Cliente cliente = null;
        if (cursor != null && cursor.moveToFirst()) {
            cliente = cursorToCliente(cursor);
            cursor.close();
        }
        return cliente;
    }

    private Cliente cursorToCliente(Cursor cursor) {
        Cliente cliente = new Cliente();
        cliente.setId(cursor.getInt(cursor.getColumnIndex("id")));
        cliente.setNome(cursor.getString(cursor.getColumnIndex("nome")));
        cliente.setEmail(cursor.getString(cursor.getColumnIndex("email")));
        return cliente;
    }
}
