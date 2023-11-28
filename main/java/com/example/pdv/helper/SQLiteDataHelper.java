package com.example.pdv.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MeuBancoDeDados";
    private static final int DATABASE_VERSION = 1;

    // Tabela Cliente
    private static final String TABLE_CLIENTE = "cliente";
    private static final String CLIENTE_COLUMN_ID = "id";
    private static final String CLIENTE_COLUMN_NOME = "nome";
    // ... outros campos necessários para a tabela Cliente

    // Tabela Pedido
    private static final String TABLE_PEDIDO = "pedido";
    private static final String PEDIDO_COLUMN_ID = "id";
    private static final String PEDIDO_COLUMN_ID_CLIENTE = "idCliente";
    private static final String PEDIDO_COLUMN_PRODUTO = "produto";
    // ... outros campos necessários para a tabela Pedido

    // Tabela Produto
    private static final String TABLE_PRODUTO = "produto";
    private static final String PRODUTO_COLUMN_ID = "id";
    private static final String PRODUTO_COLUMN_NOME = "nome";
    private static final String PRODUTO_COLUMN_PRECO = "preco";
    // ... outros campos necessários para a tabela Produto

    public SQLiteDataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criação da tabela Cliente
        String CREATE_CLIENTE_TABLE = "CREATE TABLE " + TABLE_CLIENTE + "("
                + CLIENTE_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CLIENTE_COLUMN_NOME + " TEXT"
                // ... outros campos da tabela Cliente
                + ")";
        db.execSQL(CREATE_CLIENTE_TABLE);

        // Criação da tabela Pedido
        String CREATE_PEDIDO_TABLE = "CREATE TABLE " + TABLE_PEDIDO + "("
                + PEDIDO_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PEDIDO_COLUMN_ID_CLIENTE + " INTEGER,"
                + PEDIDO_COLUMN_PRODUTO + " TEXT"
                // ... outros campos da tabela Pedido
                + ")";
        db.execSQL(CREATE_PEDIDO_TABLE);

        // Criação da tabela Produto
        String CREATE_PRODUTO_TABLE = "CREATE TABLE " + TABLE_PRODUTO + "("
                + PRODUTO_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PRODUTO_COLUMN_NOME + " TEXT,"
                + PRODUTO_COLUMN_PRECO + " REAL"
                // ... outros campos da tabela Produto
                + ")";
        db.execSQL(CREATE_PRODUTO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Se houver atualização do banco de dados, aqui você pode implementar o código de migração ou recriação das tabelas
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENTE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PEDIDO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUTO);
        onCreate(db);
    }
}
