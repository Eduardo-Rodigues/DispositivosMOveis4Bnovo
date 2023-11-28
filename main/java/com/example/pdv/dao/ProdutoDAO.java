package com.example.pdv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.pdv.helper.SQLiteDataHelper;
import com.example.pdv.model.Produto;

public class ProdutoDAO {
    private SQLiteDatabase database;
    private SQLiteDataHelper dbHelper;

    public ProdutoDAO(Context context) {
        dbHelper = new SQLiteDataHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long adicionarProduto(Produto produto) {
        ContentValues values = new ContentValues();
        values.put("nome", produto.getNome());
        values.put("preco", produto.getPreco());
        return database.insert("produtos", null, values);
    }

}

