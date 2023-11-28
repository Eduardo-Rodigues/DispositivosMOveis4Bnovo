package com.example.pdv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.pdv.helper.SQLiteDataHelper;
import com.example.pdv.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    private SQLiteDatabase database;
    private SQLiteDataHelper dbHelper;

    public PedidoDAO(Context context) {
        dbHelper = new SQLiteDataHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long adicionarPedido(Pedido pedido) {
        ContentValues values = new ContentValues();
        values.put("idCliente", pedido.getIdCliente());
        values.put("produto", pedido.getProduto());
        return database.insert("pedidos", null, values);
    }

    public List<Pedido> buscarTodosPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        Cursor cursor = database.query("pedidos", null, null, null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                Pedido pedido = new Pedido();
                pedido.setId(cursor.getInt(cursor.getColumnIndex("id")));
                pedido.setIdCliente(cursor.getInt(cursor.getColumnIndex("idCliente")));
                pedido.setProduto(cursor.getString(cursor.getColumnIndex("produto")));
                // Adicionar outros campos se houver

                pedidos.add(pedido);
            }
            cursor.close();
        }

        return pedidos;
    }

}


