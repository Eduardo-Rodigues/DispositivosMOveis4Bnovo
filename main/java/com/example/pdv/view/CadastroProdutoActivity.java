package com.example.pdv.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pdv.controller.ProdutoController;

public class CadastroProdutoActivity extends AppCompatActivity {

    private EditText editTextNomeProduto;
    private EditText editTextPrecoProduto;
    private Button buttonCadastrarProduto;
    private ProdutoController cadastroProdutoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        editTextNomeProduto = findViewById(R.id.editTextNomeProduto);
        editTextPrecoProduto = findViewById(R.id.editTextPrecoProduto);
        buttonCadastrarProduto = findViewById(R.id.buttonCadastrarProduto);

        cadastroProdutoController = new ProdutoController(this);

        buttonCadastrarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarProduto();
            }
        });
    }

    private void cadastrarProduto() {
        String nomeProduto = editTextNomeProduto.getText().toString();
        String precoStr = editTextPrecoProduto.getText().toString();

        if (!nomeProduto.isEmpty() && !precoStr.isEmpty()) {
            double preco = Double.parseDouble(precoStr);

            long idInserido = cadastroProdutoController.cadastrarProduto(nomeProduto, preco);

            if (idInserido != -1) {
                Toast.makeText(this, "Produto cadastrado com sucesso. ID: " + idInserido, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Erro ao cadastrar produto.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
        }
    }
}
